package main.java.donutdungeon.dungeon.monsters;

/*
 *  A type of monster to generate, weak ones are the ones that aren't bosses or mid-bosses.
 */

public class StandardMonsterDeco extends MonsterDecorator {
    
    public StandardMonsterDeco(Monster monster) {
        super(monster);
    }
    
    @Override
    public String monsterName() {
        return "Normal " + monster.monsterName();
    }
    
    @Override
    public void displayMonStats() {
        setStats();
        System.out.println("Strength: " + statsList.get(0));
        System.out.println("Defense: " + statsList.get(1));
        System.out.println("Hp: " + statsList.get(2));
        System.out.println("Dodge: " + statsList.get(3));
        System.out.println("Speed: " + statsList.get(4));
    }
    
    /**
     *  MOVED FROM WEAKMONSTER. CAN'T OVERRIDE THIS AA
     *  My awful setup for Stats.java has come to bite my butt again, we're not using it anymore
     *  I am ashamed and embarrassed.
     *  Anyway, this also checks to see who this is being applied to (weak, mid, boss)
     *  Intended for the very base game.
     */
    @Override
    public void setStats() {
        String monName = monster.monsterName(); //This setup should allow me to do this for others
        if (monName == "Donut") {
            statsList.add(1);   //Strength
            statsList.add(1);   //Defense
            statsList.add(3);   //Hp
            statsList.add(1);   //Dodge
            statsList.add(5);   //Speed
        } else if (monName == "Braverian Creme") {
            statsList.add(4);   //Strength
            statsList.add(2);   //Defense
            statsList.add(13);   //Hp
            statsList.add(3);   //Dodge
            statsList.add(5);   //Speed
        } else if (monName == "Apfelkrapfen Hase") {
            statsList.add(5);   //Strength
            statsList.add(4);   //Defense
            statsList.add(17);   //Hp
            statsList.add(5);   //Dodge
            statsList.add(8);   //Speed
        }
    }
}
