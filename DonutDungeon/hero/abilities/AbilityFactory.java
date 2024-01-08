package main.java.donutdungeon.hero.abilities;

public class AbilityFactory {

    /**
     * Just part of the factory. So far only has basic attack may look into stratedgy.
     */
    public Ability getAbility(String abil) {
        if (abil.equalsIgnoreCase("BasicAttack")) {
            return new BasicAttack();
        }
        if (abil.equalsIgnoreCase("GetMad")) {
            return new GetMad();
        } 
        if (abil.equalsIgnoreCase("Dance")) {
            return new Dance();
        } 
        if (abil.equalsIgnoreCase("Anxiety")) {
            return new Anxiety();
        } 
        return null;
    }
}
