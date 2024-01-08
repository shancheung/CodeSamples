package main.java.donutdungeon.dungeon.scrolls;

/**
 *  This is where the cripple scroll, which just gives -1 dodge and is quite common.
 *  So why would someone use this scroll? Because they can't read. Scrolls are written
 *  by a baba yaga's chickens, so the names are in Hungarian, but butchered.
 */

public class CursedScroll extends ScrollDecorator implements Scroll {
    protected int stat;
    
    public CursedScroll(Scroll scrollDeco) {
        super(scrollDeco);
    }
    
    /**
     *  Set the name. In this version though, I'll have the readable scrolls name.
     */
    public String scrollName() {
        return scrollDeco.scrollName() + " of Atko (Cursed)";
    }
    
    /**
     *  Just a description for the scoll, nothing too fancy.
     */
    public String scrollDescription() {
        return scrollDeco.scrollDescription() + "This rude scroll looks like it'll reduce a stat "
            + "by 75%...";
    }
    
    /**
     *  Takes in the stat value that will suffer- this one is completely random and very, very
     *  punishing.
     */
    @Override
    public int setStatChange(int statVal) {
        stat = statVal;
        return stat;
    }
    
    /**
     *  It took me a little too long to figure out what was wrong here... I had a very
     *  slight misspelling. I'm tired, it's been 10 hours a day since monday. Forgive me.
     *  Anyway this is similar to how the potions determine how much to heal, in this case
     *  you only keep 10% of a random stat.
     */
    @Override
    public int getStatChange() {
        changedStat = (int)(scrollDeco.setStatChange(stat) * 0.25);
        return scrollDeco.getStatChange() + changedStat;
    }
}
