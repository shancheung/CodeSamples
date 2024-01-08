package main.java.donutdungeon.dungeon.potions;

/*
 *  Was originally a stratedgy pattern but I changed my mind.
 *  First decoration, perhaps this can heal 15% of max hp.
 */

public class MedHealDecorator extends PotionDeco {
    protected int hp;

    public MedHealDecorator(Potion potiondeco) {
        super(potiondeco);
    }
    
    /**
     *  Setup for making a medium heal potion.
     */
    public String potionName() {
        return potiondeco.potionName() + ": Medium Potion";
        //setRecoveryMed(potiondeco);
    }
    
    /**
     *  Returns a heal amount 15% of the max hp.
     *  To avoid overhealing: Store max hp value and damage taken
     *  is held by another hp variable. postHp = hpDmgTaken + recoveryAmt
     *  should never be greater than max hp value. 
     *  Resolve by: if postHp >= maxHP thenn hp = maxhp. else return postHp.
     *  postHp is referring to after drinking the potion (post drink). 
     */
    @Override
     public int setCurrentHp(int maxhp) {
        hp = maxhp;
        return hp;
    }
    
    /**
     *  It isn't much but its double the weak potions, so suck it up champ.
     */
    @Override
    public int getRecoveryAmt() {
        recoveryAmt = (int)(potiondeco.setCurrentHp(hp) * 0.3);
        return potiondeco.getRecoveryAmt() + recoveryAmt;
    }
    
}
