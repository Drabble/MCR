package fight;

import java.io.IOException;

/**
 * Defines an ally for the team.
 */
public abstract class Ally {
    private String name;         // Name of the ally
    private int hp;              // Number of health points of the ally
    protected AttackType strong; // Strong against
    private AttackType normal;   // Normal against
    private AttackType weak;     // Weak against
    private AttackType skip;     // Skip against
    private Ally next;           // Next ally in the chain of responsibility
    private boolean isDead;      // If the ally is dead
    private AllyTeam team;       // Team of the ally

    /**
     * Constructs a new ally
     *
     * @param name
     * @param hp
     * @param strong
     * @param normal
     * @param weak
     * @param skip
     * @param team
     */
    public Ally(String name, int hp, AttackType strong, AttackType normal, AttackType weak, AttackType skip, AllyTeam team) {
        this.name = name;
        this.hp = hp;
        this.strong = strong;
        this.normal = normal;
        this.weak = weak;
        this.skip = skip;
        this.team = team;

        this.next = null;
        this.isDead = false;
    }

    /**
     * Set the ally which will be the next to handle an attack in the chain of responsibility
     *
     * @param next
     */
    public void setNext(Ally next) {
        this.next = next;
    }

    /**
     * Handle an attack from an enemy
     *
     * @param enemy
     * @param attack
     */
    public void handleAttack(Enemy enemy, Attack attack) {
        String handleType = "";
        int actualDamages = 0;

        System.out.println(name() + " handle attack from " + enemy.getName());

        // If ally dead or cannot handle attack
        if (isDead || attack.getAttackType() == skip) {
            if (next != null) {
                // Give handle to next ally
                System.out.println(name() + " cannot handle attack. Next one!");
                printStatus(enemy);
                next.handleAttack(enemy, attack);
            } else {
                // No next ally (end of the chain)
                System.out.println("The enemy accessed to your treasure. You lost!");
                team.lost();
                printStatus(enemy);
            }
            return;
        } else {
            // Better defense (take 1/4 of the damages)
            if (attack.getAttackType() == strong) {
                enemy.blocked(3);
                actualDamages = attack.getDamages() / 4;
                losePV(actualDamages);
                handleType = "strong";
                // Standard defense (take 1/2 of the damages)
            } else if (attack.getAttackType() == normal) {
                enemy.blocked(2);
                actualDamages = attack.getDamages() / 2;
                losePV(actualDamages);
                handleType = "normal";
                // Weak defense (take whole damage)
            } else {
                if (attack.getAttackType() == weak) {
                    enemy.blocked(1);
                    actualDamages = attack.getDamages();
                    losePV(actualDamages);
                    handleType = "weak";
                } else {
                    //TODO Throw exception: wrong attack type
                    System.out.println("Wrong attack type");
                    return;
                }
            }

            // Show attack information
            System.out.println(name() + " held a " + handleType + " attack off and lost " + actualDamages
                    + " hp. [remaining : " + hp + "]");

            // Check if ally is dead
            if (hp == 0) {
                isDead = true;
                System.out.println(name() + " is dead !");
                printStatus(enemy);
            }

            // Check if enemy can still attack
            if (enemy.canAttack()) {

                // If it can, check the next ally able to handle the attack
                if (next != null) {
                    printStatus(enemy);
                    next.handleAttack(enemy, attack);
                } else {
                    System.out.println("Enemy " + enemy.getName() + " accessed to your treasure. You lost!");
                    team.lost();
                }
            } else {
                System.out.println(enemy.getName() + " has been killed !");
                printStatus(enemy);
            }
        }
    }

    /**
     * Print the status of the current ally and the next allies in the chain of responsibility
     * Also print the status of the enemy
     *
     * @param enemy
     */
    public void printStatus(Enemy enemy) {
        System.out.println("\nStatus : \n");
        System.out.println("HP\tStrong against\tNormal against\tWeak against\tSkip against\tName");
        System.out.println("---------------------------------------------------------------------------------");

        printAllies();

        System.out.println("\nAttack type\tNumber of attacks\tName");
        System.out.println("----------------------------------------");
        System.out.println(enemy.getAttackType() + "\t\t" + enemy.getNumberOfAttacks() + "\t\t\t\t\t" + enemy.getName());
        System.out.println();
        System.out.println("Click enter to continue !");
        try {
            while (System.in.read() != '\n') ;
        } catch (IOException e) {
            System.err.println("Error reading input : " + e.getMessage());
        }
        for (int i = 0; i < 20; i++) {
            System.out.println("\n");
        }
    }

    /**
     * Print the status of the allies
     */
    public void printAllies() {
        System.out.println(getHp() + "\t" + getStrong() + "\t\t\t" + getNormal() + "\t\t\t" + getWeak() + "\t\t\t" + getSkip() + "\t\t\t" + name());
        if (next != null) {
            next.printAllies();
        }
    }

    /**
     * Substract PV to current ally, but not under zero
     *
     * @param pv the number of PV to remove
     */
    private void losePV(int pv) {
        if (this.hp - pv > 0) {
            this.hp -= pv;
        } else {
            this.hp = 0;
        }
    }

    /**
     * @return the number of HP of the player
     */
    public int getHp() {
        return hp;
    }

    /**
     * @return the attacktype against which the ally has normal defense
     */
    public AttackType getNormal() {
        return normal;
    }

    /**
     * @return the attacktype against which the ally has weak defense
     */
    public AttackType getWeak() {
        return weak;
    }

    /**
     * @return the attacktype against which the ally can't handle
     */
    public AttackType getSkip() {
        return skip;
    }

    /**
     * @return the attacktype against which the ally has strong defense
     */
    public AttackType getStrong() {
        return strong;
    }

    /**
     * @return the name of the ally
     */
    public String name() {
        return Ansi.ANSI_GREEN + name + Ansi.ANSI_RESET;
    }

    /**
     * @return the description of the ally
     */
    public String description() {
        return hp + "\t" + name() + "\t";
    }
}