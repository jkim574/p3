public class MaxPQTest {
    public static void main(String[] args) {
	MaxPQ<Integer> queue = new MaxPQ<Integer>();
	queue.insert(2);
	queue.insert(7);
	queue.insert(5);
	queue.insert(25);
	queue.insert(1);

	System.out.println(queue.size());
	System.out.println(queue.isEmpty());

	System.out.println(queue.getMax());
	System.out.println(queue.removeMax());
	System.out.println(queue.size());
    }
}
