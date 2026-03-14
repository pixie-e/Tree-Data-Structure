/**
* Assignment 9: Tree Data Structure (Human Resources)
* @author Elysium "Pixie" Jones
* 3/XX/26
* 
* class named Person. This will be a very basic class with three
* attributes for storing name, height, and weight information. This class
* should also have a toString method that returns the Person data in a
* database-ready String format.
* 
* Source(s): <a href="https://www.geeksforgeeks.org/java/overriding-equals-method-in-java/">The bulk of the equals method was taken from this site (provided from the instructions document).</a>
* <a href="https://mkyong.com/java/java-how-to-overrides-equals-and-hashcode/">Searched: how to override hashcode java</a>
* <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html">Searched: java comparable interface. This link helped with documentation.</a>
* <a href="https://www.w3schools.com/java/java_advanced_sorting.asp">Searched: java comparable interface. This link helped with setting up the compareTo method.</a>
* 
* Notes: This is the submission for PART 2.
*/
import java.util.Objects;
import java.util.Comparator;

public class Person implements Comparable<Person>
{
	private String name;
	private double height;
	private double weight;
	
	//<<constructor>> Person(name:String, height:double, weight:double)
	public Person (String name, double height, double weight)
	{
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	// + getName() : String
	public String getName() {return this.name;}

	// + getHeight() : double
	public double getHeight() {return this.height;}

	// + getWeight() : double
	public double getWeight() {return this.weight;}

	// + setHeight(height : double) : void
	public void setHeight(double height) {this.height = height;}

	// + setWeight(weight : double) : void
	public void setWeight(double weight) {this.weight = weight;}

	/**
	 * converts all instance variables of a Person to Strings (if needed)
	 * and returns them all together
	 * @return Person data in a database-ready String format
	 */
	/* Neal Holtschulte's overall feedback:
    In Person's toString make the spacing numbers on the string negative,
    but positive for the floats. That way the strings are left aligned and
    the numbers are right aligned so the digits still line up.
    All else is excellent.
    */
	@Override
	public String toString()
	{
		//note: this formatted spacing matches that of the given hr.txt file
		return String.format("%-8s%16.1f%11.1f\n",this.name, this.height, 
																this.weight);
	}

	/**
	 * Override Equals method 
	 * (template was given in assignment, and link in Sources)
	 * @param o  Object to check for equivalence
	 * 
	 * @return boolean for whether passed object and its instance variables are
	 * equivalent to object being compared to
	 */
	// Overriding equals() to compare two Person objects
    @Override
    public boolean equals(Object o) {
    	//if Object o is null then return false
    	if (o == null)
    		return false;

        // If the object is compared with itself then return true 
        // (if Object o == this then return true)
        if (o == this) 
            return true;

        //if Object o is not an instance of Person then return false
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Person)) {
            return false;
        }

    	
		//Declare a new variable of type Person (perhaps named p) 
		//	and assign it to Object o cast as type Person
		// (typecast o to Person so that we can compare data members)
		Person p = (Person) o;

		//if Person p has the same name, height, and weight as 
		//	this then return true
	
		return Objects.equals(this.name, p.name) && // equal String Objects?
               Double.compare(this.height, p.height) == 0 &&
               Double.compare(this.weight, p.weight) == 0;

    } // END overridden equals method

    /** Overridden hashCode method, recommended at the end of
     * <a href="https://www.geeksforgeeks.org/java/overriding-equals-method-in-java/">this website.</a>
     * <a href="https://mkyong.com/java/java-how-to-overrides-equals-and-hashcode/">I also referenced this site to help set up the overridden hashCode.</a>
     * <a href="https://www.w3schools.com/java/ref_string_compareto.asp">Reviewed String compareTo method.</a>
     * 
     * @return integer value of hashCode
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(name, height, weight);
    } // END overridden hashCode method

    /**
     * the method compareTo compares this Person object with the specified
     * Person object for order.
     * (This javadoc was written based on the
     * <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html">documentation for compareTo from Oracle</a>)
     * 
     * @param p - the Person object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException - if the specified object is null
     * @throws ClassCastException - if the specified object's type prevents
     * it from being compared to this object. 
     */
    public int compareTo(Person p)
    {
    	return this.name.compareTo(p.name);
    }// END compareTo method
	
} // END Person class