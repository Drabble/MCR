package fight;

import fight.allies.Archer;
import fight.allies.Horseman;
import fight.allies.Magus;
import fight.allies.Warrior;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Defines an ally team which will fight against enemies
 */
public class AllyTeam {
    private List<Ally> allies;       // The list of members of the team
    private boolean ready;           // Flag to know if the team is ready to fight
    private boolean hasLost = false; // Flag to know if the team has lost the fight

    /**
     * Construct a new ally team
     */
    public AllyTeam() {
        allies = new LinkedList();
        ready = false;

        createTeam();
    }

    /**
     * @return true if the team is ready
     */
    public boolean isReady() {
        return ready;
    }

    /**
     * Get user input for setting the chain of responsibility of the allies
     */
    private void createTeam() {
        boolean entryOk = false;
        boolean quit = false;
        boolean choiceOk = false;
        Scanner scan = new Scanner(System.in);

        // Show choices
        System.out.println("List of classes : \n");
        System.out.println("Id\tType\t\tHP\tStrong against\tNormal against\tWeak against\tSkip against");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("1\t" + Warrior.definition());
        System.out.println("2\t" + Archer.definition());
        System.out.println("3\t" + Horseman.definition());
        System.out.println("4\t" + Magus.definition());
        System.out.println("0\texit\n");

        // Complete choice (characters and order)
        while (!choiceOk) {

            // For each character
            for (int i = 0; i < 4; i++) {
                entryOk = false;

                // While entry is not ok or user doesn't want to quit
                while (!entryOk && !quit) {
                    System.out.println("Choose character " + (i + 1));
                    System.out.print("> ");

                    try {
                        String s = scan.nextLine();

                        int ch = Integer.parseInt(s);

                        // Select character (or quit)
                        switch (ch) {
                            case 1:
                                String wName = getName();
                                allies.add(new Warrior(wName, this));
                                System.out.println("Warrior \"" + wName + "\" added to pos " + (i + 1));
                                entryOk = true;
                                break;

                            case 2:
                                String aName = getName();
                                allies.add(new Archer(aName, this));
                                System.out.println("Archer \"" + aName + "\" added to pos " + (i + 1));
                                entryOk = true;
                                break;

                            case 3:
                                String hName = getName();
                                allies.add(new Horseman(hName, this));
                                System.out.println("Horseman \"" + hName + "\" added to pos " + (i + 1));
                                entryOk = true;
                                break;

                            case 4:
                                String mName = getName();
                                allies.add(new Magus(mName, this));
                                System.out.println("Magus \"" + mName + "\" added to pos " + (i + 1));
                                entryOk = true;
                                break;

                            case 0:
                                quit = true;
                                break;

                            default:
                                System.out.println("Invalid entry");
                        }
                    } catch (Exception e) {
                        System.out.println("Wrong entry type");
                    }
                }
            }

            if (!quit) {
                System.out.println("\nResume of the team : \n");
                System.out.println("No\tClass\t\tHP\tName");
                System.out.println("------------------------------------");
                for (int c = 0; c < allies.size(); c++) {
                    System.out.println((c + 1) + "\t" + allies.get(c).description());
                }

                System.out.println("\nIs this order Ok ? [o = oui]");
                String answer = scan.nextLine();

                if (answer.equals("o")) {
                    for (int c = 0; c < allies.size() - 1; c++) {
                        allies.get(c).setNext(allies.get(c + 1));
                    }

                    ready = true;
                    choiceOk = true;
                } else {
                    allies.clear();
                }
            } else {
                break;
            }
        }
    }

    /**
     * Get user input and set the name of the team
     *
     * @return the name of the team
     */
    private String getName() {
        Scanner scan = new Scanner(System.in);
        String name = "";

        while (name == "") {
            System.out.print("Enter a name: ");
            name = scan.nextLine();
        }

        return name;
    }

    /**
     * Use the chain of responsibility of the allies to handle the attack
     *
     * @param enemy
     * @param attack
     */
    public void handle(Enemy enemy, Attack attack) {
        for (int i = 0; i < 20; i++) {
            System.out.println("\n");
        }
        System.out.println(enemy.getName() + " Attacks the team");
        allies.get(0).handleAttack(enemy, attack);
    }

    /**
     * The team has lost. Set the flag hasLost to true
     */
    public void lost() {
        hasLost = true;
    }

    /**
     * @return true if the team has lost
     */
    public boolean hasLost() {
        return hasLost;
    }
}
