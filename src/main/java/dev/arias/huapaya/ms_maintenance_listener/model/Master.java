package dev.arias.huapaya.ms_maintenance_listener.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Master {

    @Id
    private String id;

    private String description;

    private List<MasterDetail> master_details;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    private Boolean status;

}