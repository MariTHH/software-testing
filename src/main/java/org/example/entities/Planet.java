package org.example.entities;

import org.example.enums.Type;

abstract class Planet {
    protected String name;
    protected Type type;

    public Planet(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}
