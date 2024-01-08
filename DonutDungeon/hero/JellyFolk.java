package main.java.donutdungeon.hero;

public class JellyFolk extends Hero implements Race {
    
    
    private String description;
    
    public JellyFolk(String name) { 
        super(name);
    }
    
    @Override
    public void setStats() {
        super.setStrength(4);
        super.setDefense(10);
        super.setHp(20);
        super.setDodge(5);
        super.setSpeed(4);
        super.setMana(15);
    }
    
    /*
     * This is a Splatoon reference.
     */
    @Override
    public void setDescription() {
        description = "WOOMY.";
    }
    
    @Override
    public void getDescription() {
        System.out.println(description);
    }
}
