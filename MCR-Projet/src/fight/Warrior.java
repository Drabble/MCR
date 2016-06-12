package fight;

public class Warrior extends Ally {
    public Warrior(String name, AllyTeam team) {
        super(name, 30, AttackType.Sword, AttackType.HorseCharge, AttackType.Magic, AttackType.Arrow, team);
    }

    public static String definition() {
        return Ansi.ANSI_YELLOW + "Warrior\t\t" + Ansi.ANSI_RESET + "30\t" + Ansi.ANSI_YELLOW +
                "sword\t\t\t" + Ansi.ANSI_PURPLE + "horse\t\t\t" + Ansi.ANSI_CYAN + "magic\t\t\t" + Ansi.ANSI_GREEN + "arrow" + Ansi.ANSI_RESET;
    }

    public String description(){
        return Ansi.ANSI_YELLOW + "Warrior\t\t" + Ansi.ANSI_RESET + super.description();
    }
}