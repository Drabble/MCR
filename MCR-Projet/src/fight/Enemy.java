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
        this.numAttacks = ThreadLocalRandom.current().nextInt(15,26);
    }

    public String getName() {
        return name;
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

        return        "**********************************\n"
                    + "Enemy name : " + name + "\n"
                    + "Attack Type : " + attack.toString() + "\n"
                    + "Attack power : " + numAttacks + "\n"
                    + "**********************************\n";

    }


}
