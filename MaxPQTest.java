public class MaxPQTest {
    public static void main(String[] args) {
	MinPQ<Integer> queue = new MinPQ<Integer>();

	queue.insert(5);
	queue.insert(6);
	queue.insert(2);
	queue.insert(3);



	System.out.println(queue.getMax());

	System.out.println(queue.size());
	System.out.println(queue.removeMax());
	System.out.println(queue.size());


    }
}
