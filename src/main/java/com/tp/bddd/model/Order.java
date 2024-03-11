package com.tp.bddd.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document
public class Order {
    @Id
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String id;

    @DBRef
    private Member client;

    @DBRef
    private Member seller;

    private LocalDate date;
    private List<Material> materials;
    private double total;
}
