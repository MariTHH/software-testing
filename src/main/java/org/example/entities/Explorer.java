package org.example.entities;

import org.example.enums.Type;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Explorer extends Person {
    private final Map<String, String> investigationLog;

    public Explorer(String name, Integer health, Type type, Planet planet, boolean isAlive, List<Equipment> equipment) {
        super(name, health, type, planet, isAlive, equipment);
        this.investigationLog = new HashMap<>();
    }

    private void logInvestigation(Person body, String info) {
        investigationLog.put(body.getName(), investigationLog.getOrDefault(body.getName(), ""));
    }

    public boolean inspectBody(Person body) {
        String status = body.getIsAlive() ? "alive" : "dead";
        logInvestigation(body, status);
        return body.getIsAlive();
    }

    public void determineType(Person body) {
        String typeInfo = switch (body.getType()) {
            case METHAN -> "methan";
            case OXYGEN -> "oxygen";
            default -> "unknown";
        };
        logInvestigation(body, typeInfo);
    }

    public void checkEquipment(Person body) {
        if (body instanceof Policemen policemen) {
            if (policemen.getEquipmentList().isEmpty()) {
                logInvestigation(body, null);
            } else {
                StringBuilder equipmentInfo = new StringBuilder("equipment: ");
                for (Equipment eq : policemen.getEquipmentList()) {
                    equipmentInfo.append(eq.getName()).append(" (frazzle: ").append(eq.getFrazzle()).append("), ");
                }
                logInvestigation(body, equipmentInfo.toString());
            }
        }
    }

    public Equipment retrieveObjectFromBody(Person body, Equipment object) {
        if (!body.getIsAlive()) {
            logInvestigation(body, object.getName());
            return object;
        }
        return null;
    }

}
