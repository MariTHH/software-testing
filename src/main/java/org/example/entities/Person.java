package org.example.entities;

import org.example.enums.Type;
import java.util.List;

abstract class Person {
    protected String name;
    protected Integer health;
    protected Type type;
    protected Planet planet;
    protected boolean isAlive;
    protected List<Equipment> equipmentList;

    public Person(String name, Integer health, Type type, Planet planet, boolean isAlive, List<Equipment> equipmentList) {
        this.name = name;
        this.health = health;
        this.type = type;
        this.planet = planet;
        this.isAlive = isAlive;
        this.equipmentList = equipmentList;

        validateSurvival();
    }

    private void validateSurvival() {
        if (this.planet.getType() != this.type) {
            if (!hasValidSpacesuit()) {
                throw new IllegalArgumentException(
                        "error " + name + " cant live without suitable spacesuit on " + planet.getName()
                );
            }
        }
    }

    private boolean hasValidSpacesuit() {
        for (Equipment equipment : equipmentList) {
            if (equipment instanceof Spacesuit) {
                Spacesuit suit = (Spacesuit) equipment;
                if (suit.getType() == this.planet.getType()) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public Integer getHealth() {
        return health;
    }

    public Planet getPlanet() {
        return planet;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }
    public void addEquipment(Equipment equipment) {
        equipmentList.add(equipment);
    }

    private void live(Integer health) {
        this.health = health;
        isAlive = health > 0;
    }
}
