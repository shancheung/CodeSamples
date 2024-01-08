package main.java.donutdungeon.hero;

import main.java.donutdungeon.hero.abilities.Ability;
import main.java.donutdungeon.hero.equips.Equips;

/**
 *  Has everything stat related that was in Hero.java originally such
 *  that changing stats will be easier when the hero is wearing items.
 */

public abstract class Stats implements HeroBuilder {
    public int strength;
    public int defense;
    public int hp;
    public static int dodge; //Dodge refuses to not bug out without being static.
    public int speed;
    public int mana;
    
    protected static int currstrength;  //SKills won't update if not static
    protected static int currdefense;
    protected static int currspeed;
    protected static int currdodge;
    protected static int currHp;
    
    public int defVal;  //from equipment
    public int atkVal;
    public int spdVal;
    public int hpVal;   //from pots
    
    public int newdef;  //post equipment value holder.
    public int newstr;
    public int newspd;
    public int newhp;
    
    public Stats() {
    }
    
    /**
     * Displays all stats.
     */
    public void getStats() {
        displayStrength();
        displayDefense();
        displayHp();
        displayDodge();
        displaySpeed();
        displayMana();
    }
    
    /*
     * Allows a race to set its respective strength stat.
     */
    @Override
    public void setStrength(int strength) {
        this.strength = strength;
    }
        
    public void displayStrength() {
        System.out.println("Strength: " + strength);
    }
    
    public int getStrength() {
        return this.strength;
    }
    
    /*
     * Allows a race to set its respective defense stat.
     */
    @Override
    public void setDefense(int defense) {
        this.defense = defense;
    }
    
    public void displayDefense() {
        System.out.println("Defense: " + defense);
    }
    
    public int getDefense() {
        return defense;
    }
    
    /*
     * Allows a race to set its respective Hp stat, also updates current hp.
     */
    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }
        
    public void displayHp() {
        System.out.println("HP: " + hp);
    }
    
    public int getHp() {
        return this.hp;
    }
    
    public int getCurrHp() {
        return this.currHp;
    }
    
    /**
     *  Reduce current hp by some amt.
     */
    public void reduceHp(int amt) {
        hpVal = amt;
        newhp = hp - hpVal;
        currHp = newhp;
    }
    
    /*
     * Allows a race to set its respective dodge stat.
     */
    @Override
    public void setDodge(int dodge) {
        this.dodge = dodge;
    }
    
    public void displayDodge() {
        System.out.println("Dodge: " + dodge);
    }
    
    public int getDodge() {
        return this.dodge;
    }
    
    /*
     * Allows a race to set its respective speed stat.
     */
    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }
        
    public void displaySpeed() {
        System.out.println("Speed: " + speed);
    }
    
    public int getSpeed() {
        return speed;
    }
    
    /*
     * Allows a race to set its respective mana stat.
     */
    @Override 
    public void setMana(int mana) {
        this.mana = mana;
    }
    
    public void displayMana() {
        System.out.println("Mana: " + mana);
    }
    
    public int getMana() {
        return mana;
    }
    
    ///////////////////////////////////////////////////////////////////
    //This is for modded stats.
    
    /**
     *  Display the updated stats after equipment values are accounted for.
     */
    public void getCurrentStats() {
        System.out.println("Current Attack: " + currstrength);
        System.out.println("Current defense: " + currdefense);
        System.out.println("Current Speed: " + currspeed);
    }
    
    /**
     * Allows for updating stats.
     */
    public void modDef(Equips equ) {
        defVal = equ.baseStats();   //equip def
        newdef = defense + defVal;
        currdefense = newdef;
    }
    
    /**
     * Allows for updating stats.
     */
    public void modAtk(Equips equ) {
        atkVal = equ.baseStats();
        newstr = strength + atkVal;
        currstrength = newstr;
    }
    
    /**
     * Allows for updating stats.
     */
    public void modSpd(Equips equ) {
        spdVal = equ.baseStats();
        newspd = speed + spdVal;
        currspeed = newspd;
    }
    
    /**
     * View equip stats.
     */
    public void displayEquipStats(Equips equ) {
        if (equ.equipType() == "Hat") {
            modDef(equ);
        }
        if (equ.equipType() == "Weapon") {
            modAtk(equ);
        }
        if (equ.equipType() == "Cape") {
            modSpd(equ);
        }
    }
    
    /////////////////////////////////////////////////
    // Modification from skills.
    /*
     *  These are based off of equip + base stats.
     *  note: I didn't realize that this class was going to get MASSIVE.
     */
     
    /**
     *  Starting with getmad for hornet, trying to make this generic though.
     *  Won't be able to ~really~ test this until later though..
     */
    public void skillMod(Ability abil) {
        int stat;
        stat = abil.doAbility();
        System.out.println("Ability: " + abil.abilityName());
        System.out.println("Stat bonus: " + stat);
        if (abil.abilityName() == "Get Mad!!") {
            currstrength += stat;
            System.out.println("Strength after Get Mad!! : " + currstrength); //remove me later.
        }
        if (abil.abilityName() == "Dance") {
            currdodge = stat + dodge;
            System.out.println("Dodge after Dance : " + currdodge); //remove me later.
        }
        if (abil.abilityName() == "Anxiety") {
            currspeed += stat;
            System.out.println("Speed after get Anxiety : " + currspeed); //remove me later.
        }
    }
}
