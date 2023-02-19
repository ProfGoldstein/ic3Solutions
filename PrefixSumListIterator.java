import java.util.*;
/**
 * An iterator class that calculates and returns the prefix sums
 * over a list of integers.  The list can be any AbstractList type
 * 
 * @author Ira Goldstein
 * @version Spring 2023
 *
 */

public class PrefixSumListIterator implements java.util.Iterator<Integer> {

    private List<Integer> list;  		// The list of integers
    private Iterator<Integer> listIterator;	//The list's iterator
    private int prefixSum;				// The sum of the elements in the array

    // Constructor
    /**
	* The PrefixSumListIterator constructor
	* Takes a list and initializes the iterator and prefix sum
	* @param list    The list containing the values
	*/
    public PrefixSumListIterator(List<Integer> list) {
		this.list = list;		// Initializes the list we will be iterating
        this.listIterator = list.listIterator(); 	// Initializes the iterator
		this.prefixSum = 0;		// Initializes the running sum
    }

    /**
	* Overrides the hasNext() method
	* Checks to see if ther are any more elements in the list that we have
	* not yet added to the prefix sum
	*
	* @return True if there are more values, False if there are no more values
	*/
    @Override
    public boolean hasNext() {
	    return listIterator.hasNext();
    }

    /**
	* Overrides the next() method
	* Retrieves the next integer from the list and adds it to the running sum
	* @return prefixSum     The running sum of the list of integers
	*/
    @Override
    public Integer next() {
		prefixSum += listIterator.next();	// Adds the value of the current 
											// integer to the running sum
		return prefixSum;
    }

    /**
    * main method to test the PrefixSumListIterator class.
	*
    * @param args[0] size of the list to generate
    * @param args[1] range of random values
    */
    public static void main(String args[]) {

		if (args.length != 2) {
			System.err.println("Usage: java PrefixSumListIterator size range");
			System.exit(1);
		}

	    // convert the command-line parameters to the numbers needed
		int n = 0;
		int range = 0;
		try {
			n = Integer.parseInt(args[0]);
			range = Integer.parseInt(args[1]);
		}
		catch (NumberFormatException e) {
			System.err.println(e);
			System.exit(1);
		}

	    // create and populate three list, LinkedList, Vector, and Stack
		java.util.Random r = new java.util.Random();
		List<Integer> lList = new LinkedList<Integer>();
		List<Integer> vList = new Vector<Integer>();
		List<Integer> sList = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			int rNum = r.nextInt(range);
			lList.add(rNum);
			vList.add(rNum);
			sList.add(rNum);
		}

        // Print out the list of numbers
		System.out.println("Generated list: " + lList);

        // Print out the LinkedList prefix sums
		System.out.println("Prefix LinkedList sums:");
		java.util.Iterator<Integer> linkedIterator = new PrefixSumListIterator(lList);
		while (linkedIterator.hasNext()) {
			System.out.println(linkedIterator.next());
		}
        // Print out the Vector prefix sums		
		System.out.println("Prefix Vector sums:");
		java.util.Iterator<Integer> vectorIterator = new PrefixSumListIterator(vList);
		while (vectorIterator.hasNext()) {
			System.out.println(vectorIterator.next());
		}	
		
        // Print out the Stack prefix sums
		System.out.println("Prefix Stack sums:");
		java.util.Iterator<Integer> stackIterator = new PrefixSumListIterator(sList);
		while (stackIterator.hasNext()) {
			System.out.println(stackIterator.next());
		}		
    }
}
