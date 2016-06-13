package fight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;


public class Main {

    public static void main(String[] args) {

        /*
           Scénario actuel:
            - enemy attaque
            - a1 skippe l'attaque
            - a2 effectue un bon blocage, subit un quart des dégats mais meurt tout de même (retire 3 points d'attaque à enemy)
            - a3 effectue un blocage normal, subit la moitié des dégats et retire les deux points d'attaque restants à enemy
            => trésor sauvé

            Note: changer le nombre d'attaques de l'ennemi de 5 à 6 le fait accéder au trésor
        */


        try {
            do {
                System.out.println("************************************************");
                System.out.println("WELCOME TO THE GAME CHAIN OF INVICIBILITY");
                System.out.println("************************************************");
                System.out.println();

                List<Enemy> enemies = Arrays.asList(new Enemy(),new Enemy(),new Enemy(),new Enemy());

                System.out.println("List of enemies : \n");
                System.out.println("No\tAttack type\tAttack power\tName");
                System.out.println("-----------------------------------");
                int cnt = 1;
                for(Enemy e : enemies){
                    System.out.println(cnt++ + "\t" + e);
                }
                System.out.println();

                AllyTeam allies = new AllyTeam();

                if (allies.isReady()) {

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
