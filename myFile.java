import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;


public class myFile {

    public static void main(String[] args) {
	Scanner in = null;
	PrintWriter writer = null;
	try {
	    in = new Scanner(new File("file0.txt"));
	    writer = new PrintWriter("out.txt");
	} catch (FileNotFoundException e) {

	}

	String line;
	String[] parts;

	while (in.hasNext()) {
	    line = in.nextLine();
	    line = line.trim();
	    parts = line.split("\\s+");

	    for (string s : parts) {
		double number = double.parseDouble(s);
		double median = getMedian();
		writer.println(median);
	    }




	    writer.println(line);
	}
	in.close();
	writer.close();

    }
}
