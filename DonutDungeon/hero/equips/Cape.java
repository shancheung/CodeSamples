package main.java.donutdungeon.hero.equips;

import main.java.donutdungeon.hero.Hero;
import main.java.donutdungeon.hero.Stats;

public class Cape implements Equips {
    private String equiptype = "Cape";
    private int spd = 1;   //def a part
    private String bonus;
    
    public Cape() {
    }
    
    @Override
    public String equipType() {
        return equiptype;
    }
    
    @Override
    public int baseStats() {
        return spd;
    }
    
    @Override
    public void setVal(int val) {
        spd += val;
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
