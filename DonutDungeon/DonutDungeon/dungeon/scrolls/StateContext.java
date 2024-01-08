package main.java.donutdungeon.dungeon.scrolls;

/**
 *  This reminds me very much of how decorators work half way implementing them but also
 *  it's reminds me of strategy- Anyway this class, StateContext, is used to see when state
 *  changes. Instant a new context object, also for each state(start and stop), then do something
 *  like startState.doTheThing(contextObj);
 *  
 *  <p>If time allows it, I'd like to set up another state for inspired, That way there's one for
 *  the buff and the debuff.
 */
 
public class StateContext {
    private State sc;
    
    public StateContext() {
        sc = null;
    }
    
    public void setState(State sc) {
        this.sc = sc;
    }
    
    public State getState() {
        return sc;
    }
}
