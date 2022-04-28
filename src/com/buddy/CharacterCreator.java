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
    static JButton barbarianButton = new JButton("Barbarian");
    static JButton warriorButton = new JButton(WARRIOR_CLASS);
    static JButton hunterButton = new JButton("Hunter");
    static JButton rangerButton = new JButton("Ranger");
    static JButton sentinelButton = new JButton("Sentinel");
    static JButton mageButton = new JButton("Mage");
    static JButton warlockButton = new JButton("Warlock");
    static JButton pyroButton = new JButton("Pyromancer");

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

    public Character createCharacter(String charName,String chosenClass) {

        switch(chosenClass) {
            case "Hunter": {
                List<Ammo> ammoBag = new ArrayList<Ammo>();
                ammoBag.add(new Ammo("Iron Arrow", "arrow", 2, 20));

                List<Potion> potionBag = new ArrayList<Potion>();
                potionBag.add(new Potion("5 point health potion", "health", 5));
                potionBag.add(new Potion("5 point health potion", "health", 5));

                Armor hunterChest = new Armor("chest", "Leather Armor", 4);
                Ranged hunterBow = new Ranged("bow", "Crude Wooden Bow", 5, 3, "arrow");

                Character player = new Character(charName, "hunter", 25, 25, 40, 40, hunterBow, furHat, hunterChest, furBoots, EMPTY_AMMO_BAG, potionBag, EMPTY_INVENTORY);
                return player;
            }
            case "Ranger": {
                List<Ammo> ammoBag = new ArrayList<Ammo>();
                ammoBag.add(new Ammo("Iron Bolt", "bolt", 4, 20));

                List<Potion> potionBag = new ArrayList<Potion>();
                potionBag.add(new Potion("5 point health potion", "health", 5));
                potionBag.add(new Potion("5 point action potion", "actionPoints", 5));

                Ranged rangerCrossbow = new Ranged("crossbow", "Cracked Wooden Crossbow", 8, 6, "bolt");

                Character player = new Character(charName, "ranger", 25, 25, 35, 35, rangerCrossbow, furHat, ironChest, ironFoot, EMPTY_AMMO_BAG, potionBag, EMPTY_INVENTORY);
                return player;
            }
            case "Sentinel" : {
                List<Ammo> ammoBag = new ArrayList<Ammo>();
                ammoBag.add(new Ammo("Wooden Greatarrow", "greatarrow", 8, 20));

                List<Potion> potionBag = new ArrayList<Potion>();
                potionBag.add(new Potion("5 point health potion", "health", 5));
                potionBag.add(new Potion("10 point action potion", "actionPoints", 10));

                Ranged sentinelGreatbow = new Ranged("greatbow", "Old Wooden Great Bow", 12, 8, Ammo.GREAT_ARROW);

                Character player = new Character(charName, "sentinel", 35, 35, 60, 60, sentinelGreatbow, ironHat, ironChest, ironFoot, EMPTY_AMMO_BAG, potionBag, EMPTY_INVENTORY);
                return player;
            }
            case "Mage" : {
                List<Ammo> ammoBag = new ArrayList<Ammo>();

                List<Potion> potionBag = new ArrayList<Potion>();
                potionBag.add(new Potion("15 point action potion", "actionPoints", 15));

                Magic mageSpell = new Magic("Minor Blast", 12, 3, "magic");

                Character player = new Character(charName, "mage", 25, 25, 35, 35, mageSpell, clothHood, clothRobes, furBoots, EMPTY_AMMO_BAG, potionBag, EMPTY_INVENTORY);
                return player;
            }
            case "Warlock": {
                List<Ammo> ammoBag = new ArrayList<Ammo>();

                List<Potion> potionBag = new ArrayList<Potion>();
                potionBag.add(new Potion("15 point health potion", "health", 15));

                Armor warlockHat = new Armor("head", "Goat Skull Helmet", 3);
                Magic warlockSpell = new Magic("Dark Strike", 15, 5, "shadow");

                Character player = new Character(charName, "warlock", 20, 20, 45, 45, warlockSpell, warlockHat, clothRobes, furBoots, EMPTY_AMMO_BAG, potionBag, EMPTY_INVENTORY);
                return player;
            }
            case "Pyromancer" : {
                List<Ammo> ammoBag = new ArrayList<Ammo>();

                List<Potion> potionBag = new ArrayList<Potion>();
                potionBag.add(new Potion("15 point health potion", "health", 15));

                Magic pyroSpell = new Magic("Minor Flame", 18, 7, "pyro");

                Character player = new Character(charName, "pyromancer", 20, 20, 45, 45, pyroSpell, clothHood, ironChest, ironFoot, EMPTY_AMMO_BAG, potionBag, EMPTY_INVENTORY);
                return player;
            }
        }
        return new Character();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        playerChar.setName(name);

        JButton actionSource = (JButton)e.getSource();
        if(actionSource.equals(warriorButton)) {
            Melee warriorSword = new Melee("sword", "Crude Iron Sword", 5, 4);

            playerChar.setCharClass(WARRIOR_CLASS);
            playerChar.setAmmoBag(EMPTY_AMMO_BAG);
            playerChar.setMaxHealth(100);
            playerChar.setCurrentHealth(100);
            playerChar.setMaxActionPoints(20);
            playerChar.setCurrentActionPoints(20);
            playerChar.setCurrentHelmet(ironHat);
            playerChar.setCurrentChest(ironChest);
            playerChar.setCurrentBoots(ironFoot);
            playerChar.setPotionBag(potionBag);
                potionBag.add(new Potion("25 point health potion", "health", 25));
            playerChar.setCurrentWeapon(warriorSword);

            charFrame.dispatchEvent(new WindowEvent(charFrame, WindowEvent.WINDOW_CLOSING));
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

            charFrame.dispatchEvent(new WindowEvent(charFrame, WindowEvent.WINDOW_CLOSING));
        } else if (actionSource.equals(hunterButton)) {
            Armor hunterChest = new Armor("chest", "Leather Armor", 4);
            Ranged hunterBow = new Ranged("bow", "Crude Wooden Bow", 5, 3, "arrow");

            playerChar.setCharClass(HUNTER_CLASS);
            playerChar.setAmmoBag(EMPTY_AMMO_BAG);
                playerChar.ammoBag.add(new Ammo("Iron Arrow", "arrow", 2, 20));
            playerChar.setMaxHealth(60);
            playerChar.setCurrentHealth(60);
            playerChar.setMaxActionPoints(20);

            charFrame.dispatchEvent(new WindowEvent(charFrame, WindowEvent.WINDOW_CLOSING));
        } else if (actionSource.equals(rangerButton)) {
            //harClass = "Ranger";
            charFrame.dispatchEvent(new WindowEvent(charFrame, WindowEvent.WINDOW_CLOSING));
        } else if (actionSource.equals(sentinelButton)) {
            //charClass = "Sentinel";
            charFrame.dispatchEvent(new WindowEvent(charFrame, WindowEvent.WINDOW_CLOSING));
        } else if (actionSource.equals(mageButton)) {
            //charClass = "Mage";
            charFrame.dispatchEvent(new WindowEvent(charFrame, WindowEvent.WINDOW_CLOSING));
        } else if (actionSource.equals(warlockButton)) {
            //charClass = "Warlock";
            charFrame.dispatchEvent(new WindowEvent(charFrame, WindowEvent.WINDOW_CLOSING));
        } else if (actionSource.equals(pyroButton)) {
            //charClass = "Pyromancer";
            charFrame.dispatchEvent(new WindowEvent(charFrame, WindowEvent.WINDOW_CLOSING));
        }
    };

    @Override
    public void windowStateChanged(WindowEvent e) {

    }
}
