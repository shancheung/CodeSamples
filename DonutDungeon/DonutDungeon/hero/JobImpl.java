package main.java.donutdungeon.hero;

import java.util.ArrayList;
import main.java.donutdungeon.hero.Hero;
import main.java.donutdungeon.hero.abilities.Ability;
import main.java.donutdungeon.hero.abilities.AbilityFactory;

public abstract class JobImpl implements Job {

    public ArrayList<Ability> abilities = new ArrayList<Ability>();
    public String description;
    public AbilityFactory abilityFacto = new AbilityFactory();
    public Ability abili;

    @Override
    public void getDescription() {
        System.out.println(description);
    }
    
    @Override
    public ArrayList<Ability> getAbilityList() {
        return abilities;
    }
    
    @Override
    public void displayAbilities() {
        String abi;
        int stat;
        int counter = 1;
        System.out.println("-----Attack Name-------Damage-----");
        for (int i = 0; i < abilities.size(); i++) {
            abi = abilities.get(i).abilityName();
            stat = abilities.get(i).doAbility();    //Was originally just dmg.
            System.out.println(counter + ". " + abi + "          " + stat);
            counter++;
        }
    }
    
    @Override
    public Ability getAbility(int i) {
        abili = abilities.get(i);
        return abili;
    }
    
}
