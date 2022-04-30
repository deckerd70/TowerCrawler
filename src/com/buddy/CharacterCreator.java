package com.buddy;

import com.buddy.WeaponList.Magic;
import com.buddy.WeaponList.Melee;
import com.buddy.WeaponList.Ranged;
import com.buddy.WeaponList.Weapon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CharacterCreator implements ActionListener, WindowStateListener {
    public static final String WARRIOR_CLASS = "Warrior";
    public static final String BARBARIAN_CLASS = "Barbarian";
    public static final String HUNTER_CLASS = "Hunter";
    public static final String RANGER_CLASS = "Ranger";
    public static final String SENTINEL_CLASS = "Sentinel";
    public static final String MAGE_CLASS = "Mage";
    public static final String WARLOCK_CLASS = "Warlock";
    public static final String PYRO_CLASS = "Pyromancer";


    public final List<Object> EMPTY_INVENTORY = new ArrayList<>();
    public final List<Ammo> EMPTY_AMMO_BAG = new ArrayList<Ammo>();

    public final Potion FIVE_POINT_HP_POTION = new Potion("5 point health potion", "health", 5);
    public final Potion TEN_POINT_AP_POTION = new Potion("10 Point Action Point Potion", "actionPoints", 10);

    static Character playerChar = Main.player;
    String name = JOptionPane.showInputDialog("Enter character name");
    List<Potion> potionBag = new ArrayList<Potion>();

    static Armor ironHat = new Armor("head", "Crude Iron Helmet", 2);
    static Armor ironChest = new Armor("chest", "Crude Iron Chestplate", 6);
    static Armor ironFoot = new Armor("foot", "Crude Iron Boots", 6);
    static Armor furBoots = new Armor("foot", "Fur Boots", 1);
    static Armor furHat = new Armor("head", "Fur Hat", 1);
    static Armor clothHood = new Armor("head", "Cloth Hood", 1);
    static Armor clothRobes = new Armor("chest", "Cloth Robes", 3);

    static JFrame charFrame = new JFrame("Character Class");
    static JButton barbarianButton = new JButton(BARBARIAN_CLASS);
    static JButton warriorButton = new JButton(WARRIOR_CLASS);
    static JButton hunterButton = new JButton(HUNTER_CLASS);
    static JButton rangerButton = new JButton(RANGER_CLASS);
    static JButton sentinelButton = new JButton(SENTINEL_CLASS);
    static JButton mageButton = new JButton(MAGE_CLASS);
    static JButton warlockButton = new JButton(WARLOCK_CLASS);
    static JButton pyroButton = new JButton(PYRO_CLASS);

    public static WindowEvent closeWindow = new WindowEvent(charFrame, WindowEvent.WINDOW_CLOSING);

    public void charSetup() throws InterruptedException {

        charFrame.addWindowStateListener(this);
        barbarianButton.addActionListener(this);
        warriorButton.addActionListener(this);
        hunterButton.addActionListener(this);
        rangerButton.addActionListener(this);
        sentinelButton.addActionListener(this);
        mageButton.addActionListener(this);
        warlockButton.addActionListener(this);
        pyroButton.addActionListener(this);

        barbarianButton.setBounds(100, 200, 120, 40);
        warriorButton.setBounds(200, 200, 120, 40);
        hunterButton.setBounds(300, 200, 120, 40);
        rangerButton.setBounds(100, 300, 120, 40);
        sentinelButton.setBounds(200, 300, 120, 40);
        mageButton.setBounds(300, 300, 120, 40);
        warlockButton.setBounds(150, 400, 120, 40);
        pyroButton.setBounds(250, 400, 120, 40);

        charFrame.add(barbarianButton);
        charFrame.add(warriorButton);
        charFrame.add(hunterButton);
        charFrame.add(rangerButton);
        charFrame.add(sentinelButton);
        charFrame.add(mageButton);
        charFrame.add(warlockButton);
        charFrame.add(pyroButton);

        charFrame.setSize(400,500);
        charFrame.setLayout(null);
        charFrame.setVisible(true);

        while (playerChar.getCurrentWeapon() == null){
            Thread.sleep(5);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        playerChar.setName(name);
        playerChar.setEquipmentInventory(EMPTY_INVENTORY);

        JButton actionSource = (JButton)e.getSource();
        if(actionSource.equals(warriorButton)) {
            Melee warriorSword = new Melee("sword", "Crude Iron Sword", 5, 4);

            playerChar.setCharClass(WARRIOR_CLASS);
            playerChar.setAmmoBag(EMPTY_AMMO_BAG);
            playerChar.setMaxHealth(110);
            playerChar.setCurrentHealth(110);
            playerChar.setMaxActionPoints(20);
            playerChar.setCurrentActionPoints(20);
            playerChar.setCurrentHelmet(ironHat);
            playerChar.setCurrentChest(ironChest);
            playerChar.setCurrentBoots(ironFoot);
            playerChar.setPotionBag(potionBag);
                potionBag.add(new Potion("25 point health potion", "health", 25));
            playerChar.setCurrentWeapon(warriorSword);

            charFrame.dispatchEvent(closeWindow);
        } else if (actionSource.equals(barbarianButton)) {
            Armor barbarianChest = new Armor("chest", "Fur Cloak", 2);
            Melee barbarianAxe = new Melee("battleAxe", "Crude Battleaxe", 10, 8);

            playerChar.setCharClass(BARBARIAN_CLASS);
            playerChar.setAmmoBag(EMPTY_AMMO_BAG);
            playerChar.setMaxHealth(80);
            playerChar.setCurrentHealth(80);
            playerChar.setMaxActionPoints(35);
            playerChar.setCurrentActionPoints(35);
            playerChar.setCurrentHelmet(ironHat);
            playerChar.setCurrentChest(barbarianChest);
            playerChar.setCurrentBoots(furBoots);
            playerChar.setPotionBag(potionBag);
                potionBag.add(new Potion("10 point action potion", "actionPoints", 10));
            playerChar.setCurrentWeapon(barbarianAxe);

            charFrame.dispatchEvent(closeWindow);
        } else if (actionSource.equals(hunterButton)) {
            Armor hunterChest = new Armor("chest", "Leather Armor", 4);
            Ranged hunterBow = new Ranged("bow", "Crude Wooden Bow", 5, 3, "arrow");

            playerChar.setCharClass(HUNTER_CLASS);
            playerChar.setAmmoBag(EMPTY_AMMO_BAG);
                playerChar.ammoBag.add(new Ammo("Iron Arrow", "arrow", 2));
            playerChar.setMaxHealth(60);
            playerChar.setCurrentHealth(60);
            playerChar.setMaxActionPoints(20);
            playerChar.setCurrentActionPoints(20);
            playerChar.setCurrentHelmet(furHat);
            playerChar.setCurrentChest(hunterChest);
            playerChar.setCurrentBoots(furBoots);
            playerChar.setPotionBag(potionBag);
                potionBag.add(FIVE_POINT_HP_POTION);
                potionBag.add(FIVE_POINT_HP_POTION);
            playerChar.setCurrentWeapon(hunterBow);

            charFrame.dispatchEvent(closeWindow);
        } else if (actionSource.equals(rangerButton)) {
            Ranged rangerCrossbow = new Ranged("crossbow", "Cracked Wooden Crossbow", 8, 6, "bolt");

            playerChar.setCharClass(RANGER_CLASS);
            playerChar.setAmmoBag(EMPTY_AMMO_BAG);
                playerChar.ammoBag.add(new Ammo("Iron Bolt", "bolt", 4));
            playerChar.setMaxHealth(80);
            playerChar.setCurrentHealth(80);
            playerChar.setMaxActionPoints(25);
            playerChar.setCurrentActionPoints(25);
            playerChar.setCurrentHelmet(furHat);
            playerChar.setCurrentChest(ironChest);
            playerChar.setCurrentBoots(ironFoot);
            playerChar.setPotionBag(potionBag);
                potionBag.add(FIVE_POINT_HP_POTION);
            playerChar.setCurrentWeapon(rangerCrossbow);

            charFrame.dispatchEvent(closeWindow);
        } else if (actionSource.equals(sentinelButton)) {
            Ranged sentinelGreatbow = new Ranged("greatbow", "Old Wooden Great Bow", 12, 8, Ammo.GREAT_ARROW);

            playerChar.setCharClass(SENTINEL_CLASS);
            playerChar.setAmmoBag(EMPTY_AMMO_BAG);
                playerChar.ammoBag.add(new Ammo("Wooden Greatarrow", "greatarrow", 8));
            playerChar.setMaxHealth(100);
            playerChar.setCurrentHealth(100);
            playerChar.setMaxActionPoints(20);
            playerChar.setCurrentActionPoints(20);
            playerChar.setCurrentHelmet(ironHat);
            playerChar.setCurrentChest(ironChest);
            playerChar.setCurrentBoots(ironFoot);
            playerChar.setPotionBag(potionBag);
                playerChar.potionBag.add(FIVE_POINT_HP_POTION);
                playerChar.potionBag.add(TEN_POINT_AP_POTION);
            playerChar.setCurrentWeapon(sentinelGreatbow);

            charFrame.dispatchEvent(closeWindow);
        } else if (actionSource.equals(mageButton)) {
            Magic mageSpell = new Magic("Minor Blast", 8, 4, "magic");

            playerChar.setCharClass(MAGE_CLASS);
            playerChar.setAmmoBag(EMPTY_AMMO_BAG);
            playerChar.setMaxHealth(70);
            playerChar.setCurrentHealth(70);
            playerChar.setMaxActionPoints(20);
            playerChar.setCurrentActionPoints(20);
            playerChar.setCurrentHelmet(clothHood);
            playerChar.setCurrentChest(clothRobes);
            playerChar.setCurrentBoots(furBoots);
            playerChar.setPotionBag(potionBag);
                playerChar.potionBag.add(TEN_POINT_AP_POTION);
                playerChar.potionBag.add(TEN_POINT_AP_POTION);
            playerChar.setCurrentWeapon(mageSpell);

            charFrame.dispatchEvent(new WindowEvent(charFrame, WindowEvent.WINDOW_CLOSING));
        } else if (actionSource.equals(warlockButton)) {
            Magic warlockSpell = new Magic("Dark Slash", 12, 2, "shadow");
            Armor warlockHat = new Armor("head", "Goat Skull Helmet", 3);

            playerChar.setCharClass(WARLOCK_CLASS);
            playerChar.setAmmoBag(EMPTY_AMMO_BAG);
            playerChar.setMaxHealth(50);
            playerChar.setCurrentHealth(50);
            playerChar.setMaxActionPoints(25);
            playerChar.setCurrentActionPoints(25);
            playerChar.setCurrentHelmet(warlockHat);
            playerChar.setCurrentChest(clothRobes);
            playerChar.setCurrentBoots(furBoots);
            playerChar.setPotionBag(potionBag);
                playerChar.potionBag.add(TEN_POINT_AP_POTION);
                playerChar.potionBag.add(FIVE_POINT_HP_POTION);
            playerChar.setCurrentWeapon(warlockSpell);

            charFrame.dispatchEvent(new WindowEvent(charFrame, WindowEvent.WINDOW_CLOSING));
        } else if (actionSource.equals(pyroButton)) {
            Magic pyroSpell = new Magic("Minor Flame", 12, 2, "fire");

            playerChar.setCharClass(PYRO_CLASS);
            playerChar.setAmmoBag(EMPTY_AMMO_BAG);
            playerChar.setMaxHealth(60);
            playerChar.setCurrentHealth(60);
            playerChar.setMaxActionPoints(30);
            playerChar.setCurrentActionPoints(30);
            playerChar.setCurrentHelmet(ironHat);
            playerChar.setCurrentChest(clothRobes);
            playerChar.setCurrentBoots(furBoots);
            playerChar.setPotionBag(potionBag);
                playerChar.potionBag.add(FIVE_POINT_HP_POTION);
                playerChar.potionBag.add(FIVE_POINT_HP_POTION);
            playerChar.setCurrentWeapon(pyroSpell);

            charFrame.dispatchEvent(new WindowEvent(charFrame, WindowEvent.WINDOW_CLOSING));
        }
    };

    @Override
    public void windowStateChanged(WindowEvent e) {

    }
}
