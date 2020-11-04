import javax.swing.*;

/*
 * Created by LG
 * Date: 2020-11-02
 * Time: 10:09
 * Project: inlämningsuppgift_03
 * Copyright: MIT
 * To change this template use File | Settings | File Templates.
 */

public class GradeCalculator {
    public static void calculateGrade() {

        // Skapa en ny instans av klassen Student

        Student student = new Student();

        // Skapa en dialogruta att få student info och visa välkomstmeddelande

        student.studentId = JOptionPane.showInputDialog("Dear student,\nplease write your student ID");
        JOptionPane.showMessageDialog(null, "Welcome " + student.studentId + "!\nClick ok and answer the questions.");

        // Skapa en dialogruta för antal närvaro

        String enteredNumberOfAttendedClasses = JOptionPane.showInputDialog("How many classes you have attended in total?\nWrite a number between 1 and 12");
        student.numberOfAttendedClasses = Integer.parseInt(enteredNumberOfAttendedClasses);
        while (student.numberOfAttendedClasses < 13) {
            int actualNumberOfAttendedClasses = student.numberOfAttendedClasses;
        }

        // Skapa en dialogruta för testresultat med yes-no option

        int testResult = JOptionPane.showConfirmDialog(null, "Did you pass your test?", "Test result", JOptionPane.YES_NO_OPTION);

        if (testResult == JOptionPane.YES_OPTION) {
            student.testResult = true;
        } else {
            student.testResult = false;
        }

        // Skapa en dialogruta för projektresultat med yes-no option

        int SelectedGroupProjectResult = JOptionPane.showConfirmDialog(null, "Did you pass your group project?", "Group project result", JOptionPane.YES_NO_OPTION);

        if (SelectedGroupProjectResult == JOptionPane.YES_OPTION) {
            student.passedGroupProject = true;
        } else {
            student.passedGroupProject = false;
        }


        student.calculateFinalGrade();

        student.printStudentInfo();

        // Skapa en meddelande dialogruta för slutresultat

        if (student.finalGrade == "pass with distinction") {
            JOptionPane.showMessageDialog(null, "Congratulations! You are passed with distinction!");
        } else if (student.finalGrade == "pass") {
            JOptionPane.showMessageDialog(null, "Congratulations! You are passed!");
        } else {
            JOptionPane.showMessageDialog(null, "Sorry! You are not passed!");
        }

        Input.createFile(student);

    }
}
