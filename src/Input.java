import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Created by LG
 * Date: 2020-11-02
 * Time: 17:46
 * Project: inlämningsuppgift_03
 * Copyright: MIT
 * To change this template use File | Settings | File Templates.
 */
public class Input {
    public static void createFile(Student student) {

        try {
            PrintWriter outFile = new PrintWriter(student.studentId + ".txt");
            outFile.println(student.numberOfAttendedClasses);
            outFile.println(student.testResult);
            outFile.println(student.passedGroupProject);
            outFile.println(student.finalGrade);

            outFile.close();
        } catch (Exception ettFel) {
            System.out.println("An error occurred." + ettFel);
            ettFel.printStackTrace();
        }
    }


    public static int[] createArray() {
        int[] array = new int[30];
        try {
            Scanner inputFil = new Scanner(new File("Student list.txt"));

            for (int i = 0; i < 30 && inputFil.hasNextInt(); i++) {
                array[i] = inputFil.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Något gick fel när vi försökte läsa från filen: " + e);
            e.printStackTrace();
        }
        return array;
    }
}
