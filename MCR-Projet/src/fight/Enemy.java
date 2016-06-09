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

    public String description(){
        return "Enemy : " + getName() + ", Attack type " + getAttackType() + ", number of attacks " + numAttacks;
    }

    public int getNumberOfAttacks() {
        return numAttacks;
    }
}
