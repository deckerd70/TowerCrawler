package com.buddy.WeaponList;

public class Ranged extends Weapon{
    String ammoType;

    public Ranged() {

        String ammoType;
    }

    public Ranged(String type, String name, int damage, int actionCost, String ammoType) {
        this.type = type;
        this.name = name;
        this.damage = damage;
        this.actionCost = actionCost;
        this.ammoType = ammoType;
    }
    
    public String getAmmoType() {
        return ammoType;
    }

    public void setAmmoType(String ammoType) {
        this.ammoType = ammoType;
    }
}
