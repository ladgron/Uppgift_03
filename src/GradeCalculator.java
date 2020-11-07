import javax.swing.*;

/*
 * Created by LG
 * Date: 2020-11-02
 * Time: 10:09
 * Project: inlämningsuppgift_03
 * Copyright: MIT
 * To change this template use File | Settings | File Templates.
 */

// skapa en klass som innehåller metoder att samla informationen för att räkna ut en students betyg

public class GradeCalculator {

    /**
     * This method gathers the required information from student(user) for calculating the finalGrade,
     * calculates the finalGrade,
     * and prints the information from student(user) + calculated finalGrade in a text-file (each newly-entered info will be added at the end of the text-file).
     * If there is a problem in printing the properties in the text-file, The type of error and the line that the error has appeared will be printed in System.out
     * <p>
     * This method asks student(user) to answer the questions shown in dialog windows.
     * <p>
     * In order for the program to accept the entered numberOfAttendedClasses, the user must write a number from 1 to 12.
     * If this requirement is not met, the error will appear in dialog window and asks the user to write the correct numberOfAttendedClasses.
     * <p>
     * To get Pass with distinction, student must have 12 numberOfAttendedClasses + passed testResult and passedGroupProject.
     * To get Pass, student must have min 9 numberOfAttendedClasses + passed testResult and passedGroupProject.
     * To get Fail, student must have less than 9 numberOfAttendedClasses + passed/fail testResult and passed/fail passedGroupProject.
     * <p>
     * A dialog window will pop up with a message showing student finalGrade.
     */
    public static void calculateGrade() {

        // The answers to the questions will put in as values for properties of the student object (an instance of klass Student)

        // Skapa en ny instans (student objekt) av klassen Student
        Student student = new Student();

        // Skapa en inputdialogruta som frågar efter student ID
        student.studentId = JOptionPane.showInputDialog("Dear student,\nplease write your student ID");
        // Skapa en meddelandedialogruta som visar student ID och ett välkomstmeddelande
        JOptionPane.showMessageDialog(null, "Welcome " + student.studentId + "!\nClick ok and answer the questions.");

        // Skapa en dialogruta för student närvaro
        // Eftersom studenten kan skriva in fel i dialogrutan, skapa en While-loop som tar hand om olika typer av eventuella inmatningsfel.
        // Gå ut while-loopen och fortsätt programmet när något rätt är inmatat.

        while (student.numberOfAttendedClasses > 12 || student.numberOfAttendedClasses < 1) {
            String enteredNumberOfAttendedClasses = JOptionPane.showInputDialog("How many classes you have attended in total?\n(Write a number between 1 and 12)");
            if (enteredNumberOfAttendedClasses == null)   // om användaren klickade på avbryt
                System.exit(0);
            try {
                student.numberOfAttendedClasses = Integer.parseInt(enteredNumberOfAttendedClasses); // ändra input siffran datatyp från string till int
            } catch (Exception e) {   // vi behöver inte skriva ett fel meddelande här för att numberOfAttendedClasses har inte fått ett värde så felmeddelande nedan kommer att skrivas ut.
            }

            if (student.numberOfAttendedClasses > 12 || student.numberOfAttendedClasses < 1) // visa fel meddelande för fel inmatad närvaro
                JOptionPane.showMessageDialog(null, "Error! Write a number between 1 and 12!");
        }

        // Skapa en dialogruta för student att välja testresultat med yes-no option
        int testResult = JOptionPane.showConfirmDialog(null, "Did you pass your test?", "Test result", JOptionPane.YES_NO_OPTION);

        if (testResult == JOptionPane.YES_OPTION) {
            student.testResult = true;
        } else {
            student.testResult = false;
        }

        // Skapa en dialogruta för student att välja projektresultat med yes-no option
        int SelectedGroupProjectResult = JOptionPane.showConfirmDialog(null, "Did you pass your group project?", "Group project result", JOptionPane.YES_NO_OPTION);

        if (SelectedGroupProjectResult == JOptionPane.YES_OPTION) {
            student.passedGroupProject = true;
        } else {
            student.passedGroupProject = false;
        }

        // räkna ut betyget - anropa metoden calculateFinalGrade i student objektet
        // calls the method (calculateFinalGrade) that calculates the final Grade.
        student.calculateFinalGrade();

        // Skapa ett meddelandedialogruta som visar student finalGrade
        if (student.finalGrade == "Pass with distinction") {
            JOptionPane.showMessageDialog(null, "Congratulations! You are passed with distinction!");
        } else if (student.finalGrade == "Pass") {
            JOptionPane.showMessageDialog(null, "Congratulations! You are passed!");
        } else {
            JOptionPane.showMessageDialog(null, "Sorry! You are not passed!");
        }

        // Skriva ut egenskaper för student objektet i en fil - anropa metoden printToFile i student objektet
        // calls the method (printToFile) that prints the gathered information from the student and calculated finalGrade in a text-file.
        student.printToFile();

    }
}
