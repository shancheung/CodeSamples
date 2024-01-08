package main.java.donutdungeon.dungeon.scrolls;

/**
 *  So state looks/feels a lot like the strategy pattern, at least structurally.
 *  Here's where we'll begin the imprisioned state. This, at least, somewhat makes sense to do as
 *  the imprisioned scroll will only turn your legs into basically maple syrup for a few rounds or
 *  levels, who knows.
 */
 
public class ImprisionedState implements State {
    private int counter = 4;    //maybe have a turn counter here
    
    /**
     *  So this state just happens when you read the scroll, it's temporary.
     */
    public void doState(StateContext sc) {
        System.out.println("You've been imprisioned! Ya slow as molasses for the next "
            + counter + " turns.");
        sc.setState(this);
    }
    
    public String toString() {
        return "Imprisioned";
    }
}
