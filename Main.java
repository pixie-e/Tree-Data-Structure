/**
* Assignment 7: Human Resources (PART 2 submission)
* @author Elysium "Pixie" Jones
* 2/27/26
* 
* Purpose: 
* Nintendo’s human resources data is disorganized, full of duplicates,
* and in metric! The information is stored in a database file, hr.txt and it’s
* your task to create two new versions of it: 
* One version will be in alphabetical order
* One version will be converted from metric to imperial units
* And both versions will have no duplicates
* 
* Requirements:
* =PART 1=
* - Write a class named Person. This will be a very basic class with three
* attributes for storing name, height, and weight information. This class
* should also have a toString method that returns the Person data in a
* database-ready String format.
* 
* - Write an interface named PersonList. The interface should have
* two abstract methods:
* 	> add – This method takes a Person as input and returns void.
* 	> get – This method takes an int as input and returns a Person at the 
* 			corresponding index of the input int.
* 
* - Write a class named, PersonSet, that implements the interface PersonList.
* Use an ArrayList and fill in the add and get methods. You may not use any
* built in Set-type Java classes.
* 
* - In addition to implementing add and get methods, PersonSet must make sure
* that no duplicate Persons are added. If you want to use the ArrayList’s
* built-in contains method to make this easier, you will need to add an equals
* method to Person.
* 
* - In the main method in Main:
* 	> Instantiate a single Person object as a test. You can make up the data
* 	  passed to the constructor. (See berta)
* 	> Instantiate a PersonSet object as a test. (See robots and spaceshipCrew)
* 	> Read data in from the file hr.txt and display it on the command prompt.
* 	  (passed through command line argument). (Note I created a method printList
* 	  to help with this. printList is in PersonSet.java)
* 
* =PART 2=
* - Add a toString method to PersonSet that loops through the ArrayList,
* concatenating the Persons data to a String variable, which is then returned.
* The format needs to match the format of hr.txt.
* 
* - Write a class named, PersonOrderedSet. This class should extend PersonSet
* and override the add method to add Persons in alphabetical order by name.
* 
* - Write a class named, PersonImperialSet. This class should extend PersonSet
* and override the add method to convert the height measurement from
* centimeters to inches and the weight from kilograms to pounds.
* (Look up the conversions online.)
* 
* - Modify Main to:
* 	> Instantiate a PersonOrderedSet and a PersonImperialSet, instead of the 
* 	  PersonSet.
* 	> Read in the data from the file, use it to populate both set objects with
* 	  Persons, and then write out the data into two separate output files
* 	  (one ordered and one imperial).
* 	> I recommend adding methods to the classes to get the data in a text
* 	  format for writing to file. You should think about which class is most
* 	  appropriate for this method (or methods) to be implemented in order to
* 	  reduce code duplication.
* 	> Output the formatted data with header to two separate files named:
* 	  hr_imperial_set_output.txt and hr_ordered_set_output.txt
* 	> Lastly, output the ordered data and the imperial data to the screen/console,
* 	  nicely formatted in rows and labeled columns (this nice formatting should
* 	  already be in use if you wrote your toString methods well).
* 
* Source(s): <a href="https://www.geeksforgeeks.org/java/command-line-arguments-in-java/">Reviewed command line arguments with search: using command line input java</a>
* 
* Notes: This is the submission for PART 2.
*/

/*
This code is provided to give you a
starting place. It should be modified.
No further imports are needed.
To earn full credit, you must also
answer the following questions:

Q1: Car and Engine are related
by which, Inheritance or Composition?
	Composition - a car HAS an engine and can use
	it as a component, but a car isn't characteristically
	an engine

Q2: Color and Red are related
by which, Inheritance or Composition?
	Inheritance - red IS a color and can do the
	same things any other color can do

Q3: Shirt and Clothing are related
by which, Inheritance or Composition?
	Inheritance - a shirt IS clothing and works
	as a type of clothing

Q4: Furniture and Desk are related
by which, Inheritance or Composition?
	Inheritance - a desk IS a piece of furniture
	and even though "furniture" could mean a lot of things,
	a desk works as a piece of furniture, even if
	it has different specific uses compared to other furniture

Q5: CellPhone and Battery are related
by which, Inheritance or Composition?
	Composition - a cell phone HAS a battery and uses it
	as a component, but a cell phone isn't characteristically
	a battery
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
		/*PersonSet robots = new PersonImperialSet();
		robots.add(berta);
		robots.add(new Person("Josef", 167.64, 92.5));
		robots.add(new Person("Mr. H", 448.06, 122.8));
		robots.add(berta);

		//Notice: Berta only appears once, as it should. No duplicates!
		// And, the metric measurements (cm and kg) are correctly converted to
		// inches and pounds!
		System.out.println("Robots List:");
		System.out.println(robots.toString());
		System.out.println();
*/
		//for testing, spaceshipCrew is out of alphabetical order
		// (Avali should be between Apex and Avian)
		/*PersonSet spaceshipCrew = new PersonOrderedSet();
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
		System.out.println();
*/		
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
/*		PersonOrderedSet inputOrderedSet = new PersonOrderedSet();
		PersonImperialSet inputImperialSet = new PersonImperialSet();
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
				inputImperialSet.add(tempPerson);
				inputOrderedSet.add(tempPerson);
			}
			//output the ordered data and the imperial data to the screen/console
			System.out.println(args[0]+" Ordered List:");
			System.out.println(inputOrderedSet.toString());
			System.out.println(args[0]+" Imperial List:");
			System.out.println(inputImperialSet.toString());
			fileReader.close();
		}
		catch (IOException e)
		{
			System.out.println("ERROR: something went wrong when reading file");
			System.out.println(e);
			e.printStackTrace();
			System.exit(1);
		}
*/		
		/* 
		Output the formatted data with header to two separate files named:
		hr_ordered_set_output.txt and hr_imperial_set_output.txt
		*/
/*		try
		{	
			FileWriter fileWriterOrder = new FileWriter("hr_ordered_set_output.txt");
			fileWriterOrder.write(""+inputOrderedSet.toString());
			fileWriterOrder.close();

			FileWriter fileWriterImperial = new FileWriter("hr_imperial_set_output.txt");
			fileWriterImperial.write(inputImperialSet.toString());
			fileWriterImperial.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println(e);
			System.exit(1);
		}
*/
	} // END main method
} // END Main class