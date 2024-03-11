package com.tp.bddd.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Group {
    @Id
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String id;
    private String name;
    private String city;
    private int postalCode;
}
