package main.java.donutdungeon.dungeon.potions;

/*
 *  Was originally a stratedgy pattern but I changed my mind.
 *  I decided I wanted this to be a factory and scrolls are to be a stratedgy.
 *  Because potions will restore either a set amount of something- what amount is random.
 *  See individual classes for more info
 */

public interface Potion {
    String potionName(); //Potion's name.
    
    int getRecoveryAmt();
    
    int setCurrentHp(int maxhp);
    
}
