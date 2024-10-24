package dev.arias.huapaya.ms_maintenance_listener.model;

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
public class MasterDetail {

    @Id
    private Long id;

    private String description;

    private String value;

    private Boolean status;
}
