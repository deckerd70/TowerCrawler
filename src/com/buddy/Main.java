package com.buddy;

import com.buddy.WeaponList.Melee;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    static CharacterCreator characterCreator = new CharacterCreator();

    public static void main(String[] args) {

        Character player = characterCreator.charSetup();

        System.out.println(player.charClass);
        System.out.println(player.getCurrentBoots().name);

        while (player.getCurrentHealth() > 0) { // || Level > 10)

        }

    }
}
