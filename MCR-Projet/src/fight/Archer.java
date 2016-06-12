package fight;

public class Archer extends Ally {
    public Archer(String name, AllyTeam team) {
        super(name, 20, AttackType.Arrow, AttackType.Magic, AttackType.Sword, AttackType.HorseCharge, team);
    }

    public static String definition() {
        return Ansi.ANSI_GREEN + "Archer\t\t" + Ansi.ANSI_RESET + "20\t" + Ansi.ANSI_GREEN +
                "arrow\t\t\t" + Ansi.ANSI_CYAN + "magic\t\t\t" + Ansi.ANSI_YELLOW + "sword\t\t\t" + Ansi.ANSI_PURPLE + "horse" + Ansi.ANSI_RESET;
    }

    public String description(){
        return Ansi.ANSI_GREEN + "Archer\t\t" + Ansi.ANSI_RESET + super.description();
    }
}