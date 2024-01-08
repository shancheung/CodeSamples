package main.java.donutdungeon.hero.equips;

/**
    Chance of randomized stat enhancement upon item pickup.
*/

import java.util.Random;

public class EquipFactory {
    private Random rand = new Random();
    private int randVal;
    private int randDet;
    
    /**
     *  For actually creating the equip objects. Also gives them a little enchant... Maybe.
     */
    public Equips getEquip(String equip) {
        if (equip.equalsIgnoreCase("Hat")) {
            Hat hat = new Hat();
            randomEnhancement(hat);
            return hat;
        }
        if (equip.equalsIgnoreCase("Weapon")) {
            Weapon wep = new Weapon();
            randomEnhancement(wep);
            return wep;
        }
        if (equip.equalsIgnoreCase("Cape")) {
            Cape cape = new Cape();
            randomEnhancement(cape);
            return cape;
        }
        return null;
    }
    
    /**
     *  Randomly adds some defense to generated gear.
     */
    private void randomEnhancement(Equips equ) {
        randDet = rand.nextInt(4) + 1;    // 1 in 4 chance.
        if (randDet == 1) {
            randVal = rand.nextInt(3) + 1;
            equ.setSpecialMsg("WOW! BONUS: + " + randVal + " from " + equ.equipType());
            equ.setVal(randVal);
        } else {
            equ.setSpecialMsg("");
        }
    }
}
