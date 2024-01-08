package main.java.donutdungeon.dungeon.monsters;

/*
 *  A type of monster to generate, weak ones are the ones that aren't bosses or mid-bosses.
 *  I'm way too sick to try and get Stats.java to work, I've ttried all the mediccine but my
 *  Fever won't go down, it's not even that high its just a pain.
 */
 
import java.util.ArrayList;

import main.java.donutdungeon.dungeon.potions.HealingPotion;
import main.java.donutdungeon.dungeon.potions.Potion;
import main.java.donutdungeon.hero.equips.Equips;

public class MidMonster implements Monster {
    
    //Stats in order: Str, Def, Hp, Dodge, speed. No mana for monsters.

    @Override
    public String monsterName() {
        return "Braverian Creme";
    }
    
    /**
     *  So I can't compile unless I put setStats and displayMonStats() here.
     *  It'll probably  be like this for the other monster tiers. :(
     *  so sad, such ugly code.
     */
    @Override
    public void displayMonStats() { 
        ;
    }
    
    @Override
    public void setStats() {
        ;
    }
    
    @Override
    public ArrayList<Integer> getStats() {
        return null;
    }
    
    @Override
    public Potion lootPotion() {
        return null;
    }
    
    @Override
    public Equips lootEquip() { 
        return null;
    }
    
    @Override
    public void determineLoot() {
        ;
    }
}
