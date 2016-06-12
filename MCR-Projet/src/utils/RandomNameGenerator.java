package utils;

import java.util.Random;

/**
 * Class used to randomly generate enemys names, the names used are taken from the  medieval fantasy television
 * series Game of Thrones.
 */
public class RandomNameGenerator {
    private static String[] firstName = { "Tyrion ", "Petyr ", "Jorah ", "Sandor ", "Joffrey ",
            "Viserys ", "Jeor ", "Jaqen ", "Davos ", "Ramsay ", "Daario ", "Obara ", "Hizdahr ", "Gregor ",
            "Brynden ", "Areo ", "Septa ", "Tormund ","Lancel ", "Janos " };


    private static String[] lastName = { "Septa ", "Tully", "Hotah ", "Unella", "Sand", "Martell", "Arryn",
            "Payne", "Reed", "Tyrell", "Clegane", "Bolton", "Lannister", "Mormont", "H'ghar", "Naharis" ,"Baelish","Targaryen"
            ,"Cassel", "Cleftjaw" };

    private static Random rand = new Random();

    public static String generateName() {

        return firstName[rand.nextInt(firstName.length)] +
                lastName[rand.nextInt(lastName.length)];

    }

}
