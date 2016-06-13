package fight;

import utils.RandomNameGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class Enemy {
    private String name;
    private AttackType attack;
    private int numAttacks;

    public Enemy() {
        this.name = RandomNameGenerator.generateName();
        //generate a random attack type
        this.attack = AttackType.randomAttackType();
        //generate random attack capacity between 15 and 25
        this.numAttacks = ThreadLocalRandom.current().nextInt(2,8);
    }

    public String getName() {
        return Ansi.ANSI_RED + name + Ansi.ANSI_RESET;
    }

    public AttackType getAttackType() {
        return attack;
    }

    public void blocked(int num) {
        numAttacks -= num;
    }

    public boolean canAttack() {
        return numAttacks > 0;
    }

    public String toString(){
        return attack.toString() + "\t\t" + numAttacks + "\t\t\t\t" + getName();
    }

    public String description(){
        return "Enemy : " + getName() + ", Attack type " + getAttackType() + ", number of attacks " + numAttacks;
    }

    public int getNumberOfAttacks() {
        return numAttacks;
    }
}
