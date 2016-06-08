package fight;

public class Magus extends Ally {
    public Magus(String name) {
        super(name, 15, AttackType.Magic, AttackType.Arrow, AttackType.HorseCharge, AttackType.Sword);
    }

    public static String definition() {
        return "Magus - PV: 15 - strong defense: magic - normal defense: arrow - weak defense: horse charge - skip: sword";
    }

    public String description(){
        return "Magus : " + super.name();
    }
}