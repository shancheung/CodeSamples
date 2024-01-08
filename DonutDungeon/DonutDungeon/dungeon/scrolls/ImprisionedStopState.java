package main.java.donutdungeon.dungeon.scrolls;

/**
 *  Stop state portion for the state pattern- since most of my scrolls give you perma
 *  debuffs (mostly, haha), the few that AREN'T perma could have some states.
 */
 
public class ImprisionedStopState implements State {
    
    /**
     *  Lets you know that you're no longer imprisioned.
     */
    public void doState(StateContext sc) {
        System.out.println("Phew! I'm FREE! No more [IMPRISIONED STATE]");
        sc.setState(this);
    }
    
    public String toString() {
        return "Imprisionment has been exhausted";
    }
}
