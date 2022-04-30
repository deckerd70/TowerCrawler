package com.buddy;

import java.util.ArrayList;
import java.util.List;

public class ItemGenerator {
    //public final int DAMAGE_SCALING =
    //!!!!!when the character level/xp system is added, this will take effect

    //This is the list of describing keywords and the effect they will have on the weapons's damage
    //This will only be used for melee and ranged weapons
    List<describingKeyword> describingKeywordList_Melee = new ArrayList<>(List.of(
            new describingKeyword("Cracked", -3),
            new describingKeyword("Bent", -2),
            new describingKeyword("Old", -2),
            new describingKeyword("", 0),
            new describingKeyword("Fine", 1),
            new describingKeyword("Improved", 2)));


}











class describingKeyword {
    String desc;
    int damageChange;

    public describingKeyword(String desc, int damageChange) {
        this.desc = desc;
        this.damageChange = damageChange;
    }

}
