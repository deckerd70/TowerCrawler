package com.buddy;

public class Ammo {
    //Types of Ammo
    public static final String GREAT_ARROW = "greatarrow";
    public static final String ARROW = "arrow";
    public static final String BOLT = "bolt";

    String name;
    String type;
    int damage;

    public Ammo() {
        String name;
        String type;
        int damage;
    }

    public Ammo(String name, String type, int damage) {
        this.name = name;
        this.type = type;
        this.damage = damage;
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
}
