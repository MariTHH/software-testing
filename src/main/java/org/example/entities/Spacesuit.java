package org.example.entities;

import org.example.enums.Type;

public class Spacesuit extends Equipment {
    private final Type type;

    public Spacesuit(String name, int frazzle, Type type) {
        super(name, frazzle);
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
