package main.java.donutdungeon.hero;
/*
 * By: Shannon McHugh
 * Hero builder interface section.
 */

import main.java.donutdungeon.hero.Race;

public interface HeroBuilder {
    public void setJob(int jobSelection);
    
    public String getJob();
    
    public void setRace(int raceId);    //race includes base stats
    
    public String getRace();
    
    public void getStats();
    
    public void setStrength(int strength);
    
    public void displayStrength();
    
    public int getStrength();
    
    public void setDefense(int defense);
        
    public void displayDefense();
    
    public int getDefense();
    
    public void setHp(int hp);
    
    public void displayHp();
    
    public int getHp();
    
    public void setDodge(int dodge);
    
    public void displayDodge();
    
    public int getDodge();
    
    public void setSpeed(int speed);
        
    public void displaySpeed();
    
    public int getSpeed();
    
    public void setMana(int mana);
    
    public void displayMana();

    public int getMana();
}
