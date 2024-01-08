package main.java.donutdungeon.dungeon.monsters;

/*
 *  This is the beginning of the Monster decorator/factory. We'll see how this goes.
 */

import java.util.ArrayList;

import main.java.donutdungeon.dungeon.potions.Potion;   //Here because of loot
import main.java.donutdungeon.hero.equips.Equips;

public interface Monster {
    String monsterName(); //Monster's name.
    
    void displayMonStats(); //get whatever stats they may have.
    
    void setStats();
    
    ArrayList<Integer> getStats();
    
    Potion lootPotion();    //Picks a potion to drop if potions are selected to drop.
    
    Equips lootEquip();     //Picks loot to drop
    
    void determineLoot();   //picks which one to give the victor.
    
}
