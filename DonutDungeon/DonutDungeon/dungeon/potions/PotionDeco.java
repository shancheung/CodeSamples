package main.java.donutdungeon.dungeon.potions;

/*
 *  Was originally a stratedgy pattern but I changed my mind.
 *  Trying to use a decorator... I have a fever of 99.6, it's 4/23 at 7pm est.
 *  I feel unwell.
 */

public abstract class PotionDeco implements Potion {
    protected Potion potiondeco;
    protected int recoveryAmt;
    
    public PotionDeco(Potion potiondeco) {
        this.potiondeco = potiondeco;
    }
    
    public int setCurrentHp(int maxhp) {   // Amt to obtain fixed, this gets the max hp.
        return potiondeco.setCurrentHp(maxhp);
    }
    
    public int getRecoveryAmt() {
        return potiondeco.getRecoveryAmt();
    }
    
    public String potionName() {
        return potiondeco.potionName();
    }
}
