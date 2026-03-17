//Student Marks Analyzer Requirements:
//Read marks from a file:
//70,85,60,90
//Calculate:
//Total,Average,Highest mark

import java.io.*;
import java.util.*;

public class StudentMarksAnalyzer {
    public static void main(String[] args) {

        try {
            File file = new File("marks.txt");
            Scanner sc = new Scanner(file);

            int total = 0;
            int count = 0;
            int highest = Integer.MIN_VALUE;

            while (sc.hasNextInt()) {
                int mark = sc.nextInt();

                total += mark;
                count++;

                if (mark > highest) {
                    highest = mark;
                }
            }

            double average = (double) total / count;

            System.out.println("Total Marks: " + total);
            System.out.println("Average Marks: " + average);
            System.out.println("Highest Mark: " + highest);

            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}