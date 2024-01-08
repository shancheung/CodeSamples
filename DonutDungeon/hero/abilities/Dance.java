package main.java.donutdungeon.hero.abilities;

/**
 *  Summoner's buff ability. Grants +dodge.
 */

public class Dance implements Ability {
    private String name = "Dance";
    public int stat = 3;
    
    @Override
    public String abilityName() {
        return name;
    }
    
    @Override
    public int doAbility() {
        return stat;
    }
}
