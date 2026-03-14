/**
 *  Assignment 9: Tree Data Structure (Human Resources)
 * @author Elysium "Pixie" Jones
 * 3/14/26
 */
class SortedTreeSet implements SortedTreeSetInterface
{
	private Person person;
	private static SortedTreeSet root;
	private SortedTreeSet parent = null;
	private SortedTreeSet leftChild = null;
	private SortedTreeSet rightChild = null;

	//Empty constructor
	public SortedTreeSet() { this.person = null; }
	//Constructor given Person
	public SortedTreeSet(Person p)
	{
		this.person = p;
	}


	public Person getPerson() { return this.person; }

	public boolean hasParent() { return this.parent != null; }

	public void setParent(SortedTreeSet parent) { this.parent = parent; }

	public SortedTreeSet getParent() { return this.parent; }

	public boolean hasLeft() { return this.leftChild != null; }

	public void setLeft(SortedTreeSet left) { this.leftChild = left; }

	public SortedTreeSet getLeft() { return this.leftChild; }
	
	public boolean hasRight() { return this.rightChild != null; }

	public void setRight(SortedTreeSet right) { this.rightChild = right; }

	public SortedTreeSet getRight() { return this.rightChild; }

	public void add(Person p)
	{
		if (root == null)
		{
			root = new SortedTreeSet(p);
			//root.person = p;
			//this.person = p;
			return;
		}
		SortedTreeSet current = root;
		while (true)
		{
			if ((current.getPerson()).equals(p))
				break;
			else if ((current.getPerson()).compareTo(p) > 0)
			{
				if (!current.hasLeft())
				{
					SortedTreeSet tempLeft = new SortedTreeSet(p);
					current.setLeft(tempLeft);
					tempLeft.setParent(current);
					break;
				}
				current = current.getLeft();
			}
			else
			{
				if (!current.hasRight())
				{
					SortedTreeSet tempRight = new SortedTreeSet(p);
					current.setRight(tempRight);
					tempRight.setParent(current);
					break;
				}
				current = current.getRight();
			}

		}

	}

	public String gatherBranches (SortedTreeSet current)
	{
		String tempStr = "";
		if (current.hasLeft())
		{
			tempStr+=gatherBranches(current.getLeft());
		}
		tempStr+=current.getPerson().toString();
		if(current.hasRight())
		{
			tempStr+=gatherBranches(current.getRight());
		}
		return tempStr;
	}

	@Override
	public String toString()
	{
		
		String personsStringData = ("Name    Height (cm)    Weight (kg)\n");
		personsStringData += gatherBranches(root);
		return personsStringData;

		
		/*for (int i = 0; i<personSet.size(); i++)
			personsStringData = personsStringData.concat(personSet.get(i).toString()+"\n");
		*/
		//return personsStringData;
		
		//return "";
	}

} // END SortedTreeSet class