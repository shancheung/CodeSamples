package main.java.donutdungeon.hero.equips;

import main.java.donutdungeon.hero.Hero;
import main.java.donutdungeon.hero.Stats;

public class Weapon implements Equips {
    private String equiptype = "Weapon";
    private int atk = 5;   //def a part
    private String bonus;
    
    public Weapon() {
    }
    
    @Override
    public String equipType() {
        return equiptype;
    }
    
    @Override
    public int baseStats() {
        return atk;
    }
    
    @Override
    public void setVal(int val) {
        atk += val;
    }
    
    @Override
    public String special() {
        return bonus;
    }
    
    @Override
    public void setSpecialMsg(String msg) {
        bonus = msg;
    }
    
    @Override
    public void displayEquip() {
        System.out.println("Observing: " + equipType());
        if (!bonus.equals("")) {
            System.out.println("Bonus: " + bonus);
        } else {
            System.out.println("No bonus");
        }
    }
}
