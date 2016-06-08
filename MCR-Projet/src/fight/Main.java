package fight;

public class Main {

    public static void main(String[] args) {
        AllyTeam allies = new AllyTeam();

        if (allies.isReady()) {
            // Create enemies
            Enemy enemy = new Enemy("Bad", AttackType.HorseCharge, 4);
            Enemy enemy2 = new Enemy("Crac", AttackType.Magic, 3);
            Enemy enemy3 = new Enemy("Boum", AttackType.Sword, 2);

            // Handle all enemies (loop ?)
            allies.handle(enemy, new Attack(enemy.getAttackType(), 15));
            allies.handle(enemy2, new Attack(enemy2.getAttackType(), 12));
            allies.handle(enemy3, new Attack(enemy3.getAttackType(), 17));
        } else {
            System.out.println("User cancelled team creation");
        }
    }
}
