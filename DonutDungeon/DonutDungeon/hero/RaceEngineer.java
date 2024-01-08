package main.java.donutdungeon.hero;

public class RaceEngineer { 

    private Race race;
    
    public RaceEngineer(Race race) {
        this.race = race;
    }
    
    public void getRace() {
        this.race.getDescription();
        //this.race.getStats();
    }
    
    public void makeRace() {
        this.race.setStats();
        this.race.setDescription();
    }
}
