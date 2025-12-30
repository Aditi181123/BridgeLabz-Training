package stackQueueHashmaps;
import java.util.*;

public class StockSpan {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of days: ");
		int n = sc.nextInt();

		int[] prices = new int[n];
		System.out.println("Enter the stock prices:");
		for (int i = 0; i < n; i++) {
			prices[i] = sc.nextInt();
		}

		int[] span = calculateSpan(prices, n);

		System.out.println("Span for each day:");
		for (int s : span) {
			System.out.print(s + " ");
		}
		sc.close();
	}

	static int[] calculateSpan(int[] prices, int n) {
		int[] span = new int[n];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				span[i] = i + 1;
			} else {
				span[i] = i - stack.peek();
			}

			stack.push(i);
		}

		return span;
	}

}
