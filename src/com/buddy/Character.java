package com.buddy;

import com.buddy.WeaponList.Weapon;

import java.util.List;

public class Character {
    String name;
    String charClass;
    int maxHealth;
    int currentHealth;
    int maxActionPoints;
    int currentActionPoints;
    Weapon currentWeapon;
    Armor currentHelmet;
    Armor currentChest;
    Armor currentBoots;
    List<Ammo> ammoBag;
    List<Potion> potionBag;
    List<Object> inventory;

    public Character() {
        String name;
        String charClass;
        int maxHealth;
        int currentHealth;
        int actionPoints;
        int currentActionPoints;
        Weapon currentWeapon;
        Armor currentHelmet;
        Armor currentChest;
        Armor currentBoots;
        List<Ammo> ammoBag;
        List<Potion> potionBag;
    }

    public Character(String name,
                     String charClass,
                     int maxHealth,
                     int currentHealth,
                     int maxActionPoints,
                     int currentActionPoints,
                     Weapon currentWeapon,
                     Armor currentHelmet,
                     Armor currentChest,
                     Armor currentBoots,
                     List<Ammo> ammoBag,
                     List<Potion> potionBag) {
        this.name = name;
        this.charClass = charClass;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.maxActionPoints = maxActionPoints;
        this.currentActionPoints = currentActionPoints;
        this.currentWeapon = currentWeapon;
        this.currentHelmet = currentHelmet;
        this.currentChest = currentChest;
        this.currentBoots = currentBoots;
        this.ammoBag = ammoBag;
        this.potionBag = potionBag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharClass() {
        return charClass;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int health) {
        this.maxHealth = health;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getMaxActionPoints() {
        return maxActionPoints;
    }

    public void setMaxActionPoints(int actionPoints) {
        this.maxActionPoints = actionPoints;
    }

    public int getCurrentActionPoints() {
        return currentActionPoints;
    }

    public void setCurrentActionPoints(int currentActionPoints) {
        this.currentActionPoints = currentActionPoints;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public Armor getCurrentHelmet() {
        return currentHelmet;
    }

    public void setCurrentHelmet(Armor currentHelmet) {
        this.currentHelmet = currentHelmet;
    }

    public Armor getCurrentChest() {
        return currentChest;
    }

    public void setCurrentChest(Armor currentChest) {
        this.currentChest = currentChest;
    }

    public Armor getCurrentBoots() {
        return currentBoots;
    }

    public void setCurrentBoots(Armor currentBoots) {
        this.currentBoots = currentBoots;
    }

    public List<Ammo> getAmmoBag() {
        return ammoBag;
    }

    public void setAmmoBag(List<Ammo> ammoBag) {
        this.ammoBag = ammoBag;
    }

    public List<Potion> getPotionBag() {
        return potionBag;
    }

    public void setPotionBag(List<Potion> potionBag) {
        this.potionBag = potionBag;
    }
}
