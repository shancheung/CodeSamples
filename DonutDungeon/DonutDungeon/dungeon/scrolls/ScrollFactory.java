package main.java.donutdungeon.dungeon.scrolls;

/**
 *  Here's the factory part I'm so in love with.
 */
 
public class ScrollFactory {
    //private Random rand = new Random();   //It didn't work out :(
    Scroll scroll;
    
    /**
     *  The factory pattern and I are actually bffs, so I'm always happy to use it,
     *  since it makes i t just so much easier to spawn things.
     */
    public Scroll generateScroll(String scrollType) {
        if (scrollType == null) {
            return null;    //As always, this should probably never even happen.
        //} else if (scrollType.equalsIgnoreCase("RANDOM")) { //use random generate scroll.
            //scroll = randomScroll();  
        } else if (scrollType.equalsIgnoreCase("CRIPPLE")) {    
            scroll = new CrippleScroll(new ConcreteScroll());
            return scroll;
        } else if (scrollType.equalsIgnoreCase("IMPRISIONED")) {
            scroll = new ImprisionedScroll(new ConcreteScroll());
            return scroll;
        } else if (scrollType.equalsIgnoreCase("CURSED")) {
            scroll = new CursedScroll(new ConcreteScroll());
            return scroll;
        } else if (scrollType.equalsIgnoreCase("INSPIRED")) {
            scroll = new InspiredScroll(new ConcreteScroll());
            return scroll;
        } else if (scrollType.equalsIgnoreCase("BLESSED")) {    //Permitted spawning the super rare
            scroll = new BlessedScroll(new ConcreteScroll());   //mostly for testing purposes.
            return scroll;
        }
        return null;
    }
    
    /**
     *  This is mostly for picking what goes into the shop since mosnters won't drop scrolls
     *  (they don't have hands or pockets, so why on earth would they
     *
     *  This is apparently busted.. oh no
     */
     
    /*public Scroll randomScroll() {
        int randDet = rand.nextInt(100) + 1;
        if (randDet > 6) { //If random determinant is 5 or less, spawn blessed scroll.
            this.scroll = generateScroll("BLESSED");
            return scroll;
        } 
        if (6 < randDet && randDet > 21) {//that's like 15% right? For the imprisioned.
            this.scroll = generateScroll("IMPRISONED");
            return scroll;
        } 
        if (21 < randDet && randDet > 41) {
            scroll = generateScroll("CURSED");       //20% FOR CURSED SCROLL LOL
            return scroll;
        } 
        if (41 < randDet && randDet > 71) {
            scroll = generateScroll("CRIPPLE");      //30% to be just like ME!
            return scroll;
        } else {
            scroll = generateScroll("INSPIRED");     //30% TO GET INSPIRED ... if only, right?
            return scroll;
        } 
    }
    */
    /**
     *  I'm tired but willing to try doing this again.
     *//*
    public void randoScroll2() {
        int randDet = rand.nextInt(5) + 1;
        
        if (randDet == 1) {
            generateScroll("BLESSED");
        }
        if (randDet == 2) {
            generateScroll("CURSED");
        }
        if (randDet == 3) {
            generateScroll("CRIPPLED");
        }
        if (randDet == 4) {
            generateScroll("INSPIRED");
        }
        if (randDet == 5) {
            generateScroll("IMPRISIONED");
        }
        
    }*/
}
