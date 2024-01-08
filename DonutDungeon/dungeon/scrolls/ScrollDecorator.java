package main.java.donutdungeon.dungeon.scrolls;

/**
 *  So this will be very similar to how potions are born, via decorator. I did like the
 *  factory that monsters had, though this will obviously be far less complicated.
 *  Scrolls can inflict status effects on the reader if they're not careful, but with that
 *  who knows maybe the status effect is a perma-stat buff. ;)
 */

public abstract class ScrollDecorator implements Scroll {
    protected Scroll scrollDeco;
    protected int changedStat;
    
    public ScrollDecorator(Scroll scrollDeco) {
        this.scrollDeco = scrollDeco;
    }
    
    public String scrollName() {
        return scrollDeco.scrollName();
    }
    
    public int setStatChange(int statVal) {
        return scrollDeco.setStatChange(statVal);
    }
    
    public int getStatChange() {
        return scrollDeco.getStatChange();
    }
    
    public void endState() {
        ;
    }
}
