package main.java.donutdungeon.hero;

import java.util.ArrayList;

import main.java.donutdungeon.hero.Race;

import main.java.donutdungeon.hero.abilities.Ability;
import main.java.donutdungeon.hero.equips.EquipFactory;
import main.java.donutdungeon.hero.equips.Equips;
import main.java.donutdungeon.hero.equips.Hat;


public class Hero extends Stats implements HeroBuilder {

    public String name;     //hero name
    private int lvl = 1;    //hero level

    public Job job;         //hero class
    private JobEngineer je;
    public Archer archer;
    public Summoner summoner;
    public Hornet hornet;
    
    public Race race;       //hero race
    private RaceEngineer re;
    public Ogre ogre;
    public JellyFolk jf;
    public Android andy;
    
    private Equips[] equip = new Equips[3]; //space for hat, weapon, cape.. maybe boots later.
    public ArrayList<Ability> abilities = new ArrayList<Ability>();
    public Ability ability;

    /**
     *  Hero constructors so heroes can have their own name, job, and ability.
     */
    public Hero(String name) {
        this.name = name;
    }

    /*
     * Overrides the class for the hero being built.
     */
    @Override
    public void setJob(int jobSelection) {
        switch (jobSelection) {
            case 1:
                job = new Archer();
                archer = new Archer();
                je = new JobEngineer(archer);
                this.abilities = archer.getAbilityList(); 
                break;
            case 2:
                job = new Summoner();
                summoner = new Summoner();
                je = new JobEngineer(summoner);
                this.abilities = summoner.getAbilityList(); 
                break;
            case 3:
                job = new Hornet();
                hornet = new Hornet();
                je = new JobEngineer(hornet);
                this.abilities = hornet.getAbilityList();   //maybe do this for abilities
                break;
            default: 
                break;
        }
        je.makeJob();
    }
    
    /*
     * Overrides the class for the hero being built.
     */
    @Override
    public String getJob() {
        String jobstr = job.toString();
        if (jobstr.contains("Archer")) {
            jobstr = "Archer";
        } else if (jobstr.contains("Summoner")) {
            jobstr = "Summoner";
        } else if (jobstr.contains("Hornet")) { 
            jobstr = "Hornet";
        }
        return jobstr;
    }
    
    /**
     *  Selected abilitiy gets put through stats if its a buff/
     *  Can't really test this until later though.
     */
    public void useAbility(int i) {
        this.ability = abilities.get(i);
        skillMod(this.ability);
    }
    
    /*
     * Overrides the race for the hero being built.
     */
    @Override
    public void setRace(int raceId) {
        switch (raceId) {
            case 1:
                race = new Ogre(name);
                ogre = new Ogre(name);
                re = new RaceEngineer(ogre);
                break;
            case 2:
                race = new JellyFolk(name);
                jf = new JellyFolk(name);
                re = new RaceEngineer(jf);
                break;
            case 3:
                race = new Android(name);
                andy = new Android(name);
                re = new RaceEngineer(andy);
                break;
            default: 
                break;
        }
        re.makeRace();
    }
    
    /*
     * Retun a string version indicating the race of the hero.
     */
    @Override
    public String getRace() {
        String racestr = race.toString();
        
        if (racestr.contains("Ogre")) {
            racestr = "Ogre";
        } else if (racestr.contains("JellyFolk")) {
            racestr = "JellyFolk";
        } else if (racestr.contains("Android")) { 
            racestr = "Android";
        }
        return racestr;
    }
    
    /**
     *  Trying to add equips to the set a hero may have.
     */
    public void addEquip(Equips equipee) {
        String equipt = equipee.equipType();
        
        if (equipt.contains("Weapon")) {
            equip[0] = equipee;
        }
        if (equipt.contains("Hat")) {
            equip[1] = equipee;
        } 
        if (equipt.contains("Cape")) {
            equip[2] = equipee;
        }
    }
    
    /**
     *  Display equips.
     */
    public void getEquips() {
        System.out.println("-----Displaying Equipment------");
        if (equip[0] != null && equip[0].equipType() == "Weapon") {
            String wepSlot = equip[0].equipType();
            System.out.print("Weapon: " + wepSlot + "     " + equip[0].special() + "\n");
        } else {
            System.out.println("No weapon equipped.");
        }
        if (equip[1] != null && equip[1].equipType() == "Hat") {
            String hatSlot = equip[1].equipType();
            System.out.print("Hat: " + hatSlot + "     " + equip[1].special() + "\n");
        } else {
            System.out.println("No hat equipped.");
            
        }
        if (equip[2] != null && equip[2].equipType() == "Cape") {
            String capeSlot = equip[2].equipType();
            System.out.print("Cape: " + capeSlot + "     " + equip[2].special() + "\n");
        } else {
            System.out.println("No cape equipped.");
        }
        System.out.println("\n");
    }
    
    /*
     * Returns the name of hero.
     */
    public String getName() {
        return name;
    }
    
    /*
     * To be implemented.
     */
    public int getLevel() {
        return lvl;
    }
    
    /**
     *  Makes sure the hero consuming a potion doesn't exceed max hp;
     *  This is set up in such a way that it only considers that one entity
     *  exists within the dungeon at a time.
     */
    public int consumeHealPot(int heroHp, int potRecoveryAmt) {
        int healed = 0;
        int overheal;
        int maxHp = heroHp;
        int currentHp = getCurrHp();
        int healingNeeded = maxHp - currentHp;
        int actual;
        
        System.out.println("Max hp: " + maxHp);
        System.out.println("Current hp: " + currentHp);
        System.out.println("Healing needed: " + healingNeeded);
        System.out.println("Potion wants to recover " + potRecoveryAmt + " hp");
        
        //healed = potRecoveryAmt - healingNeeded; //Get the difference between these two
        
        if (potRecoveryAmt < healingNeeded) {
            healed = currentHp + potRecoveryAmt;
            System.out.println("Potioned healed " + potRecoveryAmt + " hp!");
            System.out.println("Current hp: " + healed);
            return healed;
        } else if (maxHp == currentHp) {
            healed = 0;
            System.out.println("No healing done, potion wasted.");
            return healed;
        } else if (potRecoveryAmt > healingNeeded && healingNeeded != 0) {
            healed = currentHp + potRecoveryAmt;
            overheal = healed - maxHp;
            healed -= overheal;
            actual = potRecoveryAmt - overheal;
            System.out.println("Overhealed amt: " + overheal
                + "\nAmount actually healed: " + actual
                + "\nCurrent hp: " + healed);
            return actual;  //give back what was actually healed
        }
        return -1;
    }
}
