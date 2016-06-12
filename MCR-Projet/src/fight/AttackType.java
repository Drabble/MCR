package fight;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public enum AttackType {
    Sword,
    Arrow,
    HorseCharge,
    Magic;


    private static final List<AttackType> ATTYPES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = ATTYPES.size();
    private static final Random RANDOM = new Random();

    /**
     * Generate a random AttackType
     * @return the AttackType randomly generated
     */
    public static AttackType randomAttackType(){
        return ATTYPES.get(RANDOM.nextInt(SIZE));

    }

}
