package test.java;

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

import main.java.donutdungeon.hero.Hero;
import main.java.donutdungeon.hero.JellyFolk;
import main.java.donutdungeon.hero.RaceEngineer;

import main.java.donutdungeon.hero.equips.Equips;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WhiteBoxMonstersAndPotions {
    final MonsterFactory monTestFactory = new MonsterFactory();
    ArrayList<Integer> statList = new ArrayList<Integer>();
    ArrayList<Integer> statList2 = new ArrayList<Integer>();
    
    String name;
    String name2;
    
    int hp;
    int recoverAmt;
    int jfmax;  //JellyFolk max hp
    
    //Specifically factory made monsters, checking them against
    //monsters made just by "hand". Making sure factory does as intended.
    Monster testFactoWeakMon;
    Monster testFactoMidMon;
    Monster testFactoBossMon;
    
    //Cycle 1 monsters - Normal
    Monster testWeakMon;
    Monster testWeakRareMon;
    Monster testMidMon;
    Monster testBossMon;
    
    //Cycle 2 monsters - Adept
    Monster adeptWeak;
    Monster adeptMid;
    Monster adeptBoss;
    
    //Cycle 3 monsters - Elite
    Monster eliteWeak;
    Monster eliteMid;
    Monster eliteBoss;
    
    //Cycle 4 monsters - Master
    Monster masterWeak;
    Monster masterMid;
    Monster masterBoss;
    
    //Our very own jellyfolk hero
    Hero testHero;
    JellyFolk jf;
    
    //Some potions.
    Potion potion;
    Potion smalPot;
    Potion medPot;
    Potion bigPot;
    
    Equips equip;
    
    /**
     *  Setup before tests.
     */
    @Before
    public void setUp() throws Exception {
        //Factory generation monsters, normal monsters.
        testFactoWeakMon = monTestFactory.generateMonster("weak");
        testFactoMidMon = monTestFactory.generateMonster("mid");
        testFactoBossMon = monTestFactory.generateMonster("boss");
    
        //Non factory generation, normal monsters.
        testWeakMon = new StandardMonsterDeco(new WeakMonster());
        testWeakRareMon = new RareDeco(new WeakMonster());
        testMidMon = new StandardMonsterDeco(new MidMonster());
        testBossMon = new StandardMonsterDeco(new BossMonster());
        
        //Generate a hero
        testHero = new Hero("Tengu");
        testHero.setRace(2);
        testHero.setJob(1);
        jf = testHero.jf;
        jfmax = testHero.jf.getHp();
        
        //Generate potions
        smalPot = new WeakHealDecorator(new HealingPotion());
        medPot = new MedHealDecorator(new HealingPotion());
        bigPot = new HighHealDecorator(new HealingPotion());
        
        //Generate adept tier monsters.
        adeptWeak = monTestFactory.generateAdeptMonster("weak");
        adeptMid = monTestFactory.generateAdeptMonster("mid");
        adeptBoss = monTestFactory.generateAdeptMonster("boss");
        
        //Generate elite tier monsters.
        eliteWeak = monTestFactory.generateEliteMonster("weak");
        eliteMid = monTestFactory.generateEliteMonster("mid");
        eliteBoss = monTestFactory.generateEliteMonster("boss");
        
        //Generate master tier monsters.
        masterWeak = monTestFactory.generateMasterMonster("weak");
        masterMid = monTestFactory.generateMasterMonster("mid");
        masterBoss = monTestFactory.generateMasterMonster("boss");
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////
    // MONSTER SECTION
    
    /**
     *  Tests to see if weak monsters and the rare spawn have different stats.
     */
    @Test
    public void weakVsSpecialMonGeneration() {
        System.out.println("Regular weak monster stats:");
        testWeakMon.displayMonStats();
        System.out.println("\nRare weak monster stats:");
        testWeakRareMon.displayMonStats();
        
        statList = testWeakMon.getStats();
        statList2 = testWeakRareMon.getStats();
        assertNotEquals(statList, statList2);
    }
    
    /**
     *  Tests to see if weak monsters and the rare spawn have different stats.
     */
    @Test
    public void weakVsSpecialMonGenerationName() {
        name2 = testWeakMon.monsterName();
        name = testWeakRareMon.monsterName();
        assertNotEquals(name, name2);
    }
    
    /**
     *  Tests to see if factory generated mid monsters match hardcoded Deco generated ones.
     */
    @Test
    public void midMonGeneration() {
        testFactoMidMon.setStats();
        testMidMon.setStats();
        
        statList = testFactoMidMon.getStats();
        statList2 = testMidMon.getStats();
        
        assertEquals(statList, statList2);
    }
    
    /**
     *  Tests to see if factory generated boss monsters match hardcoded Deco generated ones.
     */
    @Test
    public void bossMonGeneration() {
        testFactoBossMon.setStats();
        testBossMon.setStats();
    
        statList = testFactoBossMon.getStats();
        statList2 = testBossMon.getStats();
        
        assertEquals(statList, statList2);
    }
    
    /**
     *  Testing to see that we can indeed generate equipment as possible loot.
     */
    @Test
    public void testLootEquips() {
        equip = testBossMon.lootEquip();
        assertTrue(equip instanceof Equips);
    }
    
    /**
     *  Testing to see that we can indeed generate potions as possible loot.
     */
    @Test
    public void testLootPotion() {
        potion = testBossMon.lootPotion();
        assertTrue(potion instanceof Potion);
    }
    
    /**
     *  Might be hard to test, but just check to see if determine loot works,
     *  It's difficult because of the rng, I don't really have a way to hardcode
     *  What comes out besides the above since its 50% either a potion or equip,
     *  then there's 3 of each kind - so maybe I should make sure that everyone can
     *  even have loot.
     *  It's not really worth testing the loot for higher rank monsters as the rates don't
     *  change.
     */
    @Test
    public void testLootDet() {
        System.out.println();
        testFactoWeakMon.determineLoot();
        System.out.println();
        testFactoMidMon.determineLoot();
        System.out.println();
        testFactoBossMon.determineLoot();
        System.out.println();
        testWeakMon.determineLoot();
        System.out.println();
        testMidMon.determineLoot();
        System.out.println();
        testBossMon.determineLoot();
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////
    // MONSTER SECTION II - Adept, Elite, and Master rank monsters.
    
    //-------------------------Weak Monsters----------------------------
    
    /**
     *  Making sure that weak monsters aren't the same as their adept counter parts.
     */
    @Test
    public void normalVsAdeptWeak() {
        testWeakMon.setStats();
        adeptWeak.setStats();
        
        testWeakMon.displayMonStats();  //Just a visual respresentation.
        adeptWeak.displayMonStats();
        
        statList = testWeakMon.getStats();
        statList2 = adeptWeak.getStats();
        
        assertNotEquals(statList, statList2);
    }
    
    /**
     *  Making sure that adept monsters aren't the same as their elite counter parts.
     */
    @Test
    public void eliteVsAdeptWeak() {
        eliteWeak.setStats();
        adeptWeak.setStats();
        
        eliteWeak.displayMonStats();  //Just a visual respresentation.
        adeptWeak.displayMonStats();
        
        statList = eliteWeak.getStats();
        statList2 = adeptWeak.getStats();
        
        assertNotEquals(statList, statList2);
    }
    
    /**
     *  Making sure that adept monsters aren't the same as their elite counter parts.
     */
    @Test
    public void eliteVsMasterWeak() {
        eliteWeak.setStats();
        masterWeak.setStats();
    
        eliteWeak.displayMonStats();  //Just a visual respresentation.
        masterWeak.displayMonStats();
    
        statList = eliteWeak.getStats();
        statList2 = masterWeak.getStats();
        
        assertNotEquals(statList, statList2);
    }
    
    //-------------------------Mid Monsters----------------------------
    
    /**
     *  Making sure that mid monsters aren't the same as their adept counter parts.
     */
    @Test
    public void normalVsAdeptMid() {
        testMidMon.setStats();
        adeptMid.setStats();
    
        statList = testMidMon.getStats();
        statList2 = adeptMid.getStats();
        
        assertNotEquals(statList, statList2);
    }
    
    /**
     *  Making sure that adept monsters aren't the same as their elite counter parts.
     */
    @Test
    public void eliteVsAdeptMid() {
        eliteMid.setStats();
        adeptMid.setStats();
    
        statList = eliteMid.getStats();
        statList2 = adeptMid.getStats();
        
        assertNotEquals(statList, statList2);
    }
    
    /**
     *  Making sure that adept monsters aren't the same as their elite counter parts.
     */
    @Test
    public void eliteVsMasterMid() {
        eliteMid.setStats();
        masterMid.setStats();
    
        statList = eliteMid.getStats();
        statList2 = masterMid.getStats();
        
        assertNotEquals(statList, statList2);
    }
    
    //-------------------------Boss Monsters----------------------------
    
    /**
     *  Making sure that Boss monsters aren't the same as their adept counter parts.
     */
    @Test
    public void normalVsAdeptBoss() {
        testBossMon.setStats();
        adeptBoss.setStats();
    
        statList = testBossMon.getStats();
        statList2 = adeptBoss.getStats();
        
        assertNotEquals(statList, statList2);
    }
    
    /**
     *  Making sure that adept monsters aren't the same as their elite counter parts.
     */
    @Test
    public void eliteVsAdeptBoss() {
        eliteBoss.setStats();
        adeptBoss.setStats();
    
        statList = eliteBoss.getStats();
        statList2 = adeptBoss.getStats();
        
        assertNotEquals(statList, statList2);
    }
    
    /**
     *  Making sure that adept monsters aren't the same as their elite counter parts.
     */
    @Test
    public void eliteVsMasterBoss() {
        eliteBoss.setStats();
        masterBoss.setStats();
    
        statList = eliteBoss.getStats();
        statList2 = masterBoss.getStats();
        
        assertNotEquals(statList, statList2);
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////
    // POTION SECTION
    
    /**
     *  Okay so this is going to have to be tested for every potion unfortunately,
     *  Just checks to see if it grabs hp properly, I know setters do not need testing
     *  But this is a very important setter.
     */
    @Test
    public void testSmallPotSetHp() {
        hp = smalPot.setCurrentHp(testHero.jf.getHp());
        assertEquals(20, hp);
    }
    
    /**
     *  Same as above, though I forgot to mention that the expected is 20 hp as that is how
     *  much max hp our character SHOULD have, this is important for testing the amount the
     *  potions want to recover, not how much they will actually recover.
     */
    @Test
    public void testMedPotSetHp() {
        hp = medPot.setCurrentHp(testHero.jf.getHp());
        assertEquals(20, hp);
    }
    
    /**
     *  Also same as above.
     */
    @Test
    public void testBigPotSetHp() {
        System.out.println();
        hp = bigPot.setCurrentHp(testHero.jf.getHp());
        assertEquals(20, hp);
    }
    
    /**
     *  Test the calculated amount to be recovered, this is a value that will be used
     *  once a hero consumes a potion, for small it's 15% of the max hp, also rounds up.
     */
    @Test
    public void testRecoveryAmtSmall() {
        System.out.println();
        hp = smalPot.setCurrentHp(testHero.jf.getHp());
        recoverAmt = smalPot.getRecoveryAmt(); 
        assertEquals(3, recoverAmt);
    }
    
    /**
     *  Test the calculated amount to be recovered, this is a value that will be used
     *  once a hero consumes a potion, for small it's 30% of the max hp, also rounds up.
     */
    @Test
    public void testRecoveryAmtMed() {
        hp = medPot.setCurrentHp(testHero.jf.getHp());
        recoverAmt = medPot.getRecoveryAmt(); 
        assertEquals(6, recoverAmt);
    }
    
    /**
     *  Test the calculated amount to be recovered, this is a value that will be used
     *  once a hero consumes a potion, for small it's 65% of the max hp, also rounds up.
     */
    @Test
    public void testRecoveryAmtBig() {
        hp = bigPot.setCurrentHp(testHero.jf.getHp());
        recoverAmt = bigPot.getRecoveryAmt(); 
        assertEquals(13, recoverAmt);
    }
    /////////////////////////////////////////////
    //Potion sub section, testing usage.
    
    /**
     *  Testing a case where there is some over heal amount.
     */
    @Test
    public void consumeOverHeal() {
        System.out.println("\nJelly Folk's max hp: " + jfmax);
        System.out.println("JellyFolk has had pain inflicted upon it, -1 hp.");
        hp = bigPot.setCurrentHp(testHero.jf.getHp());
        testHero.jf.reduceHp(1);
        int recovered = testHero.consumeHealPot(jfmax, bigPot.getRecoveryAmt());
        assertEquals(1, recovered); //Should heal exactly  1 hp
    }
    
    /**
     *  Testing a case where there is no overheal but not enough to full heal.
     */
    @Test
    public void consumeNoOverHeal() {
        System.out.println("\nJelly Folk's max hp: " + jfmax);
        System.out.println("JellyFolk has had BIG pain inflicted upon it, -8 hp.");
        hp = smalPot.setCurrentHp(testHero.jf.getHp());
        testHero.jf.reduceHp(8);
        int recovered = testHero.consumeHealPot(jfmax, smalPot.getRecoveryAmt());
        assertEquals(15, recovered);    // 20 - 8 = 12 + 3 = 15. That's the current hp.
    }
    
    
    /**
     *  Testing a case where there is nothing to heal.
     */
    @Test
    public void consumeNoHeal() {
        System.out.println("\nJelly Folk's max hp: " + jfmax);
        System.out.println("Jellyfolk has a potion and has decided to have a taste.");
        testHero.jf.reduceHp(0);
        hp = smalPot.setCurrentHp(testHero.jf.getHp());
        int recovered = testHero.consumeHealPot(jfmax, smalPot.getRecoveryAmt());
        assertEquals(0, recovered); //No hp recovered.
    }
}
