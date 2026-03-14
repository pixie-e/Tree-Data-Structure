/**
* Assignment 9: Tree Data Structure (Human Resources)
* @author Elysium "Pixie" Jones
* 3/XX/26
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
		For testing, try to add Berta in robots twice (no duplicates should
		occur). Also tests whether proper conversion occurs in the new
		PersonImperialSet. Values given here are metric (cm and kg).
		*/
		Person berta = new Person("Berta", 158.50, 68.4);
		/*SortedTreeSet robots = new SortedTreeSet();
		robots.add(berta);
		robots.add(new Person("Josef", 167.64, 92.5));
		robots.add(new Person("Mr. H", 448.06, 122.8));
		robots.add(berta);*/
		//System.out.println(robots.toString());
/*
		//Notice: Berta only appears once, as it should. No duplicates!
		// And, the metric measurements (cm and kg) are correctly converted to
		// inches and pounds!
		System.out.println("Robots List:");
		System.out.println(robots.toString());
		System.out.println();
		*/

		//for testing, spaceshipCrew is out of alphabetical order
		// (Avali should be between Apex and Avian)
		/*SortedTreeSet spaceshipCrew = new SortedTreeSet();
		spaceshipCrew.add(new Person("Apex", 170.0, 135.0));
		spaceshipCrew.add(new Person("Avian", 165.1, 55.1));
		spaceshipCrew.add(new Person("Floran", 150.2, 64.2));
		spaceshipCrew.add(new Person("Glitch", 175.3, 110.3));
		spaceshipCrew.add(new Person("Human", 172.4, 83.4));
		spaceshipCrew.add(new Person("Hylotl", 180.5, 70.5));
		spaceshipCrew.add(new Person("Novakid", 110.6, 44.6));
		spaceshipCrew.add(new Person("Avali", 90.7, 13.7));

		//Notice: Avali is correctly placed between Apex and Avian!
		System.out.println("Spaceship Crew List:");
		System.out.println(spaceshipCrew.toString());
		//System.out.println();
		
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