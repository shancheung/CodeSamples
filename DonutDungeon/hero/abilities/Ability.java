package main.java.donutdungeon.hero.abilities;

import main.java.donutdungeon.hero.Stats;
/**
 * Just an interface for abilities. It's going to be another factory.
 * though honestly I shouldve done auh. Stratedgy pattern. May change.
 */

public interface Ability {

    String abilityName(); //They all definitely have unique names.
    
    int doAbility();    //May be unique per class, doesn't always have to do damage.
}
