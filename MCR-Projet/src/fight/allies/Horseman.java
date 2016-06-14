package fight.allies;

import fight.Ally;
import fight.AllyTeam;
import fight.AttackType;

/**
 * Defines an ally horseman
 */
public class Horseman extends Ally {

    /**
     * Constructs a new horseman
     *
     * @param name
     * @param team
     */
    public Horseman(String name, AllyTeam team) {
        super(name, 25, AttackType.Horse, AttackType.Sword, AttackType.Arrow, AttackType.Magic, team);
    }

    /**
     * @return the definition of a horseman
     */
    public static String definition() {
        return "Horseman\t" + "25\t" + AttackType.Horse + "\t\t" + AttackType.Sword + "\t\t" + AttackType.Arrow + "\t\t" + AttackType.Magic;
    }

    /**
     * @return the status of the horseman
     */
    public String description() {
        return "Horseman\t" + super.description();
    }
}