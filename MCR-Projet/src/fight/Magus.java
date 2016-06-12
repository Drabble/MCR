package fight;

import com.sun.org.apache.xerces.internal.impl.dv.xs.AnySimpleDV;

public class Magus extends Ally {
    public Magus(String name, AllyTeam team) {
        super(name, 15, AttackType.Magic, AttackType.Arrow, AttackType.HorseCharge, AttackType.Sword, team);
    }

    public static String definition() {
        return Ansi.ANSI_CYAN + "Magus\t\t" + Ansi.ANSI_RESET + "15\t" + Ansi.ANSI_CYAN +
                "magic\t\t\t" + Ansi.ANSI_GREEN + "arrow\t\t\t" + Ansi.ANSI_PURPLE + "horse\t\t\t" + Ansi.ANSI_YELLOW + "sword" + Ansi.ANSI_RESET;
    }

    public String description(){
        return Ansi.ANSI_CYAN + "Magus\t\t" + Ansi.ANSI_RESET + super.description();
    }
}