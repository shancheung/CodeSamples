package main.java.donutdungeon.dungeon.monsters;

/*
 *  A type of monster to generate, weak ones are the ones that aren't bosses or mid-bosses.
 */

public class MasterMonsterDeco extends MonsterDecorator {
    
    public MasterMonsterDeco(Monster monster) {
        super(monster);
    }
    
    @Override
    public String monsterName() {
        return "Master " + monster.monsterName();
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
            statsList.add(35);   //Strength
            statsList.add(35);   //Defense
            statsList.add(60);   //Hp
            statsList.add(28);   //Dodge
            statsList.add(35);   //Speed
        } else if (monName == "Braverian Creme") {
            statsList.add(47);   //Strength
            statsList.add(45);   //Defense
            statsList.add(80);   //Hp
            statsList.add(37);   //Dodge
            statsList.add(50);   //Speed
        } else if (monName == "Apfelkrapfen Hase") {
            statsList.add(70);   //Strength
            statsList.add(60);   //Defense
            statsList.add(120);   //Hp
            statsList.add(50);   //Dodge
            statsList.add(60);   //Speed
        }
    }
}
