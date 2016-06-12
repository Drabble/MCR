package fight;

public class Horseman extends Ally {
    public Horseman(String name, AllyTeam team) {
        super(name, 25, AttackType.HorseCharge, AttackType.Sword, AttackType.Arrow, AttackType.Magic, team);
    }

    public static String definition() {
        return Ansi.ANSI_PURPLE + "Horseman\t" + Ansi.ANSI_RESET + "25\t" + Ansi.ANSI_PURPLE +
                "horse\t\t\t" + Ansi.ANSI_YELLOW + "sword\t\t\t" + Ansi.ANSI_GREEN + "arrow\t\t\t" + Ansi.ANSI_CYAN + "magic" + Ansi.ANSI_RESET;
    }

    public String description(){
        return Ansi.ANSI_PURPLE + "Horseman\t" + Ansi.ANSI_RESET + super.description();
    }
}