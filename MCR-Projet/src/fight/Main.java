package fight;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            do {
                for(int i = 0; i < 20; i++){
                    System.out.println("\n");
                }
                AllyTeam allies = new AllyTeam();


                if (allies.isReady()) {
                    // Create enemies
                    Enemy[] enemies = {
                            new Enemy("Bad", AttackType.Horse, 4),
                            new Enemy("Crac", AttackType.Magic, 3),
                            new Enemy("Boum", AttackType.Sword, 2)
                    };

                    // Handle enemies attacks
                    for (Enemy enemy : enemies) {
                        allies.handle(enemy, new Attack(enemy.getAttackType(), 15));
                        if(allies.hasLost()){
                            break;
                        }
                    }
                    if(allies.hasLost()){
                        System.out.println("You lost !");
                    }
                    else{
                        System.out.println("You won !");
                    }
                } else {
                    System.out.println("User cancelled team creation");
                }
                System.out.println("Would you like to start again ? [o = oui]");

            } while(System.in.read() == 'o');
        } catch (IOException e) {
            System.out.println("Error reading the input : " + e.getMessage());
        }
    }
}
