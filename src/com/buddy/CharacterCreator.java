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
    static String charClass = "";

    static Armor ironHat = new Armor("head", "Crude Iron Helmet", 2);
    static Armor ironChest = new Armor("chest", "Crude Iron Chestplate", 6);
    static Armor ironFoot = new Armor("foot", "Crude Iron Boots", 6);
    static Armor furBoots = new Armor("foot", "Fur Boots", 1);
    static Armor furHat = new Armor("head", "Fur Hat", 1);
    static Armor clothHood = new Armor("head", "Cloth Hood", 1);
    static Armor clothRobes = new Armor("chest", "Cloth Robes", 3);

    static JFrame charFrame = new JFrame("Character Class");
    static JButton barbarianButton = new JButton("Barbarian");
    static JButton warriorButton = new JButton("Warrior");
    static JButton hunterButton = new JButton("Hunter");
    static JButton rangerButton = new JButton("Ranger");
    static JButton sentinelButton = new JButton("Sentinel");
    static JButton mageButton = new JButton("Mage");
    static JButton warlockButton = new JButton("Warlock");
    static JButton pyroButton = new JButton("Pyromancer");

    public Character charSetup(){
        String name = JOptionPane.showInputDialog("Enter character name");

        Character character = createCharacter(name);
        return character;
    }

    public Character createCharacter(String charName) {
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

        switch(charClass) {
            case "Barbarian" : {
                List<Ammo> ammoBag = new ArrayList<Ammo>();

                List<Potion> potionBag = new ArrayList<Potion>();
                potionBag.add(new Potion("10 point action potion", "actionPoints", 10));

                Armor barbarianChest = new Armor("chest", "Fur Cloak", 2);
                Melee barbarianAxe = new Melee("battleAxe", "Crude Battleaxe", 10, 8);

                Character player = new Character(charName, "barbarian", 65, 65, 25, 25, barbarianAxe, ironHat, barbarianChest, furBoots, ammoBag, potionBag);
                return player;
            }
            case "Warrior": {
                List<Ammo> ammoBag = new ArrayList<Ammo>();

                List<Potion> potionBag = new ArrayList<Potion>();
                potionBag.add(new Potion("5 point health potion", "health", 5));

                Melee warriorSword = new Melee("sword", "Crude Iron Sword", 5, 4);

                Character player = new Character(charName, "warrior", 40, 40, 40, 40, warriorSword, ironHat, ironChest, ironFoot, ammoBag, potionBag);
                return player;
            }
            case "Hunter": {
                List<Ammo> ammoBag = new ArrayList<Ammo>();
                ammoBag.add(new Ammo("Iron Arrow", "arrow", 2, 20));

                List<Potion> potionBag = new ArrayList<Potion>();
                potionBag.add(new Potion("5 point health potion", "health", 5));
                potionBag.add(new Potion("5 point health potion", "health", 5));

                Armor hunterChest = new Armor("chest", "Leather Armor", 4);
                Ranged hunterBow = new Ranged("bow", "Crude Wooden Bow", 5, 3, "arrow");

                Character player = new Character(charName, "hunter", 25, 25, 40, 40, hunterBow, furHat, hunterChest, furBoots, ammoBag, potionBag);
                return player;
            }
            case "Ranger": {
                List<Ammo> ammoBag = new ArrayList<Ammo>();
                ammoBag.add(new Ammo("Iron Bolt", "bolt", 4, 20));

                List<Potion> potionBag = new ArrayList<Potion>();
                potionBag.add(new Potion("5 point health potion", "health", 5));
                potionBag.add(new Potion("5 point action potion", "actionPoints", 5));

                Ranged rangerCrossbow = new Ranged("crossbow", "Cracked Wooden Crossbow", 8, 6, "bolt");

                Character player = new Character(charName, "ranger", 25, 25, 35, 35, rangerCrossbow, furHat, ironChest, ironFoot, ammoBag, potionBag);
                return player;
            }
            case "Sentinel" : {
                List<Ammo> ammoBag = new ArrayList<Ammo>();
                ammoBag.add(new Ammo("Wooden Greatarrow", "greatarrow", 8, 20));

                List<Potion> potionBag = new ArrayList<Potion>();
                potionBag.add(new Potion("5 point health potion", "health", 5));
                potionBag.add(new Potion("10 point action potion", "actionPoints", 10));

                Ranged sentinelGreatbow = new Ranged("greatbow", "Cracked Wooden Great Bow", 12, 8, "greatarrow");

                Character player = new Character(charName, "sentinel", 35, 35, 60, 60, sentinelGreatbow, ironHat, ironChest, ironFoot, ammoBag, potionBag);
                return player;
            }
            case "Mage" : {
                List<Ammo> ammoBag = new ArrayList<Ammo>();

                List<Potion> potionBag = new ArrayList<Potion>();
                potionBag.add(new Potion("15 point action potion", "actionPoints", 15));

                Magic mageSpell = new Magic("Minor Blast", 12, 3, "magic");

                Character player = new Character(charName, "mage", 25, 25, 35, 35, mageSpell, clothHood, clothRobes, furBoots, ammoBag, potionBag);
                return player;
            }
            case "Warlock": {
                List<Ammo> ammoBag = new ArrayList<Ammo>();

                List<Potion> potionBag = new ArrayList<Potion>();
                potionBag.add(new Potion("15 point health potion", "health", 15));

                Armor warlockHat = new Armor("head", "Goat Skull Helmet", 3);
                Magic warlockSpell = new Magic("Dark Strike", 15, 5, "shadow");

                Character player = new Character(charName, "warlock", 20, 20, 45, 45, warlockSpell, warlockHat, clothRobes, furBoots, ammoBag, potionBag);
                return player;
            }
            case "Pyromancer" : {
                List<Ammo> ammoBag = new ArrayList<Ammo>();

                List<Potion> potionBag = new ArrayList<Potion>();
                potionBag.add(new Potion("15 point health potion", "health", 15));

                Magic pyroSpell = new Magic("Minor Flame", 18, 7, "pyro");

                Character player = new Character(charName, "pyromancer", 20, 20, 45, 45, pyroSpell, clothHood, ironChest, ironFoot, ammoBag, potionBag);
                return player;
            }
        }
        return new Character();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton actionSource = (JButton)e.getSource();
        if(actionSource.equals(warriorButton)){
            charClass = "warrior";
            //TODO: Close the window once the user has clicked on a class button - may need to change what interface i'm (you're) using to read window events/status
        } else if (actionSource.equals(barbarianButton)){
            charClass = "barbarian";
        }
    };

    @Override
    public void windowStateChanged(WindowEvent e) {

    }
}
