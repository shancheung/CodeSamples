package main.java.donutdungeon.dungeon.scrolls;

/**
 *  This is where the cripple scroll, which just gives -1 dodge and is quite common.
 *  So why would someone use this scroll? Because they can't read. Scrolls are written
 *  by a baba yaga's chickens, so the names are in Hungarian, but butchered.
 */

public class InspiredScroll extends ScrollDecorator implements Scroll {
    protected int stat;
    protected StateContext sc = new StateContext();  //Bringing the states into this.
    private InspiredState startInspired = new InspiredState();
    private InspiredStopState stopInspired = new InspiredStopState();
    
    public InspiredScroll(Scroll scrollDeco) {
        super(scrollDeco);
    }
    
    /**
     *  Set the name. In this version though, I'll have the readable scrolls name.
     */
    public String scrollName() {
        return scrollDeco.scrollName() + " of Etett (Inspire)";
    }
    
    /**
     *  This is just the message you get when you actually read the scroll.
     */
    public String scrollDescription() {
        return scrollDeco.scrollDescription() + "You feel inspired! Some stat will now get a"
            + "1.5x increase for a little while!";
    }
    
    /**
     *  Takes in the stat value that will suffer- this time it's dodge.
     */
    @Override
    public int setStatChange(int statVal) {
        System.out.print("**State (Inspired) Start** ");
        startInspired.doState(sc);
        stat = statVal;
        return stat;
    }
    
    /**
     *  I might have to change this later, but this is the opposite of cripple, it grants
     *  1.5x dodge stat.
     */
    @Override
    public int getStatChange() {
        changedStat = (int)(scrollDeco.setStatChange(stat) * 1.5);
        return scrollDeco.getStatChange() + changedStat;
    }
    
    /**
     *  Just an end state getter, no other real implementation.
     */
    @Override
    public void endState() {
        System.out.print("**State (Inspired) Stop** ");
        stopInspired.doState(sc);
        System.out.println(sc.getState());
    }
}
