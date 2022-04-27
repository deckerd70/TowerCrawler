package com.buddy;

public class Armor {
    String slot;
    String name;
    int armorPoints;

    public Armor(){
        String slot;
        String name;
        int armorPoints;
    }

    public Armor(String slot, String name, int armorPoints) {
        this.slot = slot;
        this.name = name;
        this.armorPoints = armorPoints;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArmorPoints() {
        return armorPoints;
    }

    public void setArmorPoints(int armorPoints) {
        this.armorPoints = armorPoints;
    }
}
