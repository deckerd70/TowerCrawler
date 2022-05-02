package com.buddy;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class ItemGenerator {
    //public final int DAMAGE_SCALING =
    //!!!!!when the character level/xp system is added, this will take effect

    //This is the list of describing keywords and the effect they will have on the weapons's damage
    //This will only be used for melee and ranged weapons
    List<Keyword> describingKeywordList_Weapon = new ArrayList<>(List.of(
            new Keyword("Cracked", -3),
            new Keyword("Bent", -2),
            new Keyword("Old", -1),
            new Keyword("", 0),
            new Keyword("Fine", 1),
            new Keyword("Improved", 2),
            new Keyword("Reinforced", 3),
            new Keyword("Epic", 4),
            new Keyword("Mastercraft", 5),
            new Keyword("Legendary", 6)
    ));

    List<Keyword> describingKeyWordList_Magic = new ArrayList<>(List.of(
            new Keyword("Faint", -2),
            new Keyword("Minor", -1),
            new Keyword("", 0),
            new Keyword("Enhanced", 1),
            new Keyword("Empowered", 2),
            new Keyword("Epic", 3),
            new Keyword("Legendary", 4)
    ));

    //These Keywords will go after the describing keywords of weapons, and may add elemental damage
    List<Keyword> materialKeywordList = new ArrayList<>(List.of(
            new Keyword("Wooden", -1),
            new Keyword("Iron", 0),
            new Keyword("Steel", 1),
            new Keyword("Bone", 2),
            new Keyword("Gold", 3),
            new Keyword("Ethereal", 4), //SPECIAL!!!!!!!!!!!!!! ADDS MAGIC ELEMENTAL DAMAGE
            new Keyword("Volcanic", 5), //SPECIAL!!!!!!!!!!!!!! ADDS FIRE ELEMENTAL DAMAGE
            new Keyword("Abyssal", 6) //SPECIAL!!!!!!!!!!!!!!!! ADDS SHADOW ELEMENTAL DAMAGE
    ));

    //List of bow types (hunter)
    List<Keyword> hunter_TypeKeywordList = new ArrayList<>(List.of(
            new Keyword("Shortbow", 5),
            new Keyword("Bow", 7),
            new Keyword("Longbow", 9),
            new Keyword("Royal Bow", 12),
            new Keyword("Ultra Bow", 15)
    ));

    //List of one-handed weapons (warrior)
    List<Keyword> warrior_TypeKeywordList = new ArrayList<>(List.of(
            new Keyword("Short Sword", 6),
            new Keyword("Mace", 8),
            new Keyword("Sword", 11),
            new Keyword("Long Sword", 15),
            new Keyword("Ultra Sword", 18)
    ));

    //List of two-handed weapons (barbarian)
    List<Keyword> barbarian_TypeKeywordList = new ArrayList<>(List.of(
            new Keyword("Battleaxe", 9),
            new Keyword("Greatsword", 12),
            new Keyword("Hammer", 15),
            new Keyword("Superheavy Mace", 18),
            new Keyword("Ultra Battleaxe", 22)
    ));

    //List of crossbows (ranger)
    List<Keyword> ranger_KeywordList = new ArrayList<>(List.of(
            new Keyword("Light Crossbow", 7),
            new Keyword("Crossbow", 9),
            new Keyword("Heavy Crossbow", 12),
            new Keyword("Reapeating Crossbow", 16),
            new Keyword("Ultra Crossbow", 19)
            ));

    //List of greatbows (sentinel)
    List<Keyword> sentinel_KeywordList = new ArrayList<>(List.of(
            new Keyword("Greatbow", 10),
            new Keyword("Heavy Greatbow", 12),
            new Keyword("Tower Bow", 14),
            new Keyword("Superheavy Greatbow", 18),
            new Keyword("Ultra Greatbow", 22)
    ));

    //List of spells (mage)
    List<Keyword> mage_TypeKeywordList = new ArrayList<>(List.of(
            new Keyword("Blast", 3),
            new Keyword("Strike", 4),
            new Keyword("Super Blast", 6),
            new Keyword("Super Strike", 7),
            new Keyword("Ultra Blast", 10)
    ));

    //List of pyromancies (pyro)
    List<Keyword> pyro_TypeKeywordList = new ArrayList<>(List.of(
            new Keyword("Burn", 5),
            new Keyword("Flare", 6),
            new Keyword("Flame", 8),
            new Keyword("Inferno", 10),
            new Keyword("Ultra Flame", 13)
    ));

    //List of shadow spells (warlock)
    List<Keyword> warlock_TypeKeywordList = new ArrayList<>(List.of(
            new Keyword("Slash", 7),
            new Keyword("Grip", 10),
            new Keyword("Terror", 13),
            new Keyword("Claw", 16),
            new Keyword("Ultra Terror", 20)
    ));
}











class Keyword {
    String desc;
    int damageChange;

    public Keyword(String desc, int damageChange) {
        this.desc = desc;
        this.damageChange = damageChange;
    }

}
