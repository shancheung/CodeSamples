package main.java.donutdungeon.dungeon.shop;

/**
 *  WE'RE GONNA SELL OUR EQUIPMENT TO THE MERCHANT.
 */

public class OperationSell implements ShopStrategy {
    @Override
    public int shopOps(int money, int price) {
        money += price; //Price is just what he'll buy it at. This won't be too deep though.
        return money;
    }
}
