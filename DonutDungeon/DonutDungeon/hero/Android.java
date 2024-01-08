package main.java.donutdungeon.hero;

public class Android extends Hero implements Race {
    
    
    private String description;
    
    public Android(String name) { 
        super(name);
    }
    
    @Override
    public void setStats() {
        super.setStrength(4);
        super.setDefense(5);
        super.setHp(15);
        super.setDodge(8);
        super.setSpeed(8);
        super.setMana(15);
    }
    
    /*
     * Android gets a special Thom Yorke quote.
     * For those who may not know, he's the singer of Radiohead.
     * They also have a song called "Paranoid Android".
     */
    @Override
    public void setDescription() {  
        description = "I once tried playing baseball but I started crying.";
    }
    
    @Override
    public void getDescription() {
        System.out.println(description);
    }
}
