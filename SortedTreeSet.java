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
 * Requirements: create a self-sorting, binary tree set with an interface
 * (provided). SortedTreeSet.java class implements the interface and also has 
 * a toString method.
 */
class SortedTreeSet implements SortedTreeSetInterface
{
	private Person person;
	//a static root to keep same value for all branches
	private static SortedTreeSet root;
	private SortedTreeSet parent = null;
	private SortedTreeSet leftChild = null;
	private SortedTreeSet rightChild = null;

	//Empty constructor
	public SortedTreeSet() { this.person = null; }
	//Constructor given Person
	public SortedTreeSet(Person p) { this.person = p; }

	public Person getPerson() { return this.person; }

	//parent has, set, get methods
	public boolean hasParent() { return this.parent != null; }

	public void setParent(SortedTreeSet parent) { this.parent = parent; }

	public SortedTreeSet getParent() { return this.parent; }

	//left has, set, get methods
	public boolean hasLeft() { return this.leftChild != null; }

	public void setLeft(SortedTreeSet left) { this.leftChild = left; }

	public SortedTreeSet getLeft() { return this.leftChild; }

	//right has, set, get methods
	public boolean hasRight() { return this.rightChild != null; }

	public void setRight(SortedTreeSet right) { this.rightChild = right; }

	public SortedTreeSet getRight() { return this.rightChild; }

	/**
	 * Add Person objects to a sorted binary tree structure,
	 * sorted with lesser values to left branches and greater
	 * to right branches (lexicographically by Person names)
	 * 
	 * @param p Person object to be added
	 */
	public void add(Person p)
	{
		//there's no root, meaning there's no tree to sort into
		if (root == null)
		{
			//create the root
			root = new SortedTreeSet(p);
			return;
		}
		//start at the root to begin search for where new Person will be added 
		SortedTreeSet current = root;
		//iterate over the tree branches until new Person finds it's place,
		//when Person is placed loop will break.
		while (true)
		{
			//if the current Person is a duplicate, skip adding and break out
			if ((current.getPerson()).equals(p))
				break;
			//if current Person is lexicographically greater than Person p
			else if ((current.getPerson()).compareTo(p) > 0)
			{
				//current does not have a left yet
				if (!current.hasLeft())
				{
					//create a new branch to store Person p
					SortedTreeSet tempLeft = new SortedTreeSet(p);
					// current's left is p
					current.setLeft(tempLeft);
					// p's parent is current
					tempLeft.setParent(current);
					break;
				}
				//get the left; this will repeat until it gets leftmost left
				current = current.getLeft();
			}
			//else p must have been greater than current, put it right
			else
			{
				//current does not have a right yet
				if (!current.hasRight())
				{
					SortedTreeSet tempRight = new SortedTreeSet(p);
					// current's right is p
					current.setRight(tempRight);
					// p's parent is current
					tempRight.setParent(current);
					break;
				}
				//get the right; this will repeat until it gets rightmost right
				current = current.getRight();
			}
		}
	} // END add method

	/** 
	 * Method gatherBranches recursively collects the SortedTreeSets
	 * from lesser/leftmost branches,or greater/rightmost branches,
	 * compiling their contents into a returned String
	 * 
	 * @param current SortedTreeSet that updates during recursion
	 * 
	 * @return The total String of items in order, constructed
	 * from recursive calls on tree set
	 */
	public String gatherBranches (SortedTreeSet current)
	{
		String tempStr = "";
		//check if current has a left to collect
		if (current.hasLeft())
		{
			//prepare String with collected left branch
			tempStr+=gatherBranches(current.getLeft());
		}
		//put the collected (left or right) branch into tempStr as String
		tempStr+=current.getPerson().toString();
		//check if current has a right to collect
		if(current.hasRight())
		{
			//prepare String with collected right branch
			tempStr+=gatherBranches(current.getRight());
		}
		return tempStr; //total string constructed thus far
	} // END gatherBranches method

	/**
	 * Overridden toString method outputs tree data by gathering its
	 * branches, returning results as a String
	 * 
	 * @return String of tree branches' data
	 */
	@Override
	public String toString()
	{
		return "Name    Height (cm)    Weight (kg)\n"+ gatherBranches(root);
	}

} // END SortedTreeSet class