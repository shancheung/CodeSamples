package main.java.donutdungeon;

/*
 *  I just want you to know I've spent the last 4 days, roughly 10 hours a day
 *  ALONE on this project. I've also been working on the group orject.
 *  It is now 4/23 and I'm feeling sick, my head feels weird.
 *  It is 4/24. I still feel awful.
 *  @author Shannon Mchugh (sjmchugh).
 */

import java.util.ArrayList;

import main.java.donutdungeon.dungeon.monsters.BossMonster;
import main.java.donutdungeon.dungeon.monsters.MidMonster;
import main.java.donutdungeon.dungeon.monsters.Monster;
import main.java.donutdungeon.dungeon.monsters.MonsterDecorator;
import main.java.donutdungeon.dungeon.monsters.MonsterFactory;
import main.java.donutdungeon.dungeon.monsters.RareDeco;
import main.java.donutdungeon.dungeon.monsters.StandardMonsterDeco;
import main.java.donutdungeon.dungeon.monsters.WeakMonster;

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

import main.java.donutdungeon.dungeon.shop.Shop;

import main.java.donutdungeon.hero.Android;
import main.java.donutdungeon.hero.Hero;
import main.java.donutdungeon.hero.JobEngineer;
import main.java.donutdungeon.hero.Ogre;
import main.java.donutdungeon.hero.RaceEngineer;

import main.java.donutdungeon.hero.equips.EquipFactory;
import main.java.donutdungeon.hero.equips.Equips;

public class Main {

    /**
     *  Just main() function, spotbugs won't stop crying.
     *  @param args ist just main chill.
     */
    public static void main(String[] args) {
        
        ArrayList<Hero> list = new ArrayList<Hero>();   //Fine checkstyle keep crying i don't care.
        final EquipFactory equipFacto = new EquipFactory();
        
        //Equip initialization was here, but checkstyle complained. :(
        
        //Hero1 birth.
        Hero test = new Hero("Sakura");
        test.setRace(1);
        test.setJob(1);
        list.add(test);
        Equips hat2 = equipFacto.getEquip("Hat");
        Equips wep2 = equipFacto.getEquip("Weapon");
        Equips cape2 = equipFacto.getEquip("Cape");
        test.addEquip(hat2);
        test.addEquip(wep2);
        test.addEquip(cape2);
        
        //Hero2 birth.
        Hero test2 = new Hero("Spooby");
        test2.setRace(2);
        test2.setJob(2);
        list.add(test2);
        Equips hat3 = equipFacto.getEquip("Hat");
        Equips wep3 = equipFacto.getEquip("Weapon");
        Equips cape3 = equipFacto.getEquip("Cape");
        test2.addEquip(hat3);
        test2.addEquip(wep3);
        test2.addEquip(cape3);
        
        //Hero3 birth.
        Hero test3 = new Hero("Thom");
        test3.setRace(3);
        test3.setJob(3);
        list.add(test3);
        Equips hat1 = equipFacto.getEquip("Hat");
        test3.addEquip(hat1);
        Equips wep1 = equipFacto.getEquip("Weapon");
        test3.addEquip(wep1);
        Equips cape1 = equipFacto.getEquip("Cape");
        test3.addEquip(cape1);
        
        //Figure out life for the heroes, who and what they are.
        //But also tell us about it.
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i).getName();
            String r = list.get(i).getRace();
            String j = list.get(i).getJob();
            System.out.println(name + " the " + r + " " + j);
            System.out.println("--------------------");
            switch (r) {
                case "Ogre":
                    list.get(i).ogre.getDescription();
                    list.get(i).ogre.getStats();
                    System.out.println("=======Current Stats=======");
                    list.get(i).ogre.displayEquipStats(hat2);
                    list.get(i).ogre.displayEquipStats(wep2);
                    list.get(i).ogre.displayEquipStats(cape2);
                    list.get(i).ogre.getCurrentStats();
                    break;
                case "JellyFolk":
                    list.get(i).jf.getDescription();
                    list.get(i).jf.getStats();
                    System.out.println("=======Current Stats=======");
                    list.get(i).jf.displayEquipStats(hat3);
                    list.get(i).jf.displayEquipStats(wep3);
                    list.get(i).jf.displayEquipStats(cape3);
                    list.get(i).jf.getCurrentStats();
                    break;
                case "Android":
                    list.get(i).andy.getDescription();
                    list.get(i).andy.getStats();
                    System.out.println("=======Current Stats=======");
                    list.get(i).andy.displayEquipStats(hat1);//THIS WAS IN THE WRONG PLACE FOR HRS
                    list.get(i).andy.displayEquipStats(wep1);
                    list.get(i).andy.displayEquipStats(cape1);
                    list.get(i).andy.getCurrentStats();
                    break;
                default:
                    break;
            }
            switch (j) {
                case "Archer":
                    list.get(i).archer.getDescription();
                    list.get(i).archer.displayAbilities();
                    break;
                case "Summoner":
                    list.get(i).summoner.getDescription();
                    list.get(i).summoner.displayAbilities();
                    break;
                case "Hornet":
                    list.get(i).hornet.getDescription();
                    list.get(i).hornet.displayAbilities();
                    break;
                default:
                    break;
            }
            System.out.println();
            list.get(i).getEquips();
            System.out.println("====Abilities====");
            list.get(i).useAbility(0);
            System.out.println();
            list.get(i).useAbility(1);
            System.out.println("\n\n");
        }
        
        ///////////////////////////////////////////////////////////////
        //Potion section
        //generation and calculation.
        //Does not account for drinking, it's just the calculated amount to actually heal.
        
        Potion smalPot = new WeakHealDecorator(new HealingPotion());
        int hpGrabbedTest1 = test.ogre.getHp();
        smalPot.setCurrentHp(hpGrabbedTest1);
        
        Potion medPot = new MedHealDecorator(new HealingPotion());
        medPot.setCurrentHp(hpGrabbedTest1);
        Potion bigPot = new HighHealDecorator(new HealingPotion());
        bigPot.setCurrentHp(hpGrabbedTest1);
        
        System.out.println("=============Potion generation=============");
        
        System.out.println("Small potion " 
            + "\n-Description: " + smalPot.potionName()
            + "\n---Heal Amount for " + test.getName() + " with Max HP val: " + hpGrabbedTest1
            + "\n---Amount to be healed by " + smalPot.potionName() + ": " 
            + smalPot.getRecoveryAmt() + "\n");
        System.out.println("Medium potion " 
            + "\n-Description: " + medPot.potionName()
            + "\n---Heal Amount for " + test.getName() + " with Max HP val: " + hpGrabbedTest1
            + "\n---Amount to be healed by " + medPot.potionName() + ": " 
            + medPot.getRecoveryAmt() + "\n");
        System.out.println("BIG potion " 
            + "\n-Description: " + bigPot.potionName()
            + "\n---Heal Amount for " + test.getName() + " with Max HP val: " + hpGrabbedTest1
            + "\n---Amount to be healed by " + bigPot.potionName() + ": " 
            + bigPot.getRecoveryAmt() + "\n\n");
            
        ///////////////////////////////////////////////////////////////
        // Time to demonstrate potion consume!
        
        //Sample for when there's some overheal.
        int max = test.ogre.getHp();
        System.out.println("Sakura's max hp: " + max);
        
        test.ogre.reduceHp(3);
        System.out.println("Sakura took some damage! -3 to current hp. " 
            + "Current hp: " + test.ogre.getCurrHp());
        test.consumeHealPot(max, medPot.getRecoveryAmt());
        //See tests for more outputs <3
        
        ///////////////////////////////////////////////////////////////
        //Monster section
        //The idea was to combine the monster generation with a factory
        //to make life easier when trying to generate some monster.
        
        System.out.println("\n\n=============Monster generation=============");
        //Basic generation similar to above.
        Monster monster1 = new StandardMonsterDeco(new WeakMonster());
        System.out.println("Monster: " + monster1.monsterName());
        monster1.displayMonStats(); 
        System.out.println();
        
        //Trying with the factory now.
        final MonsterFactory mfactory = new MonsterFactory();
        Monster moFacto1 = mfactory.generateMonster("weak");
        System.out.println("Monster from factory: " + moFacto1.monsterName());
        moFacto1.displayMonStats();
        moFacto1.determineLoot();
        
        System.out.println("\nForcing a rare monster to spawn for observation purposes.");
        monster1 = new RareDeco(new WeakMonster());
        System.out.println("Monster 2: " + monster1.monsterName());
        monster1.displayMonStats();
        monster1.determineLoot();
        
        //I realize I probably should've added them to a list but I'm doing this as I go.
        System.out.println("\nSpawning mid monster.");
        Monster moFacto2 = mfactory.generateMonster("mid");
        System.out.println("Monster from factory: " + moFacto2.monsterName());
        moFacto2.displayMonStats();
        moFacto2.determineLoot();
        
        System.out.println("\nSpawning Boss monster.");
        Monster moFacto3 = mfactory.generateMonster("boss");
        System.out.println("Monster from factory: " + moFacto3.monsterName());
        moFacto3.displayMonStats();
        moFacto3.determineLoot();
        
        System.out.println("\n\n-------------------Adept Monsters-------------------- ");
        System.out.println("Cycle 2: Adept Monsters");
        
        Monster moFacto4 = mfactory.generateAdeptMonster("weak");
        final Monster moFacto5 = mfactory.generateAdeptMonster("mid");
        final Monster moFacto6 = mfactory.generateAdeptMonster("boss");
        
        System.out.println("Monster from factory: " + moFacto4.monsterName());
        moFacto4.displayMonStats();
        moFacto4.determineLoot();
        System.out.println();
        System.out.println("Monster from factory: " + moFacto5.monsterName());
        moFacto5.displayMonStats();
        moFacto5.determineLoot();
        System.out.println();
        System.out.println("Monster from factory: " + moFacto6.monsterName());
        moFacto6.displayMonStats();
        moFacto6.determineLoot();
        System.out.println("\n");
        
        System.out.println(" -------------------Elite Monsters-------------------- ");
        System.out.println("Cycle 2: Elite Monsters");
        Monster moFacto7 = mfactory.generateEliteMonster("weak");
        final Monster moFacto8 = mfactory.generateEliteMonster("mid");
        final Monster moFacto9 = mfactory.generateEliteMonster("boss");
        
        System.out.println("Monster from factory: " + moFacto7.monsterName());
        moFacto7.displayMonStats();
        moFacto7.determineLoot();
        System.out.println();
        System.out.println("Monster from factory: " + moFacto8.monsterName());
        moFacto8.displayMonStats();
        moFacto8.determineLoot();
        System.out.println();
        System.out.println("Monster from factory: " + moFacto9.monsterName());
        moFacto9.displayMonStats();
        moFacto9.determineLoot();
        System.out.println("\n");
        
        System.out.println(" -------------------Master Monsters-------------------- ");
        System.out.println("Cycle 2: Master Monsters");
        Monster moFacto10 = mfactory.generateMasterMonster("weak");
        final Monster moFacto11 = mfactory.generateMasterMonster("mid");
        final Monster moFacto12 = mfactory.generateMasterMonster("boss");
        
        System.out.println("Monster from factory: " + moFacto10.monsterName());
        moFacto10.displayMonStats();
        moFacto10.determineLoot();
        System.out.println();
        System.out.println("Monster from factory: " + moFacto11.monsterName());
        moFacto11.displayMonStats();
        moFacto11.determineLoot();
        System.out.println();
        System.out.println("Monster from factory: " + moFacto12.monsterName());
        moFacto12.displayMonStats();
        moFacto12.determineLoot();
        System.out.println("\n");
        
        System.out.println("\n======================================\n");
        ///////////////////////////////////////////////////////////////
        //Scroll section
        
        //Let's start by just spawning some scrolls in, right via factory.
        final ScrollFactory sfacto = new ScrollFactory();
        final ArrayList<Scroll> scrollList = new ArrayList<Scroll>();
        
        int cha;
        int dodgeval = test3.andy.getDodge();
        System.out.println(test3.getName() + "'s dodge value (used for stat change calc):  " 
            + dodgeval + "\n");
        
        Scroll scroll = sfacto.generateScroll("Cripple");
        scrollList.add(scroll);
        Scroll scroll2 = sfacto.generateScroll("Blessed");
        scrollList.add(scroll2);
        Scroll scroll3 = sfacto.generateScroll("Cursed");
        scrollList.add(scroll3);
        Scroll scroll4 = sfacto.generateScroll("Imprisioned");
        scrollList.add(scroll4);
        Scroll scroll5 = sfacto.generateScroll("inspired");
        scrollList.add(scroll5);
        
        for (int i = 0; i < scrollList.size(); i++) {
            System.out.println("Factory scroll generated: " + scrollList.get(i).scrollName());
            cha = scrollList.get(i).setStatChange(dodgeval);
            System.out.println("- - " + scrollList.get(i).scrollDescription());
            System.out.println("- - Stat change after application: " 
                + scrollList.get(i).getStatChange() + " dodge");
                
            if (scrollList.get(i) == scroll4) {
                scrollList.get(i).endState();
            }
            if (scrollList.get(i) == scroll5) {
                scrollList.get(i).endState();
            }
            System.out.println();
        }
        ///////////////
        //I'm very sad spawning random scrolls doesn't work I just left this here for you to see.
        //There's a few attempts at getting something to work, but none really worked as intended.
        ///////////////
        
        //Let's spawn a few randomly, put them in a list and get their names and see what we get!
        /*
        final ArrayList<Scroll> scrollList2 = new ArrayList<Scroll>();
        Scroll scroll6 = sfacto.generateScroll("RANDOM");   //spawn the suckers
        Scroll scroll7 = sfacto.generateScroll("RANDOM");
        Scroll scroll8 = sfacto.generateScroll("RANDOM");
        Scroll scroll9 = sfacto.generateScroll("RANDOM");
        Scroll scroll10 = sfacto.generateScroll("RANDOM");
        
        scrollList2.add(scroll6);    //add them to list
        scrollList2.add(scroll7);
        scrollList2.add(scroll8);
        scrollList2.add(scroll9);
        scrollList2.add(scroll10);

        
        System.out.println("Random scroll generated: " + scroll6.scrollName());
        
        for (int i = 0; i < scrollList2.size(); i++) {
            System.out.println("Random scroll generated: " + scrollList2.get(i).scrollName());
        }*/
        System.out.println("\n\n=============Shop generation=============");
        ///////////////////////////////////////////////////////////////
        //Shop section
        System.out.println("Get in, we're going shopping.\n");
        Shop shop = new Shop();
        
        shop.displayInventory();
        System.out.println();
        shop.buyItem();
        shop.sellItem();
    }
}
