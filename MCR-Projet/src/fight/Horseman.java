package fight;

public class Horseman extends Ally {
    public Horseman(String name, AllyTeam team) {
        super(name, 25, AttackType.Horse, AttackType.Sword, AttackType.Arrow, AttackType.Magic, team);
    }

    public static String definition() {
        return "Horseman\t" + "25\t" + AttackType.Horse + "\t\t\t" + AttackType.Sword + "\t\t\t" + AttackType.Arrow + "\t\t\t" +AttackType.Magic;
    }

    public String description(){
        return "Horseman\t" + super.description();
    }
}