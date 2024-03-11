package com.tp.bddd.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MaterialType {
    SCREEN("Screen"),
    KEYBOARD("Keyboard"),
    MOUSE("Mouse"),
    COMPUTER_BOX("Computer box"),
    LAPTOP("Laptop"),
    SOUND_BOX("Sound box"),;

    private final String type;
}
