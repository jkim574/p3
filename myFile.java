import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;


public class myFile {

    public static void main(String[] args) {
	Scanner in = null;
	PrintWriter writer = null;
	try {
	    in = new Scanner(new File("test.txt"));
	    writer = new PrintWriter("out.txt");
	} catch (FileNotFoundException e) {

	}

	String line;
	String[] parts;

	while (in.hasNext()) {
	    line = in.nextLine();
	    //parts = line.split("\\s+");
	    writer.println(line);
	}
	in.close();
	writer.close();
    }
}
