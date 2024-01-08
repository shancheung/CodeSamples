package test.java;

import main.java.donutdungeon.hero.Android;
import main.java.donutdungeon.hero.Hero;
import main.java.donutdungeon.hero.JellyFolk;
import main.java.donutdungeon.hero.Ogre;
import main.java.donutdungeon.hero.RaceEngineer;

import main.java.donutdungeon.hero.equips.EquipFactory;
import main.java.donutdungeon.hero.equips.Equips;
import main.java.donutdungeon.hero.equips.Hat;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class WhiteBoxHero { 

    Hero testHero;
    Hero testHero2;
    Hero testHero3;
    Hero testHero4;
    
    Ogre ogre;
    JellyFolk jelly;
    Android android;
    
    EquipFactory equipFacto = new EquipFactory();
        
    
    int testStr;    //Str = strength here, not string.
    String race;
    String job;
    
    /**
     * Setup before running test.
     */
    @Before
    public void setUp() throws Exception {
        testHero = new Hero("Ogre Hero");
        testHero.setRace(1);
        testHero.setJob(1);
        ogre = testHero.ogre;
        
        testHero2 = new Hero("JellyFolk Hero");
        testHero2.setRace(2);
        testHero2.setJob(2);
        jelly = testHero2.jf;
        
        testHero3 = new Hero("Android Hero");
        testHero3.setRace(3);
        testHero3.setJob(3);
        android = testHero3.andy;
        
        Equips hat1 = equipFacto.getEquip("Hat");
        Equips wep1 = equipFacto.getEquip("Weapon");
        Equips cape1 = equipFacto.getEquip("Cape");
        
    }   
    
    /*
     *  Test to see if race Ogre has the right label.
     */
    @Test
    public void setRaceOgre() {
        race = testHero.getRace();
        assertEquals("Ogre", race);
    }
    
    /*
     *  Test to see if race Ogre has the right label.
     */
    @Test
    public void getRaceJelly() {
        race = testHero2.getRace();
        assertEquals("JellyFolk", race);
    }
    
    /*
     *  Test to see if race Ogre has the right label.
     */
    @Test
    public void getRaceAndro() {
        race = testHero3.getRace();
        assertEquals("Android", race);
    }
    
    /*
     *  Make sure it isn't a jellyfolk!
     */
    @Test
    public void isOgreNotJellyFolk() {
        
        race = testHero.getRace();
        assertNotEquals("JellyFolk", race);
    }
    
    /*
     *  Test to see if race Ogre has the right label.
     */
    @Test
    public void getJobHero() {
        job = testHero.getJob();
        assertEquals("Archer", job);
    }
    
    /*
     *  Test to see if race Ogre has the right label.
     */
    @Test
    public void getJobHero2() {
        job = testHero2.getJob();
        assertEquals("Summoner", job);
    }
    
    /*
     *  Test to see if race Ogre has the right label.
     */
    @Test
    public void getJobHero3() {
        job = testHero3.getJob();
        assertEquals("Hornet", job);
    }
    
    /*
     * Test to see if Ogre has the right starting strength stat.
     */
    @Test
    public void ogreStr() {
        testStr = testHero.ogre.getStrength();
        //testHero.ogre.displayStrength();
        //System.out.println(testStr);
        assertEquals(8, testStr);
    }
     
    /*
     * Test to see if stats can be updated.
     */
    @Test
    public void updateStr() {
        testHero.ogre.setStrength(99);
        testStr = testHero.ogre.getStrength();
        assertEquals(99, testStr);
    }
    
    /*
     * Test to see if weapons can be held by some hero.
     */
    @Test
    public void obtainWeapon() {
        Equips wep1 = equipFacto.getEquip("Weapon");
        testHero.addEquip(wep1);
        testHero.ogre.displayEquipStats(wep1);
    }
    
    /*
     * Ogre, can you please wear this cape? thanks.
     */
    @Test
    public void obtainCape() {
        Equips cape = equipFacto.getEquip("Cape");
        testHero.addEquip(cape);
        testHero.ogre.displayEquipStats(cape);
    }
    
    /*
     * Ogre trying to wear hat.
     */
    @Test
    public void obtainHat() {
        Equips hat = equipFacto.getEquip("Hat");
        testHero.addEquip(hat);
        testHero.ogre.displayEquipStats(hat);
    }
    
    /*
     * Fashion show, bring out the equips.
     */
    @Test
    public void gearCheck() {
        Equips wep1 = equipFacto.getEquip("Weapon");
        testHero2.addEquip(wep1);
        Equips hat1 = equipFacto.getEquip("Hat");
        testHero2.addEquip(hat1);
        Equips cape1 = equipFacto.getEquip("Cape");
        testHero2.addEquip(cape1);
        testHero2.getEquips();
    }
    
    /**
     *  Show ya moves, hornet.
     */
    @Test
    public void displayAbilitiesHornet() {
        testHero3.hornet.displayAbilities();
        testHero3.useAbility(1);
    }
    
    /**
     *  Show ya moves, summoner.
     */
    @Test
    public void displayAbilitiesSummoner() {
        testHero2.summoner.displayAbilities();
        testHero2.useAbility(1);
    }
    
    /**
     *  Show ya moves, archer. Note: Test always fail if you get the job wrong.
     */
    @Test
    public void displayAbilitiesArcher() {
        testHero.archer.displayAbilities();
        testHero.useAbility(1);
    }
    
    
}
