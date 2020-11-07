import javax.swing.*;
import java.io.File;
import java.util.Scanner;

/*
 * Created by LG
 * Date: 2020-11-04
 * Time: 17:49
 * Project: inlämningsuppgift_03
 * Copyright: MIT
 * To change this template use File | Settings | File Templates.
 */

// skapa en klass som innehåller metoder för att räkna ut hur många studenter fick VG;G;IG

public class StatisticCalculator {

    /**
     * This method counts the total number of students who got passed with distinction, passed or failed.
     *
     * The method reads the stored student data from the text-file(student results.txt) and calculates the number of students with different grades,
     * and shows the number of students who got passed with distinction, passed or failed.
     * If an error occurs when program reads the file (for example missing data), The details of the error pops up in a window dialog.
     *
     * A window dialog will pop up showing the calculated total number of students who got passed with distinction, passed or failed.
     *
     */
    public static void countNumberOfGrades() {

        // skapa 3 variabler för betyget Pass with distinction, Pass, and Fail
        int numberOfPassWithDistinction = 0;
        int numberOfPass = 0;
        int numberOfFail = 0;

        // läsa från den sparade textfilen(student results.txt), och räkna antal studenter med olika betyg
        try {
            Scanner reader = new Scanner(new File("student results.txt"));

            // I en loop läs filen tills filen är slut.
            while (reader.hasNext()) {
                // Läs och ignorera första fyra raderna om en student
                // (t.ex. en student på textfilen ser ut såhär. vi är bara intresserad av den sista raden som kan vara Pass with distinction, Pass, eller Fail.)
                // l
                //9
                //true
                //true
                //pass

                String line = reader.nextLine();
                line = reader.nextLine();
                line = reader.nextLine();
                line = reader.nextLine();

                // Läs femte raden som innehåller betyget
                line = reader.nextLine();
                System.out.println(line);

                if (line.equals("Pass with distinction")) {
                    numberOfPassWithDistinction += 1;
                }
                if (line.equals("Pass")) {
                    numberOfPass += 1;
                }
                if (line.equals("Fail")) {
                    numberOfFail += 1;
                }
            }


            // Om det inte går att läsa från filen i varje rad (i varje kommando) ovan, t.ex. om filen inte finns, kommer en exception kastas.

        } catch (Exception e) {
            System.out.println("An error has occurred when reading the file.\n" + e);
            JOptionPane.showMessageDialog(null, "An error has occurred! Check if any student has entered data yet.");
            // visa på vilken rad felet dök upp
            e.printStackTrace();
            return;
        }
        // Skriva ut antal studenter som fick Pass with distinction, Pass, eller Fail
        JOptionPane.showMessageDialog(null, "Pass with distinction: " + numberOfPassWithDistinction + "\nPass: " + numberOfPass + "\nFail: " + numberOfFail);

    }
}