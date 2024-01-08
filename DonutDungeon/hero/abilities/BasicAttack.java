package main.java.donutdungeon.hero.abilities;

/**
 *  Basic melee attack, should eventually have a ...... 10% chance to miss.
 */ 
 
import java.util.Random;

public class BasicAttack implements Ability {
    private String name = "Basic Attack";
    private Random rand = new Random();
    private int damage = 5;
    
    @Override
    public String abilityName() {
        return name;
    }
    
    @Override
    public int doAbility() {
        int randDet = rand.nextInt(10) + 1;    // 1 in 10 chance.
        if (randDet == 1) { //MISS!
            System.out.println("MISS!");
            damage = 0;
            return damage;
        } else if (randDet == 3 || randDet == 7) {  //CRITICAL HIT
            System.out.println("CRITICAL HIT!");
            damage = damage * 2;
            return damage;
        } else {
            return damage;
        }
    }
}
