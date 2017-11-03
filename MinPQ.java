/////////////////////////////////////////////////////////////////////////////
// Main Class File:  MedianStream.java
// File:             MedianStrea.java
// Semester:         Fall 2017 Lec01
//
// Author:           Joong Ho Kim
// CS Login:         joong
// TA's Name:        Yash Trivedi
//
// Pair Partner:     None
// Credits:          none
//////////////////////////// 80 columns wide //////////////////////////////////
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

    /**
     * Initializes an empty priority queue
     */
    public MinPQ()
    {
        this.items = (E[]) new Comparable[INITIAL_SIZE];
	numItems = 0;
    }

    /**
     * Checks if the priority queue has any
     * elements and returns true if no elements,
     * false otherwise.
     *
     * @return true if no elements in queue, false otherwise.
     */
    public boolean isEmpty() {
	if (numItems == 0) {
	    return true;
	}
	return false;
    }

    /**
     * Adds a data item to the priority queue.
     * Reorders all the other data items in the
     * queue accordingly.
     *
     * If the size if equal to the capacity of the
     * priority queue, double the capacity and then
     * add the new item.
     *
     * @param item the item to add
     * @throws IllegalArgumentException if item is null
     */
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

    /**
     * Returns the highest priority item in the priority queue.
     *
     * MinPriorityQueue => it will return the smallest valued element.
     * MaxPriorityQueue => it will return the largest valued element.
     *
     * @return the highest priority item in the priority queue.

     * @throws EmptyQueueException if priority queue is empty.
     */
    public E getMax() throws EmptyQueueException {
	if (numItems == 0) {
	    throw new EmptyQueueException();
	}
	return items[1];
    }

    /**
     * Returns and removes the highest priority item in the priority queue.
     * Reorders all the other data items in the
     * queue accordingly.
     *
     * MinPriorityQueue => it will return and remove the smallest valued element.
     * MaxPriorityQueue => it will return and remove the largest valued element.
     *
     * @return the highest priority item in the priority queue.
     * @throws EmptyQueueException if priority queue is empty.
     */
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

    /**
     * Returns the number of elements in the priority queue.
     *
     * @return number of elements in the queue.
     */
    public int size() {
	return numItems;
    }

    /**
     * This is a helper private method to show that
     *
     * @param children and parent elements to exchange
     */
    private void change(int i , int j) {
	E e = items[i];
	items[i] = items[j];
	items[j] = e;
    }

    /**
     * This is a helper private method to exchange children element with its parent
     *
     * @param a position of parent
     */
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
}
