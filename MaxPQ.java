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
    private int numItems; //size of queue



    public MaxPQ()
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
	// add item to the end of array
	if (numItems == items.length - 1) {
	    E[] copy = (E[]) new Comparable[2 * items.length];
	    for (int i = 0; i <= numItems; i++) {
		copy[i] = items[i];
	    }
	    items = copy;
	}
	items[++numItems] = item;

	// camparing parents and children value
	int curr = numItems;
        while ((curr > 1) && (items[curr / 2].compareTo(items[curr]) < 0)) {
	    change(curr, curr / 2);
	    curr = curr / 2;
	}
    }

    public E getMax() throws EmptyQueueException {
	if (numItems == 0) {
	    throw new EmptyQueueException();
	}
	return items[1];
    }

    public E removeMax() throws EmptyQueueException {
        if (numItems == 0) {
	    throw new EmptyQueueException();
	}
	E max = items[1];
	change(1, numItems--);
	down(1);
	items[numItems + 1] = null;
	return max;
    }

    public int size() {
	return numItems;
    }

    public void print_items() {

        for (E e : items)
            System.out.print(e + " ");
        System.out.println();
    }

    // change positions of two values
    private void change(int i , int j) {
	E e = items[i];
	items[i] = items[j];
	items[j] = e;
    }

    private void down(int i) {
	while(2 * i <= numItems) {
	    int j = 2 * i;
	    if (j < numItems && items[j].compareTo(items[j + 1]) < 0) {
		j++;
	    }
	    if (items[i].compareTo(items[j]) > 0) {
		break;
	    }
	    change(i, j);
	    i = j;
	}
    }


}
