package com.buddy;

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
            new Keyword("Improved", 2)
    ));


    //These Keywords will go after the describing keywords of weapons.
    List<Keyword> MaterialKeywordList = new ArrayList<>(List.of(
            new Keyword("Wooden", -1),
            new Keyword("Iron", 0)
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
