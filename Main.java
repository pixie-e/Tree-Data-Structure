/**
* Assignment 9: Tree Data Structure (Human Resources)
* @author Elysium "Pixie" Jones
* 3/14/26
* 
* Purpose: 
* Nintendo’s human resources data is disorganized, full of duplicates,
* and in metric! The information is stored in a database file, hr.txt and it’s
* your task to put it in alphabetical order, with no duplicates
* 
* Requirements:
* 
* Source(s): <a href="https://www.geeksforgeeks.org/java/command-line-arguments-in-java/">Reviewed command line arguments with search: using command line input java</a>
* 
* Notes: This is the submission for Tree Data Structure.
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		System.out.println();
		
		/* 
		If no command line argument is used (args is length 0 or less),
		inform user that they need to include a readable file in the 
		command line and exit. 
		*/
		if (args.length <= 0) 
		{
			System.out.println("No command line arguments found. Please try "
        						+"again, but include a readable file in the "
        						+"command line (i.e. java Main hr.txt)");
            System.exit(1);
        }

        /* 
        The command line argument args is used (it is greater than 0), so
		try to read in the value of args as a new file, and while there is
		data to read in from the file, add the data to a PersonOrderedSet
		and PersonImperialSet. Finally, when the reading is done display
		out the PersonOrderedSet and PersonImperialSet.
		Catches IOException if one occurs, displays problem, and
		exits program.
		*/
		SortedTreeSet inputOrderedSet = new SortedTreeSet();
		
        try
		{
			File inputFile = new File(args[0]);
			Scanner fileReader = new Scanner(inputFile);
			// strip the first line (contains header categories not data)
			fileReader.nextLine();

			while (fileReader.hasNext())
			{
				// Don't overcomplicate the data
				// reading. After skipping the
				// first row, you can use the 
				// following to read a row of
				// character info, assuming your
				// Scanner is named "fileReader"
				String name = fileReader.next();
				double height = fileReader.nextDouble();
				double weight = fileReader.nextDouble();
				Person tempPerson = new Person(name, height, weight);
			
				inputOrderedSet.add(tempPerson);
			}
			//output the ordered data and the imperial data to the screen/console
			System.out.println(args[0]+" Ordered List:");
			System.out.println(inputOrderedSet.toString());
			
			fileReader.close();
		}
		catch (IOException e)
		{
			System.out.println("ERROR: something went wrong when reading file");
			System.out.println(e);
			e.printStackTrace();
			System.exit(1);
		}
	
		/* 
		Output the formatted data with header to two separate files named:
		hr_ordered_set_output.txt and hr_imperial_set_output.txt
		*/
		try
		{	
			FileWriter fileWriterOrder = new FileWriter("hr_ordered_set_output.txt");
			fileWriterOrder.write(""+inputOrderedSet.toString());
			fileWriterOrder.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println(e);
			System.exit(1);
		}

	} // END main method
} // END Main class