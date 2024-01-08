package main.java.donutdungeon.hero;

/**
    Implements the Job interface to create the Archer identity class.
    This is supposed to be the "Mage" option.
    
    The idea behind this mage class is that they use a hoola-hoop weapon
    and summons horses through it, like a portal. :)
*/

import main.java.donutdungeon.hero.abilities.Ability;

public class Summoner extends JobImpl implements Job {
    
    public Summoner() {
    }
    
    @Override
    public void setDescription() {  //Fire Emblem's character, Reinhardt says this, in some game.
        description = "MAGIC IS EVERYTHING.";
    }
        
    @Override
    public void setAbilityList() {
        Ability ability1 = abilityFacto.getAbility("BasicAttack");
        abilities.add(ability1);
        Ability ability2 = abilityFacto.getAbility("Dance");
        abilities.add(ability2);
    }
}
