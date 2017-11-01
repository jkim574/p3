
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
    private int numItems;

    public MinPQ()
    {
        this.items = (E[]) new Comparable[INITIAL_SIZE];
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
        while ((curr > 1) && (items[curr / 2].compareTo(items[curr]) > 0)) {
	    change(curr, curr / 2);
	    curr = curr / 2;
	}
    }


    private void change(int i , int j) {
	E e = items[i];
	items[i] = items[j];
	items[j] = e;
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
	E min = items[1];
	change(1, numItems--);
	down(1);
	items[numItems + 1] = null;
	return min;
    }

    private void down(int i) {
	while(2 * i <= numItems) {
	    int j = 2 * i;
	    if (j < numItems && items[j].compareTo(items[j + 1]) > 0) {
		j++;
	    }
	    if (items[i].compareTo(items[j]) < 0) {
		break;
	    }
	    change(i, j);
	    i = j;
	}
    }

    public int size() {
	return numItems;
    }

    public void print_items() {

        for (E e : items)
            System.out.print(e + " ");
        System.out.println();
    }

}
