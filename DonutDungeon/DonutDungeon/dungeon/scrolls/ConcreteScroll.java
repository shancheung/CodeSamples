package main.java.donutdungeon.dungeon.scrolls;

/**
 *  Concrete scroll.
 */

public class ConcreteScroll implements Scroll {
    protected int changedStat;

    public String scrollName() {
        return "Scroll";
    }
    
    public String scrollDescription() {
        return "";
    }
    
    /**
     *  All of these are perma. Because I'm perma crippled.
     *  It's not often I get to have some representation.
     *  1. Crippled->-50% dodge. I'd know, I'm actually crippled in real life from a spine injury.
     *  2. Inspired! -> +50% to random stat. (if I had a game, I'd want this to last 3 battles.)
     *  3. RARE: HUGE boost to a single stat.
     *  4. RARE: CURSE! Lose 75% points on a stat. Womp womp.
     *  5. Imprisoned -> Speed is temporarily 0.
     */
     
    public int setStatChange(int statVal) {
        return statVal;
    }
     
    public int getStatChange() {
        return changedStat;
    }
    
    public void endState() {
        ;
    }
}
