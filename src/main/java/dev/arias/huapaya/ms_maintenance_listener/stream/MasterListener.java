package dev.arias.huapaya.ms_maintenance_listener.stream;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.arias.huapaya.ms_maintenance_listener.model.Master;
import dev.arias.huapaya.ms_maintenance_listener.persistence.repository.MasterRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@AllArgsConstructor
@Slf4j
public class MasterListener {

    private final MasterRepository masterRepository;

    private final ObjectMapper objectMapper;

    @Bean
    public Consumer<String> consumerMaster() {
        return master -> {
            try {
                Master masterJson = objectMapper.readValue(master, Master.class);
                this.masterRepository.save(Master.builder().description(masterJson.getDescription())
                        .master_details(masterJson.getMaster_details())
                        .created_at(masterJson.getCreated_at())
                        .updated_at(masterJson.getUpdated_at())
                        .status(masterJson.getStatus()).build());
            } catch (JsonProcessingException e) {
                log.error("Error JSON: ", e.getMessage());
            } catch (Exception e) {
                log.error("Error DB: " + e.getMessage());
            }
        };
    }

}
