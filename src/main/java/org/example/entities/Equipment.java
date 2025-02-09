package org.example.entities;

abstract class Equipment {
    protected String name;
    protected int frazzle;

    public Equipment(String name, int frazzle) {
        this.name = name;
        this.frazzle = frazzle;
    }

    public String getName() {
        return name;
    }

    public int getFrazzle() {
        return frazzle;
    }
}
