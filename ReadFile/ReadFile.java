import java.io.*;
import java.util.*;

public class ReadFile {
    public static void main(String[] args) {

        try {
            File file = new File("user.txt");
            Scanner sc = new Scanner(file);

            // Read line by line
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }

            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}