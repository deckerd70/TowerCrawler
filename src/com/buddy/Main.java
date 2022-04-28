package com.buddy;

import com.buddy.WeaponList.Melee;

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

    public static void main(String[] args) throws InterruptedException {

        CharacterCreator characterCreator = new CharacterCreator();
        Character player = CharacterCreator.playerChar;
        characterCreator.charSetup();
        System.out.println(player.charClass + "\nname:" +player.getName());
        System.out.println(player.getCurrentBoots().name);

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
