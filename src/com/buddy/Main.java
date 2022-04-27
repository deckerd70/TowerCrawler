package com.buddy;

import com.buddy.WeaponList.Melee;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    static CharacterCreator characterCreator = new CharacterCreator();
    public static Character player = new Character();

    public static void main(String[] args) {

        characterCreator.charSetup();
        System.out.println(player.charClass);
        System.out.println(player.getCurrentBoots().name);

        while (player.getCurrentHealth() > 0) { // || Level > 10)

        }

    }
}
