package com.tp.bddd.model;

import com.tp.bddd.model.enums.MaterialType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Material {
    @Id
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String id;
    private String serialNumber;
    private String brand;
    private String model;
    private MaterialType type;
    private double price;

    @DBRef
    private Group group;
}
