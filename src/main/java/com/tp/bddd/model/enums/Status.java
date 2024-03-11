package com.tp.bddd.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
    CLIENT("Client"),
    SELLER("Seller");

    private final String status;

}
