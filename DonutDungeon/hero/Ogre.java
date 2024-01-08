package main.java.donutdungeon.hero;

public class Ogre extends Hero implements Race {
    
    
    private String description;
    
    public Ogre(String name) { 
        super(name);
    }
    
    @Override
    public void setStats() {
        super.setStrength(8);
        super.setDefense(3);
        super.setHp(25);
        super.setDodge(5);
        super.setSpeed(5);
        super.setMana(15);
    }
    
    /*
     * The ogre is inspired by Danganronpa's character, Sakura.
     * She doesn't actually say much, but I think she'd say something like this.
     */
    @Override
    public void setDescription() {
        description = "I fight for my friends.";
    }
    
    @Override
    public void getDescription() {
        System.out.println(description);
    }
}
