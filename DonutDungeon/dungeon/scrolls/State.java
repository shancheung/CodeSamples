package main.java.donutdungeon.dungeon.scrolls;

/**
 *  I wanted to give my scrolls a state mechanism even if it's just for demonstration purposes.
 *  I believe that it will further elaborate on my intents regarding them, but also- it gives me
 *  another chance to frankenstein some patterns together, how fun!
 */

public interface State {
    public void doState(StateContext sc);
}
