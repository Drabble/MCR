package fight.allies;

import fight.Ally;
import fight.AllyTeam;
import fight.AttackType;

/**
 * Defines an ally archer
 */
public class Archer extends Ally {

    /**
     * Construct a new archer
     *
     * @param name
     * @param team
     */
    public Archer(String name, AllyTeam team) {
        super(name, 20, AttackType.Arrow, AttackType.Magic, AttackType.Sword, AttackType.Horse, team);
    }

    /**
     * @return Return the definition of an archer
     */
    public static String definition() {
        return "Archer\t\t" + "20\t" + AttackType.Arrow + "\t\t" + AttackType.Magic + "\t\t" + AttackType.Sword + "\t\t" + AttackType.Horse;
    }

    /**
     * @return Return the current status of the archer
     */
    public String description() {
        return "Archer\t\t" + super.description();
    }
}