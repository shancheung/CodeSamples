package main.java.donutdungeon.dungeon.shop;

/**
 *  Strategy implementation for my shoppe.
 *  Fun fact, I often mispell strategy.
 */

public class ShopContext {
    private ShopStrategy ss;
    
    public ShopContext(ShopStrategy ss) {
        this.ss = ss;
    }
    
    public int performStrat(int money, int price) {
        return ss.shopOps(money,price);
    }
}
