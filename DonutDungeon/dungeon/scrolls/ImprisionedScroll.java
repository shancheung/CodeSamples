package main.java.donutdungeon.dungeon.scrolls;

/**
 *  This is where the cripple scroll, which just gives -1 dodge and is quite common.
 *  So why would someone use this scroll? Because they can't read. Scrolls are written
 *  by a baba yaga's chickens, so the names are in Hungarian, but butchered.
 */

public class ImprisionedScroll extends ScrollDecorator implements Scroll {
    protected int stat;
    protected StateContext sc = new StateContext();  //Bringing the states into this.
    private ImprisionedState startImprisoned = new ImprisionedState();
    private ImprisionedStopState stopImprisioned = new ImprisionedStopState();
    
    public ImprisionedScroll(Scroll scrollDeco) {
        super(scrollDeco);
    }
    
    /**
     *  Set the name. In this version though, I'll have the readable scrolls name.
     */
    public String scrollName() {
        return scrollDeco.scrollName() + " of Beborzoni (Imprisioned)";
    }
    
    /**
     *  Just a description for the scoll, nothing too fancy.
     */
    public String scrollDescription() {
        return scrollDeco.scrollDescription() + "You've been shackled and now you're slower than"
            + " molassas! (speed set to 0!) Don't worry this one is... temporary.";
    }
    
    /**
     *  Takes in the stat value that will suffer- this time it's speed.
     */
    @Override
    public int setStatChange(int statVal) {
        System.out.print("**State (Imprisioned) Start** ");
        startImprisoned.doState(sc);
        stat = statVal;
        return stat;
    }
    
    /**
     *  Anyway this is similar to how the potions determine how much to heal, in this case
     *  Speed goes goodbye.
     */
    @Override
    public int getStatChange() {
        changedStat = (int)(scrollDeco.setStatChange(stat) * 0);
        return scrollDeco.getStatChange() + changedStat;
    }
    
    /**
     *  Just an end state getter, no other real implementation.
     */
    @Override
    public void endState() {
        System.out.print("**State (Imprisioned) Stop** ");
        stopImprisioned.doState(sc);
        System.out.println(sc.getState().toString());
    }
}
