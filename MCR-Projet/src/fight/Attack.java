package fight;

public class Attack {
    private AttackType attack;
    private int damages;

    public Attack(AttackType attack, int damages) {
        this.attack = attack;
        this.damages = damages;
    }

    public AttackType getAttackType() {
        return attack;
    }

    public int getDamages() {
        return damages;
    }
}
