package com.buddy;

import com.buddy.WeaponList.Weapon;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class ItemGenerator {
    public final String barbarian = CharacterCreator.BARBARIAN_CLASS;
    public final String warrior = CharacterCreator.WARRIOR_CLASS;
    public final String hunter = CharacterCreator.HUNTER_CLASS;
    public final String ranger = CharacterCreator.RANGER_CLASS;
    public final String sentinel = CharacterCreator.SENTINEL_CLASS;
    public final String mage = CharacterCreator.MAGE_CLASS;
    public final String warlock = CharacterCreator.WARLOCK_CLASS;
    public final String pyro = CharacterCreator.PYRO_CLASS;
    public final List<String> meleeClasses = new ArrayList<>(List.of(
            barbarian,
            warrior,
            hunter,
            ranger,
            sentinel
    ));

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
            new Keyword("Dark Slash", 7),
            new Keyword("Shadow Grip", 10),
            new Keyword("Terror", 13),
            new Keyword("Dark Claw", 16),
            new Keyword("Ultra Terror", 20)
    ));



    public Weapon generateWeapon(Character player) {
        List<Keyword> playerItemKeywordList;
        String playerClass = player.getCharClass();
        int charLevel = player.getLevel();
        String weaponName = "";
        Weapon dropWeapon = new Weapon();
        int highestTier = 0;

        playerItemKeywordList = switch (playerClass) {
            case (barbarian) -> barbarian_TypeKeywordList;
            case (warrior) -> warrior_TypeKeywordList;
            case (hunter) -> hunter_TypeKeywordList;
            case (ranger) -> ranger_KeywordList;
            case (sentinel) -> sentinel_KeywordList;
            case (mage) -> mage_TypeKeywordList;
            case (warlock) -> warlock_TypeKeywordList;
            case (pyro) -> pyro_TypeKeywordList;
            default -> throw new IllegalStateException("Unexpected value: " + playerClass);
        };


        if(charLevel >= 5 && charLevel < 10) {
            highestTier = 1;
        } else if(charLevel >= 10 && charLevel < 15) {
            highestTier = 2;
        } else if(charLevel >= 15 && charLevel < 20) {
            highestTier = 3;
        } else if (charLevel >= 20) {
            highestTier = 4;
        }

        Keyword keywordIndexWeapon = describingKeywordList_Weapon.get((int) (Math.random() * 9));
        Keyword keywordIndexMaterial = materialKeywordList.get((int) (Math.random() * 7));
        Keyword keywordIndexMagic = describingKeyWordList_Magic.get((int) (Math.random() * 6));
        int tierIndex = generateTierIndex(highestTier);
        Keyword tierCalc = playerItemKeywordList.get(tierIndex);
        int damageCalc = 0;

        if (meleeClasses.contains(playerClass)) {
            weaponName = weaponName + keywordIndexWeapon.getDesc();
            damageCalc+= keywordIndexWeapon.getStatChange();
            weaponName = weaponName + " " + keywordIndexMaterial.getDesc();
            damageCalc += keywordIndexMaterial.getStatChange();
        } else {
            weaponName = weaponName + keywordIndexMagic.getDesc();
            damageCalc += keywordIndexMagic.getStatChange();
        }
        weaponName = weaponName + " " + tierCalc.getDesc();
        damageCalc += tierCalc.getStatChange();

        dropWeapon.setName(weaponName);
        dropWeapon.setDamage(damageCalc);

        return dropWeapon;
    }

    public Armor generateArmor(Character player){
        return new Armor();
    }


    private int generateTierIndex(int max) {
        return (int) ((Math.random() * (max)));
    }
}







class Keyword {
    String desc;
    int statChange;

    public Keyword(String desc, int statChange) {
        this.desc = desc;
        this.statChange = statChange;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getStatChange() {
        return statChange;
    }

    public void setStatChange(int statChange) {
        this.statChange = statChange;
    }
}
