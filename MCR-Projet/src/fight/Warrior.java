package fight;

public class Warrior extends Ally {
    public Warrior(String name, AllyTeam team) {
        super(name, 30, AttackType.Sword, AttackType.Horse, AttackType.Magic, AttackType.Arrow, team);
    }

    public static String definition() {
        return "Warrior\t\t" + "30\t" + AttackType.Sword + "\t\t\t" + AttackType.Horse + "\t\t\t" + AttackType.Magic + "\t\t\t" + AttackType.Arrow;
    }

    public String description(){
        return "Warrior\t\t" + super.description();
    }
}