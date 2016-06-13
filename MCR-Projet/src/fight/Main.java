package fight;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Main class for the game chain of invicibility
 */
public class Main {

    /**
     * Start a new game of chain of invicility
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            do {
                System.out.println("************************************************");
                System.out.println("WELCOME TO THE GAME CHAIN OF INVICIBILITY");
                System.out.println("************************************************");
                System.out.println();

                List<Enemy> enemies = Arrays.asList(new Enemy(), new Enemy(), new Enemy(), new Enemy());

                System.out.println("List of enemies : \n");
                System.out.println("No\tAttack type\tAttack power\tName");
                System.out.println("-----------------------------------");
                int cnt = 1;
                for (Enemy e : enemies) {
                    System.out.println(cnt++ + "\t" + e);
                }
                System.out.println();

                AllyTeam allies = new AllyTeam();

                if (allies.isReady()) {

                    // Handle enemies attacks
                    for (Enemy enemy : enemies) {
                        allies.handle(enemy, new Attack(enemy.getAttackType(), 15));
                        if (allies.hasLost()) {
                            break;
                        }
                    }
                    if (allies.hasLost()) {
                        System.out.println("You lost !");
                    } else {
                        System.out.println("You won !");
                    }
                } else {
                    System.out.println("User cancelled team creation");
                }
                System.out.println("Would you like to start again ? [o = oui]");

            } while (System.in.read() == 'o');
        } catch (IOException e) {
            System.out.println("Error reading the input : " + e.getMessage());
        }

    }
}
