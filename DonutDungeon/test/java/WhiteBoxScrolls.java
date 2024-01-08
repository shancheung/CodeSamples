package test.java;

import main.java.donutdungeon.dungeon.scrolls.BlessedScroll;
import main.java.donutdungeon.dungeon.scrolls.ConcreteScroll;
import main.java.donutdungeon.dungeon.scrolls.CursedScroll;
import main.java.donutdungeon.dungeon.scrolls.ImprisionedScroll;
import main.java.donutdungeon.dungeon.scrolls.InspiredScroll;
import main.java.donutdungeon.dungeon.scrolls.Scroll;
import main.java.donutdungeon.dungeon.scrolls.ScrollDecorator;
import main.java.donutdungeon.dungeon.scrolls.ScrollFactory;

import main.java.donutdungeon.hero.Android;
import main.java.donutdungeon.hero.Hero;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WhiteBoxScrolls {
    final ScrollFactory scrollTestFacto = new ScrollFactory();

    //Scrolls
    Scroll scroll;
    Scroll scroll2;
    Scroll scroll3;
    Scroll scroll4;
    Scroll scroll5;
    
    //Values that store and may be subject to change.
    int change;         //Holds the change value within tests.
    int dodgeVal;   //Contains the hero's dodge value.
    String scrollName;      //Where I'll put the scroll name
    String expectedName;    //Will store expected name in tests.
    String descript;
    
    //Test subject hero
    Hero testHero;
    Android andy;   //We'll use an android this time. :)
    
    /**
     *  Setup before doing tests, just make these scrolls into something unique.
     */
    @Before
    public void setUp() throws Exception {
        //Make these scrolls into something unique via factory
        scroll = scrollTestFacto.generateScroll("Cripple");
        scroll2 = scrollTestFacto.generateScroll("Blessed");
        scroll3 = scrollTestFacto.generateScroll("Cursed");
        scroll4 = scrollTestFacto.generateScroll("Imprisioned");
        scroll5 = scrollTestFacto.generateScroll("inspired");
        
        //Setup the hero, doesn't need a job.
        testHero = new Hero("Jenny");
        testHero.setRace(3);
        andy = testHero.andy;
        dodgeVal = testHero.andy.getDodge();    //8
    }
    
    ///////////////////////////////////////////////////////////////////////////
    //Cripple scroll testing
    
    /**
     *  Just making sure the scrolls have the appropriate names.
     */
    @Test
    public void crippleTestName() {
        scrollName = scroll.scrollName();
        expectedName = "scroll of nyomor (cripple)";
        assertTrue(expectedName.equalsIgnoreCase(scrollName));
    }
    
    /**
     *  Cripple scroll reduces dodge by 50%, if the initial dodge is 8, then expected is 4.
     */
    @Test
    public void crippleFuncTest() {
        scroll.setStatChange(dodgeVal);
        change = scroll.getStatChange();
        assertEquals(4,change);
    }
    
    /**
     *  Check out the description, just make sure its a string.
     */
    @Test
    public void crippleDescTest() {
        descript = scroll.scrollDescription();
        assertTrue(descript instanceof String);
    }
    
    ///////////////////////////////////////////////////////////////////////////
    //Blessed scroll testing
    
    /**
     *  Just making sure the scrolls have the appropriate names.
     */
    @Test
    public void blessTestName() {
        scrollName = scroll2.scrollName();
        expectedName = "scroll of dla'ja (blessed)";
        assertTrue(expectedName.equalsIgnoreCase(scrollName));
    }
    
    /**
     *  Blessed scroll gives a 7 fold boost, 8 * 7 = 56.
     */
    @Test
    public void blessFuncTest() {
        scroll2.setStatChange(dodgeVal);
        change = scroll2.getStatChange();
        assertEquals(56,change);
    }
    
    /**
     *  Check out the description, just make sure its a string.
     */
    @Test
    public void blessDescTest() {
        descript = scroll2.scrollDescription();
        assertTrue(descript instanceof String);
    }
    
    ///////////////////////////////////////////////////////////////////////////
    //Cursed scroll testing
    
    /**
     *  Just making sure the scrolls have the appropriate names.
     */
    @Test
    public void curseTestName() {
        scrollName = scroll3.scrollName();
        expectedName = "scroll of atko (cursed)";
        assertTrue(expectedName.equalsIgnoreCase(scrollName));
    }
    
    /**
     *  Cursed scroll is a 75% reduction, so 8 * .25 = 2.
     */
    @Test
    public void curseFuncTest() {
        scroll3.setStatChange(dodgeVal);
        change = scroll3.getStatChange();
        assertEquals(2,change);
    }
    
    /**
     *  Check out the description, just make sure its a string.
     */
    @Test
    public void curseDescTest() {
        descript = scroll3.scrollDescription();
        assertTrue(descript instanceof String);
    }
    
    ///////////////////////////////////////////////////////////////////////////
    //Imprisioned scroll testing
    
    /**
     *  Just making sure the scrolls have the appropriate names.
     */
    @Test
    public void imprisionedTestName() {
        scrollName = scroll4.scrollName();
        expectedName = "scroll of beborzoni (imprisioned)";
        assertTrue(expectedName.equalsIgnoreCase(scrollName));
    }
    
    /**
     *  Imprisioned scroll sets a stat to 0.
     */
    @Test
    public void imprisionedFuncTest() {
        scroll4.setStatChange(dodgeVal);
        change = scroll4.getStatChange();
        assertEquals(0,change);
    }
    
    /**
     *  Check out the description, just make sure its a string.
     */
    @Test
    public void imprisionedDescTest() {
        descript = scroll4.scrollDescription();
        assertTrue(descript instanceof String);
    }
    
    /**
     *  End Imprisioned state test.
     */
    @Test
    public void imprisionedEndState() {
        scroll4.endState();
    }
    
    ///////////////////////////////////////////////////////////////////////////
    //Inspired scroll testing
    
    /**
     *  Just making sure the scrolls have the appropriate names.
     */
    @Test
    public void inspiredTestName() {
        scrollName = scroll5.scrollName();
        expectedName = "scroll of etett (inspire)";
        assertTrue(expectedName.equalsIgnoreCase(scrollName));
    }
    
    /**
     *  Inspired scroll grants a stat a 1.5x boost to a stat.
     */
    @Test
    public void inspiredFuncTest() {
        scroll5.setStatChange(dodgeVal);
        change = scroll5.getStatChange();
        assertEquals(12,change);
    }
    
    /**
     *  Check out the description, just make sure its a string.
     */
    @Test
    public void inspiredDescTest() {
        descript = scroll5.scrollDescription();
        assertTrue(descript instanceof String);
    }
    
    /**
     *  End Inspired state test.
     */
    @Test
    public void inspiredEndState() {
        scroll5.endState();
    }
}
