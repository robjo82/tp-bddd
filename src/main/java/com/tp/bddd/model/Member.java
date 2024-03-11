package com.tp.bddd.model;

import com.tp.bddd.model.enums.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Member {
    @Id
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String id;
    private String lastName;
    private String firstName;
    private Address address;
    private @Email String email;
    private Status status;

    @DBRef
    private Group group;
}
