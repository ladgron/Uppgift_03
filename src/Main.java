import javax.swing.*;

public class Main {

/**
 * This method shows a window dialog which asks the user to select to use the program as a student, or as a teacher or end the program.
 * If user is a student, further dialog windows will appear to gather student information
 * If user is a teacher, a dialog window will appear showing the total number of students who got passed with distinction, passed or failed.
 */
 public static void main(String[] args) {

// fortsätt med att visa option-fönstret tills användaren clicker på End program knapp
        while (true) {

            // skapa en inputdialogruta som frågar om användaren är student eller lärare, eller om hen vill sluta programmet
            // skapa en array med tre knapptexter
            Object[] options = {"Student", "Teacher", "End program"};
            int choice = JOptionPane.showOptionDialog(null, "Choose if you are a student or a teacher,\nor if you wish to end the program:", "Role selection", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);


            // om användaren är student (0 är valt från arreyen above), fortsätt med att räkna ut student betyget
            if (choice == 0) {
                GradeCalculator.calculateGrade();
            }
            // om användaren är teacher, fortsätt med att räkna ut antal betyg
            else if (choice == 1) {
                StatisticCalculator.countNumberOfGrades();
            }
            // om användaren är clicker på End program
            else {
                System.exit(0);
            }

        }
    }
}