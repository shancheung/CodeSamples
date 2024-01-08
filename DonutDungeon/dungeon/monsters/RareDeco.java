package main.java.donutdungeon.dungeon.monsters;

/*
 *  A type of monster to generate, weak ones are the ones that aren't bosses or mid-bosses.
 */

public class RareDeco extends MonsterDecorator {
    
    public RareDeco(Monster monster) {
        super(monster);
    }
    
    @Override
    public String monsterName() {
        setStats();
        return "~RARE Pink Valentine's Day Heart " + monster.monsterName() + "~!";
        //I wanted this donut so bad I'm CRYING
        //... no, I didn't get one if you're wondering.
    }
    
    /**
     *  I know this probably should be in MonsterDecorator, but it's super fussy and
     *  I'm barely hanging in there, I'd give anything for a nap.
     */
    @Override
    public void displayMonStats() {
        setStats();
        System.out.println("Strength: " + statsList.get(0));
        System.out.println("Defense: " + statsList.get(1));
        System.out.println("Hp: " + statsList.get(2));
        System.out.println("Dodge: " + statsList.get(3));
        System.out.println("Speed: " + statsList.get(4));
    }
    
    @Override
    public void setStats() {
        statsList.add(1);   //Strength
        statsList.add(1);   //Defense
        statsList.add(7);   //Hp   RARES HAVE BIGGER HP
        statsList.add(1);   //Dodge
        statsList.add(10);   //Speed. RARES LIKE TO GO NYOOOM
    }
}
