package main.java.donutdungeon.hero;

//  Same deal as Race.java, it's technically a factory but it also
//  will get an engineer class, so it's a factory-builder hybrid.

import java.util.ArrayList;
import main.java.donutdungeon.hero.abilities.Ability;

public interface Job {
    public void setDescription();
    
    public void getDescription();
    
    public ArrayList<Ability> getAbilityList();
    
    public void displayAbilities();
    
    public Ability getAbility(int i);
    
    public void setAbilityList();
}
