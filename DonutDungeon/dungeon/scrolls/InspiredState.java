package main.java.donutdungeon.dungeon.scrolls;

/**
 *  Inspired start state, just really delivers a message indicating the intended amount of
 *  turns for this effect per the respective scroll.
 */
 
public class InspiredState implements State {
    private int counter = 8;    //maybe have a turn counter here
    
    /**
     *  Lets the player know they've been inspired.
     */
    public void doState(StateContext sc) {
        System.out.println("You've been *inspired*! This effect will cause a skill "
            + "buff for a while " + counter + " turns.");
        sc.setState(this);
    }
    
    public String toString() {
        return "~INSPIRED!~";
    }
}
