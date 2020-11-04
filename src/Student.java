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

    // skapa instansvariabler i klassen Student

    int numberOfAttendedClasses = 0;
    boolean testResult;
    boolean passedGroupProject;
    String finalGrade;
    String studentId;

    // räkna slutresultat med användning av inmatade information

    public void calculateFinalGrade() {
        if (numberOfAttendedClasses >= 12 && testResult && passedGroupProject) {
            finalGrade = "pass with distinction";
        } else if (numberOfAttendedClasses > 8 && testResult && passedGroupProject) {
            finalGrade = "pass";
        } else {
            finalGrade = "Fail";
        }
    }


    // skriva ut student informationen

    public void printStudentInfo() {
        System.out.println("Number of attended classes:" + numberOfAttendedClasses + "\nPassed test: " + testResult + "\nPassed group project: " + passedGroupProject + "\nFinal Grade: " + finalGrade);

    }

}




