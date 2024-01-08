package main.java.donutdungeon.dungeon.scrolls;

/**
 *  Stop state portion for the state pattern- since most of my scrolls give you perma
 *  debuffs (mostly, haha), the few that AREN'T perma could have some states.
 */
 
public class InspiredStopState implements State {
    
    /**
     *  Lets the player know they're no longer inspired :( .
     */
    public void doState(StateContext sc) {
        System.out.println("Aw shucks, I'm no longer in the [INSPIRED STATE].");
        sc.setState(this);
    }
    
    public String toString() {
        return "Back to normal, no more inspiration...";
    }
}
