package fight;

public class Warrior extends Ally {
    public Warrior(String name) {
        super(name, 30, AttackType.Sword, AttackType.Horse, AttackType.Magic, AttackType.Arrow);
    }

    public static String definition() {
        return "Warrior - PV: 30 - strong defense: sword - normal defense: horse charge - weak defense: magic - skip: arrow";
    }

    public String description(){
        return "Warrior : " + super.description();
    }
}