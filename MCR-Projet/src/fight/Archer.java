package fight;

public class Archer extends Ally {
    public Archer(String name) {
        super(name, 20, AttackType.Arrow, AttackType.Magic, AttackType.Sword, AttackType.Horse);
    }

    public static String definition() {
        return "Archer - PV: 20 - strong defense: arrow - normal defense: magic - weak defense: sword - skip: horse charge";
    }

    public String description(){
        return "Archer : " + super.description();
    }
}