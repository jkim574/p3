public class MaxPQTest {
    public static void main(String[] args) {
	MinPQ<Integer> min = new MinPQ<Integer>();
	MaxPQ<Integer> max = new MaxPQ<Integer>();
	min.insert(6);
	min.insert(5);
	max.insert(16);
	max.insert(7);


	max.print_items();
	min.print_items();


	max.insert(min.getMax());
	min.removeMax();


	max.print_items();
	min.print_items();





    }
}
