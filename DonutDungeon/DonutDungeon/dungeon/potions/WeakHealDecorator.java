package main.java.donutdungeon.dungeon.potions;

/*
 *  Was originally a stratedgy pattern but I changed my mind.
 *  First decoration, perhaps this can heal 15% of max hp.
 */

public class WeakHealDecorator extends PotionDeco implements Potion {
    protected int hp;

    public WeakHealDecorator(Potion potiondeco) {
        super(potiondeco);
    }
    
    /**
     *  Setup for making a weak heal potion.
     */
    public String potionName() {
        return potiondeco.potionName() + ": Small Potion";
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
     *  A javadoc may not be needed here but I'm proud I fixed this in only like 3 hours,
     *  Anyway small potions only heal you a measly 15% of your max hp.
     */
    @Override
    public int getRecoveryAmt() {
        recoveryAmt = (int)(potiondeco.setCurrentHp(hp) * 0.15);
        return potiondeco.getRecoveryAmt() + recoveryAmt;
    }
}
