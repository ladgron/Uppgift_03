import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

/*
 * Created by LG
 * Date: 2020-11-01
 * Time: 17:36
 * Project: inlämningsuppgift_03
 * Copyright: MIT
 * To change this template use File | Settings | File Templates.
 */

public class Student {

    // skapa instansvariabler i klassen Student - declare properties in class Student

    String studentId;
    int numberOfAttendedClasses = 0;
    boolean testResult;
    boolean passedGroupProject;
    String finalGrade;

    /**
     * This method calculates the grade for student based on these 3 properties: numberOfAttendedClasses, testResult and passedGroupProject.
     * The result is put in the property finalGrade of the student object.
     * <p>
     * To get Pass with distinction, student must have 12 numberOfAttendedClasses + passed testResult and passedGroupProject.
     * To get Pass, student must have min 9 numberOfAttendedClasses + passed testResult and passedGroupProject.
     * To get Fail, student must have less than 9 numberOfAttendedClasses + passed/fail testResult and passed/fail passedGroupProject.
     */
    public void calculateFinalGrade() {
        if (numberOfAttendedClasses >= 12 && testResult && passedGroupProject) {
            finalGrade = "Pass with distinction";
        } else if (numberOfAttendedClasses > 8 && testResult && passedGroupProject) {
            finalGrade = "Pass";
        } else {
            finalGrade = "Fail";
        }
    }

    /**
     * This method prints student properties to System.out
     */
    public void printStudentInfo() {
        System.out.println("Student ID: " + studentId + "\nNumber of attended classes:" + numberOfAttendedClasses + "\nPassed test: " + testResult + "\nPassed group project: " + passedGroupProject + "\nFinal Grade: " + finalGrade);
    }

    /**
     * This method prints the entered student properties in a text-file in the hard-drive.
     * Every student properties that are newly entered to the program will be added to the end of the text file.
     * the program saves the text file in hard-drive and closes the program.
     * <p>
     * If there is a problem in printing the entered properties in the text file, The type of error and the line that the error has appeared will be printed in System.out
     */
    public void printToFile() {
        try {
            // öppna en fil och skriv varje inmatat student egenskaper i slutet av filen (true argumentet gör det att det börjar skriva i filen från slutet)
            PrintWriter outFile = new PrintWriter(new BufferedWriter(new FileWriter("student results.txt", true)));
            outFile.println(studentId);
            outFile.println(numberOfAttendedClasses);
            outFile.println(testResult);
            outFile.println(passedGroupProject);
            outFile.println(finalGrade);
            // spara filen och stäng filen på hårddisken
            outFile.close();

            // Om det inte går att skriva till filen i varje rad (i varje kommando) ovan, t.ex. om hårddisken är full, en exception borde kastas.
        } catch (Exception e) {
            System.out.println("An error occurred." + e);
            // visa på vilken rad felet dök upp
            e.printStackTrace();
        }
    }
}





