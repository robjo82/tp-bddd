package com.tp.bddd.model;

import lombok.Data;

@Data
public class Address {
    private int number;
    private String street;
    private String city;
    private int postalCode;
}
