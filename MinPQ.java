
/**
 * GENERAL DIRECTIONS -
 *
 * 1. You may add private data fields and private methods as you see fit.
 * 2. Implement ALL the methods defined in the PriorityQueueADT interface.
 * 3. DO NOT change the name of the methods defined in the PriorityQueueADT interface.
 * 4. DO NOT edit the PriorityQueueADT interface.
 * 5. DO NOT implement a shadow array.
 */

public class MinPQ<E extends Comparable<E>> implements PriorityQueueADT<E>
{
    private E[] items;
    private static final int INITIAL_SIZE = 10;

    //ADD MORE DATA PRIVATE DATA FIELDS AS YOU NEED.
    private int numItems;

    public MinPQ()
    {
        this.items = (E[]) new Comparable[INITIAL_SIZE];

        // TO-DO: Complete the constructor for any private data fields that you add.
	numItems = 0;
    }

    public boolean isEmpty() {
	if (numItems == 0) {
	    return true;
	}
	return false;

    }

    public void insert(E item) {
	if (item == null) {
	    throw new IllegalArgumentException();
	}
	if (numItems == items.length - 1) {
	    E[] copy = (E[]) new Comparable[2 * items.length];
	    for (int i = 0; i <= numItems; i++) {
		copy[i] = items[i];
	    }
	    items = copy;
	}
	items[numItems++] = item;
    }



    public E getMax() throws EmptyQueueException {
	if (numItems == 0) {
	    throw new EmptyQueueException();
	}
	int min = 0;
	for (int i = 1; i < numItems; i++) {
	    if (items[min].compareTo(items[i]) > 0) {
		min = i;
	    }
	}
	return items[min];

    }

    public E removeMax() throws EmptyQueueException {
	if (numItems == 0) {
	    throw new EmptyQueueException();
	}
	int min = 0;
	for (int i = 1; i < numItems; i++) {
	    if (items[min].compareTo(items[i]) < 0) {
		min = i;
	    }
	}
	E swap = items[min];
	items[min] = items[numItems - 1];
	items[numItems - 1] = swap;
	E k = items[--numItems];
	items[numItems] = null;

	return items[--numItems];
    }

    public int size() {
	return numItems;

    }

}
