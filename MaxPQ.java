/**
 * GENERAL DIRECTIONS -
 *
 * 1. You may add private data fields and private methods as you see fit.
 * 2. Implement ALL the methods defined in the PriorityQueueADT interface.
 * 3. DO NOT change the name of the methods defined in the PriorityQueueADT interface.
 * 4. DO NOT edit the PriorityQueueADT interface.
 * 5. DO NOT implement a shadow array.
 */

public class MaxPQ<E extends Comparable<E>> implements PriorityQueueADT<E>
{
    private E[] items;
    private static final int INITIAL_SIZE = 10;
     //ADD MORE DATA PRIVATE DATA FIELDS AS YOU NEED.

    private int numItems;



    public MaxPQ()
    {
        this.items = (E[]) new Comparable[INITIAL_SIZE];
	numItems = 0;

        // TO-DO: Complete the constructor for any private data fields that you add.
    }

    public booelan isEmpty() {
	if (numItems == 0) {
	    return true;
	}
	return false;

    }

    public void insert(E item) {
	if (item == null) {
	    throw new IllegalArgumentException();
	}
	items[numItems] = item;
	numItems++;
    }

    public E getMax() throws EmptyQueueException {
	return;
    }

    public E removeMax() throws EmptyQueueException {
	return;
    }

    public int size() {
	return numItems;
    }
}
