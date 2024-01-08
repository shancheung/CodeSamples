package test.java;

/**
 *  So I know this test file is extremely small, but that's because shop is only implemented
 *  to the extent of just demonstrating its strategy pattern, generating its own goods randomly,
 *  the things shop primarily does:
 *      - Display Inventory - shows the player what its selling this time.
 *      -       Buy Item    - mock transaction of a player buying an item.
 *      -      Sell Item    - mock transaction of a player selling an item to the shop.
 *  Everything to perform these are inside of Shop itself, so testing this is ... awkward.  
 *  
 *  IMPORANT: Shop cannot test a lot of its functions because it stocks 3 random items, so
 *  per generation, we can keep making the shop keeper refresh his stock to try and get more but
 *  consider this per generation:
 *          Only 1/5 scrolls may be displayed.
 *          Only 1/3 potions may be displayed.
 *          Only 1/3 equips may be displayed and ABSOLUTELY WILL NOT show you the bonus.
 *              ... I like a good bit of chaos when buying items.
 */
 
import java.util.ArrayList;

import main.java.donutdungeon.dungeon.shop.Shop;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WhiteBoxShop {
    Shop shop;
    
    @Before
    public void setUp() {
        shop = new Shop();
    }
    
    /**
     *  When a shop is entered, the shopkeep shows off his wares, this is called a few times
     *  to try and just grab more coverage and to show that the stock is indeed randomized.
     *  I spawned 10 instances of a shop to try and just get a bit more coverage but probability
     *  makes it hard. Results will vary per test generation.
     */
    @Test
    public void shopDisplay() {
        for (int i = 0; i < 10; i++) {
            shop.displayInventory();
        }
    }
    
    /**
     *  When the player buys an item.
     */
    @Test
    public void shopBuyTransaction() {
        shop.buyItem();
    }
    
    /**
     *  When a player sells an item to the shop.
     */
    @Test
    public void shopSellTransaction() {
        shop.sellItem();
    }
}
