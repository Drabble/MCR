package fight;

import utils.RandomNameGenerator;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Defines an enemy which will attack an AllyTeam
 */
public class Enemy {
    private String name;       // The name of the enemy
    private AttackType attack; // The type of attack
    private int numAttacks;    // The attack power which will drop if the ally can handle the attack

    /**
     * Constructs a new random enemy
     */
    public Enemy() {
        this.name = RandomNameGenerator.generateName();
        //generate a random attack type
        this.attack = AttackType.randomAttackType();
        //generate random attack capacity between 2 and 6
        this.numAttacks = ThreadLocalRandom.current().nextInt(2, 6);
    }

    /**
     * @return the name of the enemy
     */
    public String getName() {
        return Ansi.ANSI_RED + name + Ansi.ANSI_RESET;
    }

    /**
     * @return the attack type
     */
    public AttackType getAttackType() {
        return attack;
    }

    /**
     * Called when the enemy is block. Decrease the power of attack depending on the parameter
     *
     * @param num
     */
    public void blocked(int num) {
        numAttacks -= num;
    }

    /**
     * @return true if the enemy still has attack power (numAttacks)
     */
    public boolean canAttack() {
        return numAttacks > 0;
    }

    /**
     * @return the description of the enemy
     */
    public String toString() {
        return attack.toString() + "\t\t" + numAttacks + "\t\t" + getName();
    }

    /**
     * @return the attack power of the enemy
     */
    public int getNumberOfAttacks() {
        return numAttacks;
    }
}
