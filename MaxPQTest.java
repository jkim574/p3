public class MaxPQTest {
    public static void main(String[] args) {
	MaxPQ<Integer> queue = new MaxPQ<Integer>();

	queue.insert(2);
	queue.insert(3);
	queue.insert(10);
	queue.insert(5);
	queue.insert(11);
	queue.insert(7);

	System.out.println(queue.size());
	queue.print_items();


	System.out.println(queue.getMax());
		queue.removeMax();
		queue.print_items();
	//	System.out.println(queue.size());




    }
}
