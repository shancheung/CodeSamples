package main.java.donutdungeon.hero.abilities;

/**
 *  Ranger's buff ability. Grants +Speed.
 */

public class Anxiety implements Ability {
    private String name = "Anxiety";
    public int stat = 1;
    
    @Override
    public String abilityName() {
        return name;
    }
    
    @Override
    public int doAbility() {
        return stat;
    }
}
