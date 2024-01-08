package main.java.donutdungeon.hero.abilities;

/**
 *  Hornet's buff ability. Grants +strength.
 */

public class GetMad implements Ability {
    private String name = "Get Mad!!";
    public int strengthBoost = 2;
    
    @Override
    public String abilityName() {
        return name;
    }
    
    @Override
    public int doAbility() {
        return strengthBoost;
    }
}
