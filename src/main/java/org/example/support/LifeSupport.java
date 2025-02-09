package org.example.support;

import org.example.enums.Type;

public class LifeSupport {
    private boolean isFunctional;
    private int resourceLevel;
    private final Type requiredType;

    public LifeSupport(Type requiredType, int initialResource) {
        this.isFunctional = true;
        this.resourceLevel = initialResource;
        this.requiredType = requiredType;
    }

    public boolean isFunctional() {
        return isFunctional && resourceLevel > 0;
    }

    public int getResourceLevel() {
        return resourceLevel;
    }

    public void consumeResource(int amount) {
        if (isFunctional) {
            resourceLevel -= amount;
            if (resourceLevel <= 0) {
                isFunctional = false;
            }
        }
    }

    public void recharge(int amount) {
        resourceLevel += amount;
        if (resourceLevel > 0) {
            isFunctional = true;
        }
    }

    public Type getRequiredType() {
        return requiredType;
    }
}
