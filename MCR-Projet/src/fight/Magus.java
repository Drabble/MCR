package fight;

public class Magus extends Ally {
    public Magus(String name, AllyTeam team) {
        super(name, 15, AttackType.Magic, AttackType.Arrow, AttackType.Horse, AttackType.Sword, team);
    }

    public static String definition() {
        return "Magus\t\t" + "15\t" + AttackType.Magic + "\t\t\t" + AttackType.Arrow + "\t\t\t" + AttackType.Horse + "\t\t\t" + AttackType.Sword;
    }

    public String description(){
        return "Magus\t\t" + super.description();
    }
}