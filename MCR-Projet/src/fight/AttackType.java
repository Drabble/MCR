package fight;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public enum AttackType {
    Sword,
    Arrow,
    Horse,
    Magic;


    private static final List<AttackType> ATTYPES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = ATTYPES.size();
    private static final Random RANDOM = new Random();

    /**
     * Generate a random AttackType
     *
     * @return the AttackType randomly generated
     */
    public static AttackType randomAttackType() {
        return ATTYPES.get(RANDOM.nextInt(SIZE));
    }

    @Override
    public String toString() {
        switch (this) {
            case Sword:
                return Ansi.ANSI_YELLOW + super.toString() + Ansi.ANSI_RESET;
            case Arrow:
                return Ansi.ANSI_GREEN + super.toString() + Ansi.ANSI_RESET;
            case Horse:
                return Ansi.ANSI_PURPLE + super.toString() + Ansi.ANSI_RESET;
            case Magic:
                return Ansi.ANSI_CYAN + super.toString() + Ansi.ANSI_RESET;
        }
        return null;
    }

}
