package main.java.donutdungeon.dungeon.monsters;

/*
 *  A type of monster to generate, weak ones are the ones that aren't bosses or mid-bosses.
 */

import java.util.ArrayList;
import java.util.Random;    //For loot generation

import main.java.donutdungeon.dungeon.potions.HealingPotion;
import main.java.donutdungeon.dungeon.potions.HighHealDecorator;
import main.java.donutdungeon.dungeon.potions.MedHealDecorator;
import main.java.donutdungeon.dungeon.potions.Potion;
import main.java.donutdungeon.dungeon.potions.WeakHealDecorator;

import main.java.donutdungeon.hero.equips.EquipFactory; //THESE ARE BECAUSE OF LOOT
import main.java.donutdungeon.hero.equips.Equips;

public abstract class MonsterDecorator implements Monster {
    protected Monster monster;
    protected ArrayList<Integer> statsList = new ArrayList<Integer>();
    //lOOT
    protected Random rando = new Random();
    
    protected final EquipFactory equipFacto = new EquipFactory();
    
    public MonsterDecorator(Monster monster) {
        this.monster = monster;
    }
    
    public String monsterName() {
        return monster.monsterName();
    }
    
    public void displayMonStats() {
        monster.setStats();
        monster.displayMonStats();
    }
    
    public void setStats() {    //this is nearly impossible to do with a headache.
        statsList = statsList;
    }
    
    public ArrayList<Integer> getStats() {
        return this.statsList;
    }
    
    /**
     *  If the loot is to be determined to be a potion, it'll generate one of three,
     *  with some probability of course- don't worry it's not too mean.
     */
    public Potion lootPotion() {
        int v = rando.nextInt(5) + 1;
        if (v == 5) {   
            System.out.println("Jackpot!");
            Potion bigPot = new HighHealDecorator(new HealingPotion());
            System.out.println("Obtained " + bigPot.potionName());
            return bigPot;
        } else if (v < 4 && v != 5) {
            System.out.println("Good!");
            Potion medPot = new MedHealDecorator(new HealingPotion());
            System.out.println("Obtained " + medPot.potionName());
            return medPot;
        } else {
            System.out.println("womp womp.");
            Potion smalPot = new WeakHealDecorator(new HealingPotion());
            System.out.println("Obtained " + smalPot.potionName());
            return smalPot;
        }
    }
    
    /**
     *  So this is where not making it so I can just equip things easier is gonna bite me.
     */
    public Equips lootEquip() {
        int v = rando.nextInt(5) + 1;
        if (v == 5) {   //Return cape, they could really break the game lol
            System.out.println("Jackpot!");
            Equips cape = equipFacto.getEquip("Cape");
            cape.displayEquip();
            return cape;
        } else if (v < 4 && v != 5) {
            System.out.println("Good!");
            Equips weapon = equipFacto.getEquip("Weapon");
            weapon.displayEquip();
            return weapon;
        } else {
            System.out.println("womp womp.");
            Equips hat = equipFacto.getEquip("Hat");
            hat.displayEquip();
            return hat;
        }
    }
    
    /**
     *  Just picks one of two possible loots, but theres a 1/3 chance of getting no loot.
     */
    public void determineLoot() {
        int v = rando.nextInt(3) + 1;
        if (v == 2) {
            lootEquip();
        } else if (v == 1) {
            lootPotion();
        } else {
            System.out.println("No loot for you. ;_;");
        }
    }
}
