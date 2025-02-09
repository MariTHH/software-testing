package org.example.entities;

import org.example.support.LifeSupport;
import org.example.enums.Type;
import java.util.List;
import java.util.Optional;

public class Policemen extends Person {
    private boolean holdingWeapon;
    private final LifeSupport lifeSupport;

    public Policemen(String name, Integer health, Type type, Planet planet, Boolean isAlive, List<Equipment> equipmentList, boolean holdingWeapon, int lifeSupportCapacity) {
        super(name, health, type, planet, isAlive, equipmentList);
        this.holdingWeapon = false;
        this.lifeSupport = new LifeSupport(type, lifeSupportCapacity);
    }
    public boolean canSurvive() {
        return isSpacesuitFunctional() && lifeSupport.isFunctional();
    }

    public void consumeLifeSupport(int amount) {
        lifeSupport.consumeResource(amount);
    }

    public int getLifeSupportLevel() {
        return lifeSupport.getResourceLevel();
    }

    public void rechargeLifeSupport(int amount) {
        lifeSupport.recharge(amount);
    }
    public boolean isHoldingWeapon() {
        return holdingWeapon;
    }

    public void holdWeapon() {
        Optional<Equipment> weapon = equipmentList.stream()
                .filter(eq -> eq instanceof Weapon)
                .findFirst();
        weapon.ifPresent(eq -> {
            holdingWeapon = true;
        });
    }

    public void dropWeapon() {
        holdingWeapon = false;
    }

    public boolean isSpacesuitFunctional() {
        return equipmentList.stream()
                .filter(eq -> eq instanceof Spacesuit)
                .anyMatch(eq -> eq.getFrazzle() > 0);
    }

}
