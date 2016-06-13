package fight;

public class Archer extends Ally {
    public Archer(String name, AllyTeam team) {
        super(name, 20, AttackType.Arrow, AttackType.Magic, AttackType.Sword, AttackType.Horse, team);
    }

    public static String definition() {
        return "Archer\t\t" + "20\t" + AttackType.Arrow + "\t\t\t" + AttackType.Magic + "\t\t\t" + AttackType.Sword + "\t\t\t" + AttackType.Horse;
    }

    public String description(){
        return "Archer\t\t" + super.description();
    }
}