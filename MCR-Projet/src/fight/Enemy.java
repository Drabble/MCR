package fight;

public class Enemy {
    private String name;
    private AttackType attack;
    private int numAttacks;

    public Enemy(String name, AttackType attack, int numAttacks) {
        this.name = name;
        this.attack = attack;
        this.numAttacks = numAttacks;
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
}
