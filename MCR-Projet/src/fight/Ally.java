package fight;

import java.io.IOException;

public abstract class Ally {
    private String name;
    private int pv;
    protected AttackType strong;
    private AttackType normal;
    private AttackType weak;
    private AttackType skip;
    private Ally next;
    private boolean isDead;
    private AllyTeam team;

    public Ally(String name, int pv, AttackType strong, AttackType normal, AttackType weak, AttackType skip, Ally next) {
        this.name = name;
        this.pv = pv;
        this.strong = strong;
        this.normal = normal;
        this.weak = weak;
        this.skip = skip;
        this.next = next;

        this.isDead = false;
    }

    public Ally(String name, int pv, AttackType strong, AttackType normal, AttackType weak, AttackType skip, AllyTeam team) {
        this.name = name;
        this.pv = pv;
        this.strong = strong;
        this.normal = normal;
        this.weak = weak;
        this.skip = skip;
        this.team = team;

        this.next = null;
        this.isDead = false;
    }

    public void setNext(Ally next){
        this.next = next;
    }

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
            } else if (attack.getAttackType() == weak) {
                enemy.blocked(1);
                actualDamages = attack.getDamages();
                losePV(actualDamages);
                handleType = "weak";
            } else {
                //TODO Throw exception: wrong attack type
                System.out.println("Wrong attack type");
                return;
            }

            // Show attack information
            System.out.println(name() + " held a " + handleType + " attack off and lost " + actualDamages
                    + " pv. [remaining : " + pv + "]");

            // Check if ally is dead
            if (pv == 0) {
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

    public void printStatus(Enemy enemy){
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
            while(System.in.read() != '\n');
        } catch (IOException e) {
            System.err.println("Error reading input : " + e.getMessage());
        }
        for(int i = 0; i < 20; i++){
            System.out.println("\n");
        }
    }

    public void printAllies(){
        System.out.println(getPv() + "\t" + getStrong() + "\t\t\t" + getNormal() + "\t\t\t" + getWeak() + "\t\t\t" + getSkip() + "\t\t\t" + name());
        if(next != null){
            next.printAllies();
        }
    }

    /**
     * Substract PV to current ally, but not under zero
     *
     * @param pv the number of PV to remove
     */
    private void losePV(int pv) {
        if (this.pv - pv > 0) {
            this.pv -= pv;
        } else {
            this.pv = 0;
        }
    }

    public int getPv() {
        return pv;
    }

    public AttackType getNormal() {
        return normal;
    }

    public AttackType getWeak() {
        return weak;
    }

    public AttackType getSkip() {
        return skip;
    }

    public AttackType getStrong(){
        return strong;
    }

    public boolean isDead() {
        return isDead;
    }

    public String name(){
        return Ansi.ANSI_GREEN + name + Ansi.ANSI_RESET;
    }

    public String description(){
        return pv + "\t" + name() + "\t";
    }
}