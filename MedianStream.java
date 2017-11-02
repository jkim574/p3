import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MedianStream
{

    private static final String PROMPT_NEXT_VALUE = "Enter next value or q to quit: ";
    private static final String MEDIAN = "Current median: ";
    private static final String EXIT_MESSAGE = "That wasn't a double or 'q'. Goodbye!";
    private static final String FNF_MESSAGE = " not found.";

    /**
     * Use this format to ensure that double values are formatted correctly.
     * Double doubleValue = 1412.1221132
     * System.out.printf(DOUBLE_FORMAT, doubleValue);
     */
    private static final String DOUBLE_FORMAT = "%8.3f\n";

    private Double currentMedian;
    private MaxPQ<Double> maxHeap;
    private MinPQ<Double> minHeap;

    /**
     * Override Default Constructor
     *
     *  Initialize the currentMedian = 0.0
     *  Create a new MaxPQ and MinPQ.
     */
    public MedianStream()
    {
        this.currentMedian = 0.0;
        this.maxHeap = new MaxPQ<Double>();
        this.minHeap = new MinPQ<Double>();
    }

    /**
     * This method is called if the user passes NO command line arguments.
     * The method prompts the user for a double value on each iteration.
     *
     * If the input received is a double, the current median is updated.
     * After each iteration, print the new current median using MEDIAN string
     * as declared and initialized with the data members above.
     *
     * If the input is the character 'q', return from the method.
     *
     * If the input is anything else, then you print an error using EXIT_MESSAGE
     * string as declared and initialized with the data members above and
     * then return from the method.
     *
     * For the purposes of calculating the median, every input received since
     * the beginning of the method execution is part of the same stream.
     */
    private static void runInteractiveMode()
    {
	Scanner s = new Scanner(System.in);
	MedianStream median = new MedianStream();
	System.out.print(PROMPT_NEXT_VALUE);
	String input = s.next();
	double d = 0.0;
	while (!input.equals("q")) {
	    try {
		d = Double.parseDouble(input);
		System.out.print(MEDIAN);
		System.out.printf(DOUBLE_FORMAT, median.getMedian(d));
		System.out.print(PROMPT_NEXT_VALUE);
		input = s.next();
	    } catch (NumberFormatException ex) {
		System.out.println(EXIT_MESSAGE);
		break;
	    }
	}
    }

    /**
     * This method is called if the user passes command line arguments.
     * The method is called once for every filename passed by the user.
     *
     * The method reads values from the given file and writes the new median
     * after reading each new double value to the output file.
     *
     * The name of the output file follows a format specified in the write-up.
     *
     * If the input file contains a non-double value, the program SHOULD NOT
     * throw an exception, instead it should just read the values up to that
     * point, write medians after each value up to that point and then
     * return from the method.
     *
     * If a FileNotFoundException occurs, just print the string FNF_MESSAGE
     * as declared and initialized with the data members above.
     */
    private static void findMedianForFile(String filename)
    {
	MedianStream median = new MedianStream();
	Scanner in = null;
	PrintWriter writer = null;
	String[] out = filename.split(".");

	String outputName = out[0] + "_out";
	try {
	    in = new Scanner(new File(filename));
	    writer = new PrintWriter(outputName);
	} catch (FileNotFoundException e) {

	}

	String line;
	String[] parts;

	while (in.hasNext()) {
	    line = in.nextLine();
	    line = line.trim();
	    parts = line.split("\\s+");

	    for (String s : parts) {
		double number = Double.parseDouble(s);
		double medians = median.getMedian(number);
		writer.println(medians);
	    }

	}
	in.close();
	writer.close();

    }


    /**
     * YOU ARE NOT COMPULSORILY REQUIRED TO IMPLEMENT THIS METHOD.
     *
     * That said, we found it useful to implement.
     *
     * Adds the new temperature reading to the corresponding
     * maxPQ or minPQ depending upon the current state.
     *
     * Then calculates and returns the updated median.
     *
     * @param newReading - the new reading to be added.
     * @return the updated median.
     */
    private Double getMedian(Double newReading)
    {
	if (newReading >= currentMedian) {
	    if (minHeap.size() == maxHeap.size()) {
		minHeap.insert(newReading);
		currentMedian = minHeap.getMax();
	    } else if (minHeap.size() == maxHeap.size() - 1) {
		minHeap.insert(newReading);
		currentMedian = (minHeap.getMax() + maxHeap.getMax()) / 2;
	    } else if (minHeap.size() == maxHeap.size() + 1) {
		maxHeap.insert(minHeap.getMax());
		minHeap.removeMax();
		minHeap.insert(newReading);
		currentMedian = (minHeap.getMax() + maxHeap.getMax()) / 2;
	    } else {

	    }
	} else if (newReading < currentMedian) {
	    if (maxHeap.size() == minHeap.size()) {
		maxHeap.insert(newReading);
		currentMedian = maxHeap.getMax();
	    } else if (maxHeap.size() == minHeap.size() - 1) {
		maxHeap.insert(newReading);
		currentMedian = (minHeap.getMax() + maxHeap.getMax()) / 2;
	    } else if (maxHeap.size() == minHeap.size() + 1) {
		minHeap.insert(maxHeap.getMax());
		maxHeap.removeMax();
		maxHeap.insert(newReading);
		currentMedian = (minHeap.getMax() + maxHeap.getMax()) / 2;
	    } else {

	    }
	}
	return currentMedian;

    }

    // DO NOT EDIT THE main METHOD.
    public static void main(String[] args)
    {
        // Check if files have been passed in the command line.
        // If no files are passed, run an infinite interactive loop taking a double
        // input each time until "q" is entered by the user.
        // After each iteration of the loop, update and display the new median.
        if ( args.length == 0 )
        {
            runInteractiveMode();
        }

        // If files are passed in the command line, open each file.
        // For each file, iterate over all the double values in the file.
        // After reading each new double value, write the new median to the
        // corresponding output file whose name will be inputFilename_out.txt
        // Stop reading the file at the moment a non-double value is detected.
        else
        {
            for ( int i=0 ; i < args.length ; i++ )
            {
                findMedianForFile(args[i]);
            }
        }
    }
}
