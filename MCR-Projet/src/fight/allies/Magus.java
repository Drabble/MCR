package fight.allies;

import fight.Ally;
import fight.AllyTeam;
import fight.AttackType;

/**
 * Defines an ally magus
 */
public class Magus extends Ally {

    /**
     * Constructs a new magus
     *
     * @param name
     * @param team
     */
    public Magus(String name, AllyTeam team) {
        super(name, 15, AttackType.Magic, AttackType.Arrow, AttackType.Horse, AttackType.Sword, team);
    }

    /**
     * @return the definition of a magus
     */
    public static String definition() {
        return "Magus\t\t" + "15\t" + AttackType.Magic + "\t\t" + AttackType.Arrow + "\t\t" + AttackType.Horse + "\t\t" + AttackType.Sword;
    }

    /**
     * @return the status of the magus
     */
    public String description() {
        return "Magus\t\t" + super.description();
    }
}