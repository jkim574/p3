# p3  Announcements
Corrections, clarifications, and other announcements regarding this programming assignment will be found below.

10/26: PriorityQueueADT.java has been fixed: 
The signature for the removeMax() method must be:  E removeMax() throws EmptyQueueException;
10/25: Students may work individually or in pairs on p3.  You may work with anyone from either lecture 001 or lecture 002.
If you wish to work in a pair, read Principles of Pair Programming, register your p3pair group before 10 PM ON THURSDAY, 11/2.
To register your p3pair, each student must go to People -> Groups tab -> select the same (available) p3pair number.
After this deadline, teams will be set as is and you'll need to work individually.
10/25: Program 3 assigned.
Use Piazza to ask questions about the assignment.
REMINDER: Students caught posting coursework online (i.e. for seeking help or a paid programmer) will get a zero on the assignment and potentially fail the course.





Overview:
The median is the value separating the lower half of a data sample from the upper half when the data is sorted. For a dataset, it may be thought of as the "middle" value. For example, in the data set {1, 3, 3, 6, 7, 8, 9}, the median is 6, is the fourth largest value, and also the fourth smallest value, in the sample of 7 elements. 

When the number of data elements in the data set is even, the median is the average of the middle two values. For example, in the data set {1, 3, 3, 6, 8, 8, 9, 9}, the median is (6 + 8)/2  = 7, since 6 is the fourth smallest value and 8 is the fourth largest value, in the sample of 8 elements.

Note that the data may not always be presented in sorted order. Order of data does not change the median. For example, the median of {10, 1, 20, 3, 5} is 5. Since 5 is the third largest and also the third smallest element in the data set of 5 elements.

Median is a good central measure of data when the data set has abnormal outliers which are too high or too low compared to other data elements. Such outliers are common in weather-related data where short spans of calamities like cyclones, cloudbursts etc., can result in large parameter values for a short period of the years. However, the median would be robust to such extreme data points.

Goals:

The goals of this assignment are to:

Understand, implement, and use minimum and maximum priority queues.
Implement each priority queue using an array-based heap as shown in readings and lecture.
Work with a stream of data in which new data arrives as the program is running.
Find and present the "current median" of a stream of data without having to explicitly sort and insert elements.  The "current median" is the median of the data processed so far in the stream of data values.





Specifications

Imagine that you have been recruited in the weather department. The weather department gets the temperature measurements of your city every day when the sun is at its highest point in the sky. Every day, the weather department wants to publish the median temperature of the city since the beginning of time (or the year so far). 
Write a program which has two modes, interactive mode and file mode.







Interactive Mode

Interactive mode is entered when the user does not pass in filenames as command-line arguments.   In interactive mode, the user is prompted for a value (of type double) and then the current median over all previously entered values is displayed.   This loop repeats until the user enters q to quit.  Actually, any non-double value will end the program if running in interactive mode. See sample runs for more examples.

Enter next value or q to quit: 1
Current median: 1.0
Enter next value or q to quit: 3
Current median: 2.0
Enter next value or q to quit: 4
Current median: 3.0
Enter next value or q to quit: q






File Mode

The program runs in File mode if the user includes command-line arguments (CLAs).  The program reads the name of input files (ex. somefile.txt) from command-line arguments array and opens an output file whose name is derived from the name of input file name by appending "_out" to the input file name before the ".txt" extension (ex. somefile_out.txt).

For each value read from the file, the program will write the median of the data values read so far for that file to a new line of an output file.  If the filename is not a valid file, then no values are read, and a file not found message is displayed. See sample runs.

For every temperature value Ti, the program writes the median temperature of the values read from the first temperature value of the file to the current temperature (Median of T1, T2, T3, ... Ti).  Each median value is written to its own line of the output file.  See sample output files.

All input/output files are guaranteed to be text files with extension ".txt". The input filenames (without the extension ".txt") are guaranteed to have no period "." character.






Algorithm

You are given the following five classes:

EmptyQueueException.java
PriorityQueueADT.java
MaxPQ.java
MinPQ.java
MedianStream.java
As the input stream arrives, store the numbers in two Priority Queues such that at any point of time, about half of the numbers (smaller than the median) are in a MaxPQ and the other half of the numbers (greater than the median) are in a MinPQ. For correct execution of your algorithm, you must maintain the sizes of the two priority queues to be same or differ by 1 at most.

When a new element arrives, check if it greater than or less than the current median. If it is less than the current median, then the element has to be inserted in MaxPQ else it has to be inserted in MinPQ. Let's assume we need to insert the element into MinPQ.

Case 1: If size(MinPQ) = size(MaxPQ), then the new element can be inserted into MinPQ. The new median is the top of MinPQ.

Case 2: If size(MinPQ) = size(MaxPQ) - 1, then the new element can be inserted into MinPQ. The new median is the average of the highest priority element of MinPQ and MaxPQ respectively.

Case 3: If size(MinPQ) = size(MaxPQ) + 1, then remove the highest priority element of MinPQ and insert it into MaxPQ. Insert the new element into MinPQ. The new median is the average of the highest priority element of MinPQ and MaxPQ respectively.

Similarly, think what would happen when we insert the new element into MaxPQ.

Notes:

You are required to implement the priority queues using array-based heaps as presented in readings and lecture.
For getMax() and removeMax() you must throw a EmptyQueueException if they are called and the queue is empty.
For insert(), you must throw IllegalArgumentException if the arguments are not appropriate.







Recommended order for completing this assignment

Complete MinPQ and MaxPQ so that it implements the PriorityQueueADT provided to you.
Thoroughly test each queue implementation with type Double.
Complete the MedianStream class. This class is where the algorithm presented above for finding the median of a stream of values is found. The code inserts numbers into the priority queues and balances them to maintain roughly equal size which is best suited for the fast execution of your algorithm. 
Run your program on a small number of inputs, and check the output. Make sure to test your program on unsorted data sets.
Finally, test your program on a very large number of inputs.

