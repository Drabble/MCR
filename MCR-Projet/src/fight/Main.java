package fight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("************************************************");
        System.out.println("Bienvenue dans le jeu Chain of Invicibility");
        System.out.println("************************************************");
        System.out.println();

        System.out.println("*************************************************");
        System.out.println("Voici les ennemis que vous allez devoir affronter");
        System.out.println("*************************************************");
        System.out.println();

        List<Enemy> enemies = Arrays.asList(new Enemy(),new Enemy(),new Enemy(),new Enemy());

        for(Enemy e : enemies)
            System.out.println(e);


        /*
           Scénario actuel:
            - enemy attaque
            - a1 skippe l'attaque
            - a2 effectue un bon blocage, subit un quart des dégats mais meurt tout de même (retire 3 points d'attaque à enemy)
            - a3 effectue un blocage normal, subit la moitié des dégats et retire les deux points d'attaque restants à enemy
            => trésor sauvé

            Note: changer le nombre d'attaques de l'ennemi de 5 à 6 le fait accéder au trésor



        Ally a3 = new Ally("Three", 20, AttackType.Arrow, AttackType.HorseCharge, AttackType.Magic, AttackType.Sword, null);
        Ally a2 = new Ally("Two", 10, AttackType.HorseCharge, AttackType.Magic, AttackType.Sword, AttackType.Arrow, a3);
        Ally a1 = new Ally("One", 20, AttackType.Magic, AttackType.Sword, AttackType.Arrow, AttackType.HorseCharge, a2);

        Enemy enemy = new Enemy("Bad", AttackType.HorseCharge, 5);

        a1.handleAttack(enemy, new Attack(enemy.getAttackType(), 20));
        */
    }
}
