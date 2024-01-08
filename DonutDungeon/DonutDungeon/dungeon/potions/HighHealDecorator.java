package main.java.donutdungeon.dungeon.potions;

/*
 *  Was originally a stratedgy pattern but I changed my mind.
 *  First decoration, perhaps this can heal 15% of max hp.
 */

public class HighHealDecorator extends PotionDeco {

    protected int hp;

    public HighHealDecorator(Potion potiondeco) {
        super(potiondeco);
    }
    
    /**
     *  Setup for making a high heal potion.
     */
    public String potionName() {
        return potiondeco.potionName() + ": BIG POTION!";
        //setPotDescript();
        //setRecoveryHigh(potiondeco);
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
    
    /*
     * I'm soOoOo generous, I made big potions heal twice as much and then some vs medium potion.
     */
    @Override
    public int getRecoveryAmt() {
        recoveryAmt = (int)(potiondeco.setCurrentHp(hp) * 0.65);
        return potiondeco.getRecoveryAmt() + recoveryAmt;
    }
}
