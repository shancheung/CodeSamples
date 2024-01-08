package main.java.donutdungeon.hero;

/**
    Implements job interface and extends jobimpl. This is thrown into a factory
    where a new job is engineered. Hero can detect exactly which is selected upon
    character creation. 
    
    About Hornet:
    Anyway the Hornet was inspired by Hollow Knight's character, Hornet. She's a
    great little swordsman and I also have a TON of bees around my house. They're
    absolutely ruthless, absolute fighters. So that's another reason why I chose
    Hornet to be my "fighter" class. Hornet, in the game Hollow Knight sounds like
    she just shouts "corissant!" during combat. Hence the quote.
    
    Class Features:
        - Get Mad! - Grants the hornet character a little attack boost but reduces dodge.
*/

import main.java.donutdungeon.hero.abilities.Ability;

public class Hornet extends JobImpl implements Job {
    
    public Hornet() {
    }
    
    @Override
    public void setDescription() {  //Reference to Hollow Knight's Hornet.
        description = "I fight for croissants.";
    }
    
    @Override
    public void setAbilityList() {
        Ability ability1 = abilityFacto.getAbility("BasicAttack");
        abilities.add(ability1);
        Ability ability2 = abilityFacto.getAbility("GetMad");
        abilities.add(ability2);
    }

}
