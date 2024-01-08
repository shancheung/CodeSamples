package main.java.donutdungeon.dungeon.shop;

/**
 *  So this class is just containing functions for the shop to function.
 *  Absolutely stealing half of this from other classes I wrote, like MonsterDecorator.java
 *  The context class will have its own class.
 */

import java.util.Random;    //For loot generation

import main.java.donutdungeon.dungeon.potions.HealingPotion;
import main.java.donutdungeon.dungeon.potions.HighHealDecorator;
import main.java.donutdungeon.dungeon.potions.MedHealDecorator;
import main.java.donutdungeon.dungeon.potions.Potion;
import main.java.donutdungeon.dungeon.potions.WeakHealDecorator;

import main.java.donutdungeon.dungeon.scrolls.BlessedScroll;
import main.java.donutdungeon.dungeon.scrolls.ConcreteScroll;
import main.java.donutdungeon.dungeon.scrolls.CursedScroll;
import main.java.donutdungeon.dungeon.scrolls.ImprisionedScroll;
import main.java.donutdungeon.dungeon.scrolls.InspiredScroll;
import main.java.donutdungeon.dungeon.scrolls.Scroll;
import main.java.donutdungeon.dungeon.scrolls.ScrollDecorator;
import main.java.donutdungeon.dungeon.scrolls.ScrollFactory;

import main.java.donutdungeon.dungeon.shop.ShopContext;

import main.java.donutdungeon.hero.equips.EquipFactory;
import main.java.donutdungeon.hero.equips.Equips;

public class Shop {
    protected Random rando = new Random();
    protected final EquipFactory equipFacto = new EquipFactory();
    protected final ScrollFactory sfacto = new ScrollFactory();
    public Equips equip;
    public Potion potion;
    public Scroll scroll;
        
    /**
     *  Set up shop's inventory! It'll always be a surprise.
     */
    public void setInventory() {
        potion = stockPotion();
        equip = stockEquip();
        scroll = stockScroll();
    }
    
    /**
     *  Display ya goods, shopkeeper.
     */
    public void displayInventory() {
        System.out.println("Ho-ho! Check out my wares noob, they're sicker than what you've got"
            + " in your crusty pockets.");
        setInventory();
        System.out.println(" 1- Potion : " + potion.potionName());
        System.out.println(" 2- Equip  : " + equip.equipType() 
            + "..? What you wanted to know the bonus? Tch. Kids these days.");
        System.out.println(" 3- Scroll : " + scroll.scrollName());
        System.out.println("\n... I can also buy some of your trash items, I guess.");
    }
    
    /**
     *  Maybe the buy/sell options should be in this class, here's the buy one.
     */
    public void buyItem() {
        //Just pretend our user, no matter what, wants to buy scrolls. Maybe they have a habit.
        System.out.println("Oh? You'd like to buy the scroll? That'll be 50 coins.");
        ShopContext shopcon = new ShopContext(new OpperationBuy());
        System.out.println("[You have 200 coins and you spent 50 on the scroll.]");
        System.out.println("[You have " + shopcon.performStrat(200, 50) + " coins left.]\n");
    }
    
    /**
     *  Maybe the buy/sell options should be in this class, here's the buy one.
     *  Also, these functions are purly for demonstration purposes.
     */
    public void sellItem() {
        //Just pretend our user, no matter what, wants to buy scrolls. Maybe they have a habit.
        System.out.println("Oh? You'd like to sell the scroll now? Fine, weirdo.");
        ShopContext shopcon = new ShopContext(new OperationSell());
        System.out.println("[You have " + shopcon.performStrat(200, 25) + " coins now! Yay!.]\n");
    }
    
    /**
     *  Shopkeeper stocks exactly one random potion.
     */
    public Potion stockPotion() {
        int v = rando.nextInt(5) + 1;
        if (v == 5) {   
            Potion bigPot = new HighHealDecorator(new HealingPotion());
            return bigPot;
        } else if (v < 4 && v != 5) {
            Potion medPot = new MedHealDecorator(new HealingPotion());
            return medPot;
        } else {
            Potion smalPot = new WeakHealDecorator(new HealingPotion());
            return smalPot;
        }
    }
   
    /**
     *  I want the shop keeper to have one random equip.
     */
    public Equips stockEquip() {
        int v = rando.nextInt(5) + 1;
        if (v == 5) {
            Equips cape = equipFacto.getEquip("Cape");
            return cape;
        } else if (v < 4 && v != 5) {
            Equips weapon = equipFacto.getEquip("Weapon");
            return weapon;
        } else {
            Equips hat = equipFacto.getEquip("Hat");
            return hat;
        }
    }
    
    /**
     *  Gonna give random scroll generation another sad sorry shot.
     */
    public Scroll stockScroll() {
        int v = rando.nextInt(5) + 1;
        if (v == 5) {
            Scroll scroll = sfacto.generateScroll("Cripple");
            return scroll;
        } else if (v == 4) {
            Scroll scroll2 = sfacto.generateScroll("Blessed");
            return scroll2;
        } else if (v == 3) {
            Scroll scroll3 = sfacto.generateScroll("Cursed");
            return scroll3;
        } else if (v == 2) {
            Scroll scroll4 = sfacto.generateScroll("Imprisioned");
            return scroll4;
        } else {
            Scroll scroll5 = sfacto.generateScroll("inspired");
            return scroll5;
        }
    }
}
