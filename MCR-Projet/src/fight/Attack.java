package fight;

/**
 * Defines an attack from an enemy to an ally
 */
public class Attack {
    private AttackType attack; // The type of the attack
    private int damages;       // The damages of the attack

    /**
     * Constructs a new attack
     *
     * @param attack
     * @param damages
     */
    public Attack(AttackType attack, int damages) {
        this.attack = attack;
        this.damages = damages;
    }

    /**
     * @return the type of the attack
     */
    public AttackType getAttackType() {
        return attack;
    }

    /**
     * @return the damages of the attack
     */
    public int getDamages() {
        return damages;
    }
}
