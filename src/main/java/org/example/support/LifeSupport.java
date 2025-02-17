package org.example.support;

import org.example.enums.Type;
import org.example.interfaces.LifeSupportObserver;

import java.util.ArrayList;
import java.util.List;

public class LifeSupport {
    private boolean isFunctional;
    private int resourceLevel;
    private final Type requiredType;
    private List<LifeSupportObserver> observers = new ArrayList<>();

    public LifeSupport(Type requiredType, int initialResource) {
        this.isFunctional = true;
        this.resourceLevel = initialResource;
        this.requiredType = requiredType;
    }

    public void addObserver(LifeSupportObserver observer) {
        observers.add(observer);
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
                notifyObservers();
            }
        }
    }

    private void notifyObservers() {
        for (LifeSupportObserver observer : observers) {
            observer.onLifeSupportDepleted();
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
