package main.java.donutdungeon.dungeon.monsters;

/*
 *  The factory portion of trying to use two patterns at once.
 */
 
import java.util.Random; //Sometimes the spawned monster will be rare ;3c

public class MonsterFactory {
    private Random rand = new Random();
    
    /**
     *  So we're going to take only kind of monster to generate, and then randomly
     *  create one at first.
     *  Then later, they'll have modifiers to be decorated with at random based off of
     *  the floor.
     */
    public Monster generateMonster(String monsterType) {    //Update to include level later?
        int randDet = rand.nextInt(10) + 1;    // 1 in 10 chance.
        Monster monster1;
        if (monsterType == null) {
            return null;    //invalid input. This should never be triggered.
        } else if (monsterType.equalsIgnoreCase("WEAK")) {
            if (randDet == 4) { //THIS DOES WORK I'VE SEEN IT
                System.out.println("BOOP BOOP RARE SPAWN!! BOOOOOP");
                monster1 = new RareDeco(new WeakMonster());
            } else {
                monster1 = new StandardMonsterDeco(new WeakMonster());
            }
            return monster1;
        } else if (monsterType.equalsIgnoreCase("MID")) {
            monster1 = new StandardMonsterDeco(new MidMonster());
            return monster1;
        } else if (monsterType.equalsIgnoreCase("BOSS")) {
            monster1 = new StandardMonsterDeco(new BossMonster());
            return monster1;
        }
        return null;
    }
    
    /**
     *  Generates adept monsters.
     */
    public Monster generateAdeptMonster(String monsterType) {    //Update to include level later?
        Monster monster1;
        if (monsterType == null) {
            return null;    //invalid input. This should never be triggered.
        } else if (monsterType.equalsIgnoreCase("WEAK")) {
            monster1 = new AdeptMonsterDeco(new WeakMonster());
            return monster1;
        } else if (monsterType.equalsIgnoreCase("MID")) {
            monster1 = new AdeptMonsterDeco(new MidMonster());
            return monster1;
        } else if (monsterType.equalsIgnoreCase("BOSS")) {
            monster1 = new AdeptMonsterDeco(new BossMonster());
            return monster1;
        }
        return null;
    }
    
    /**
     *  Generates elite monsters.
     */
    public Monster generateEliteMonster(String monsterType) {    //Update to include level later?
        Monster monster1;
        if (monsterType == null) {
            return null;    //invalid input. This should never be triggered.
        } else if (monsterType.equalsIgnoreCase("WEAK")) {
            monster1 = new EliteMonsterDeco(new WeakMonster());
            return monster1;
        } else if (monsterType.equalsIgnoreCase("MID")) {
            monster1 = new EliteMonsterDeco(new MidMonster());
            return monster1;
        } else if (monsterType.equalsIgnoreCase("BOSS")) {
            monster1 = new EliteMonsterDeco(new BossMonster());
            return monster1;
        }
        return null;
    }
    
    /**
     *  Generates master monsters.
     */
    public Monster generateMasterMonster(String monsterType) {    //Update to include level later?
        Monster monster1;
        if (monsterType == null) {
            return null;    //invalid input. This should never be triggered.
        } else if (monsterType.equalsIgnoreCase("WEAK")) {
            monster1 = new MasterMonsterDeco(new WeakMonster());
            return monster1;
        } else if (monsterType.equalsIgnoreCase("MID")) {
            monster1 = new MasterMonsterDeco(new MidMonster());
            return monster1;
        } else if (monsterType.equalsIgnoreCase("BOSS")) {
            monster1 = new MasterMonsterDeco(new BossMonster());
            return monster1;
        }
        return null;
    }
}
