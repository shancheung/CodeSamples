package main.java.donutdungeon.dungeon.shop;

/**
 *  So the plan here is to use the operations in Shop.java for each item the merchant is selling.
 */

public class OpperationBuy implements ShopStrategy {
    @Override
    public int shopOps(int money, int price) {
        int change = money - price;
        if (money > price) {
            System.out.println("Merchant: Fine, she's yours.");
            change = money - price;
        } else {
            System.out.println("The merchant gives you THE dirtiest look");
            change = 0;
        }
        return change;
    }
}
