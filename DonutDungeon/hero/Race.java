package main.java.donutdungeon.hero;

// This is secretly a factory, I'd rename this class but I'm in too deep.
// The actual factory generating bit is within Hero, which is part of a builder.

public interface Race {
    public void getStats();
    
    public void setStats();
    
    public void setDescription();
    
    public void getDescription();
}
