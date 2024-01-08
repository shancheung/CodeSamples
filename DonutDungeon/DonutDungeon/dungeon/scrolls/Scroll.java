package main.java.donutdungeon.dungeon.scrolls;

/*
 *  So this will be very similar to how potions are born, via decorator. I did like the
 *  factory that monsters had, though this will obviously be far less complicated.
 *  Scrolls can inflict status effects on the reader if they're not careful, but with that
 *  who knows maybe the status effect is a perma-stat buff. ;)
 */

public interface Scroll {
    String scrollName(); //Scroll's name.
    
    String scrollDescription(); //Description
    
    int getStatChange();
    
    int setStatChange(int statVal);

    void endState();
}
