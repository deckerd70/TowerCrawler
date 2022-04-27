package com.buddy;

public class Ammo {
    String name;
    String type;
    int damage;
    int quantity;

    public Ammo() {
        String name;
        String type;
        int damage;
        int quantity;
    }

    public Ammo(String name, String type, int damage, int quantity) {
        this.name = name;
        this.type = type;
        this.damage = damage;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
