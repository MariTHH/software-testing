package org.example.entities;

import org.example.enums.Type;

public abstract class Equipment {
    protected String name;
    protected int frazzle;

    public Equipment(String name, int frazzle) {
        this.name = name;
        this.frazzle = frazzle;
    }

    public static Equipment createEquipment(String typeName, String name, int frazzle, Type type, Person owner) {
        return switch (typeName.toLowerCase()){
            case "spacesuit" -> new Spacesuit(name, frazzle, type);
            case "weapon" -> new Weapon(name, frazzle, owner);
            default -> throw new IllegalArgumentException("Unknown equipment type: " + type);
        };
    }

    public String getName() {
        return name;
    }

    public int getFrazzle() {
        return frazzle;
    }
}
