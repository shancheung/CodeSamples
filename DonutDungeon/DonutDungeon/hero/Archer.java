package main.java.donutdungeon.hero;

/**
    Implements the Job interface to create the Archer identity class.
    This is supposed to be the "thief" option.
    
    The idea behind this archer class is that their arrows are actually mimics.
    Cool, huh? Just imagine the trouble that could cause someone!
    This is more or less, an original idea. At least, I've yet to see this
    somewhere else but to be fair I don't venture communities like D&D etc.
*/

import main.java.donutdungeon.hero.abilities.Ability;

public class Archer extends JobImpl implements Job {
    
    public Archer() {
    }
    
    @Override
    public void setDescription() {  //This is a Bloons Tower Defense 6 reference. Quincy says this.
        description = "Are you kidding me? Nothing gets past my bow.";
    }
    
    @Override
    public void setAbilityList() {
        Ability ability1 = abilityFacto.getAbility("BasicAttack");
        abilities.add(ability1);
        Ability ability2 = abilityFacto.getAbility("Anxiety");
        abilities.add(ability2);
    }
}
