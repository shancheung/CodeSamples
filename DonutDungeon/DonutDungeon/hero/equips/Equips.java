package main.java.donutdungeon.hero.equips;
/**
 * Interface for equipment items. Here's the plan:
 *  - This interface will act as part of a factory for equipments:
 *      Hat, cape, boots.
 *  - Then those items will be decorated with "augments". These augments
 *      may also be used for possible stat boosting potions, there will
 *      be some exclusive to potions though (such as restore mana/hp %).
 */
 
public interface Equips {
    String equipType(); //Eaach equipment type has a name.
    
    int baseStats();   //Each also has their unique base stats.

    void setVal(int n);
    
    String special();
    
    void setSpecialMsg(String msg);
    
    void displayEquip();
}
