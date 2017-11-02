import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class Scratch {
        public static void main(String[] args) {
                Scanner in = null;
                try {
                        in = new Scanner(new File("MinPQ.java"));
                } catch (FileNotFoundException e) {

                }
                String line;

                while (in.hasNext()) {
                        line = in.nextLine();
                        System.out.println(line);
                }
                in.close();
        }
}
