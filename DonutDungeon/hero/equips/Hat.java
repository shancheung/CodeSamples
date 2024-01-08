package main.java.donutdungeon.hero.equips;

import main.java.donutdungeon.hero.Hero;
import main.java.donutdungeon.hero.Stats;

public class Hat implements Equips {
    private String equiptype = "Hat";
    private int def = 3;   //def a part
    private String bonus;
    
    public Hat() {
    }
    
    @Override
    public String equipType() {
        return equiptype;
    }
    
    @Override
    public int baseStats() {
        return def;
    }
    
    /**
     *  For setting enhancements in Factory.
     */
    @Override
    public void setVal(int val) {
        def += val;
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
        if (!bonus.equals("")) {    //uh im gonna have to figure this out later
            System.out.println("Bonus: " + bonus);
        } else {
            System.out.println("No bonus");
        }
    }
}
