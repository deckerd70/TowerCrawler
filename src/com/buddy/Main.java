package com.buddy;

import com.buddy.WeaponList.Melee;
import com.buddy.WeaponList.Weapon;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.Reader;

public class Main {
    public static Character player = new Character();

    Thread gamethread = new Thread();

    public static void main(String[] args) throws InterruptedException {

        CharacterCreator characterCreator = new CharacterCreator();
        ItemGenerator itemGenerator = new ItemGenerator();
        Character player = CharacterCreator.playerChar;
        characterCreator.charSetup();
        System.out.println(player.charClass + "\nname:" +player.getName());
        System.out.println(player.getCurrentBoots().name);

        System.out.println("\n GENERATING WEAPONS..............");
        for (int i = 1; i < 5; i++) {
            player.setLevel(i * 5);
            Weapon weapon = itemGenerator.generateWeapon(player);
            System.out.println(weapon.getName() + ", damage: " + weapon.getDamage());
        }

        System.out.println("\n\n\n GENERATING ARMOR..............");
        for (int i = 1; i < 5; i++) {
            player.setLevel(i * 5);
            Armor armor = itemGenerator.generateArmor(player);
            System.out.println(armor.getName() + ", armor:  " + armor.getArmorPoints());
        }


        while (player.getCurrentHealth() > 0) { // || Level > 10)

        }

    }

/*
    public static void jsFileReadTest() throws ScriptException, NoSuchMethodException, IOException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");

        scriptEngine.eval(Files.newBufferedReader(Paths.get("C:/Users/Buddy/IdeaProjects/TowerCrawler/src/com/buddy/InventoryViewer.js"), StandardCharsets.UTF_8));

        Invocable invocable = (Invocable)scriptEngine;
        invocable.invokeFunction("showInventory");
    }
*/

}
