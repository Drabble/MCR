package fight;

public class Horseman extends Ally {
    public Horseman(String name) {
        super(name, 25, AttackType.Horse, AttackType.Sword, AttackType.Arrow, AttackType.Magic);
    }

    public static String definition() {
        return "Horseman - PV: 25 - strong defense: horse charge - normal defense: sword - weak defense: arrow - skip: magic";
    }

    public String description(){
        return "Horseman : " + super.description();
    }
}