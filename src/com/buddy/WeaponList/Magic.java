package com.buddy.WeaponList;

public class Magic extends Weapon{
    String name;
    int damage;
    int actionCost;
    String element;

    public Magic() {
        String name;
        float damage;
        float actionCost;
        String element;
    }

    public Magic(String name, int damage, int actionCost, String element) {
        this.name = name;
        this.damage = damage;
        this.actionCost = actionCost;
        this.element = element;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getActionCost() {
        return actionCost;
    }

    public void setActionCost(int actionCost) {
        this.actionCost = actionCost;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }
}
