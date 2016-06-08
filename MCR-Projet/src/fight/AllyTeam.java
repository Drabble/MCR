package fight;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AllyTeam {
    private List<Ally> allies;
    private boolean ready;

    public AllyTeam() {
        allies = new LinkedList();
        ready = false;

        createTeam();
    }

    public boolean isReady() {
        return ready;
    }

    private void createTeam() {
        boolean entryOk = false;
        boolean quit = false;
        boolean choiceOk = false;
        Scanner scan = new Scanner(System.in);

        // Show choices
        System.out.println("1: " + Warrior.definition());
        System.out.println("2: " + Archer.definition());
        System.out.println("3: " + Horseman.definition());
        System.out.println("4: " + Magus.definition());
        System.out.println("0: Quit");

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
                                allies.add(new Warrior(wName));
                                System.out.println("Warrior \"" + wName + "\" added to pos " + (i + 1));
                                entryOk = true;
                                break;

                            case 2:
                                String aName = getName();
                                allies.add(new Archer(aName));
                                System.out.println("Archer \"" + aName + "\" added to pos " + (i + 1));
                                entryOk = true;
                                break;

                            case 3:
                                String hName = getName();
                                allies.add(new Horseman(hName));
                                System.out.println("Horseman \"" + hName + "\" added to pos " + (i + 1));
                                entryOk = true;
                                break;

                            case 4:
                                String mName = getName();
                                allies.add(new Magus(mName));
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
                for (int c = 0; c < allies.size(); c++) {
                    System.out.println(" - " + allies.get(c).description());
                }

                System.out.println("Is this order Ok ? [o = oui]");
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

    private String getName() {
        Scanner scan = new Scanner(System.in);
        String name = "";

        while (name == "") {
            System.out.print("Enter a name: ");
            name = scan.nextLine();
        }

        return name;
    }

    public void handle(Enemy enemy, Attack attack) {
        System.out.println(enemy.getName() + " Attacks the team");
        allies.get(0).handleAttack(enemy, attack);
    }
}
