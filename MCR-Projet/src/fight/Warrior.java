package fight;

/**
 * Defines an ally warrior
 */
public class Warrior extends Ally {

    /**
     * Constructs a new warrior
     *
     * @param name
     * @param team
     */
    public Warrior(String name, AllyTeam team) {
        super(name, 30, AttackType.Sword, AttackType.Horse, AttackType.Magic, AttackType.Arrow, team);
    }

    /**
     * @return the definition of a warrior
     */
    public static String definition() {
        return "Warrior\t\t" + "30\t" + AttackType.Sword + "\t\t\t" + AttackType.Horse + "\t\t\t" + AttackType.Magic + "\t\t\t" + AttackType.Arrow;
    }

    /**
     * @return the status of the warrior
     */
    public String description() {
        return "Warrior\t\t" + super.description();
    }
}