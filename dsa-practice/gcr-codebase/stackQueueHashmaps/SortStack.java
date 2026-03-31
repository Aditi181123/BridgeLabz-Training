package stackQueueHashmaps;
import java.util.*;
public class SortStack {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();

		int[] elements = {10, 60, 30, 20, 50};

		for (int i = 0; i < elements.length; i++) {
			stack.push(elements[i]);
		}
		sortStack(stack);
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + ", ");
		}
	}

	static void sortStack(Stack<Integer> stack) {
		if(!stack.isEmpty()) {
			int top = stack.pop();
			sortStack(stack);
			sorted(stack ,top);
		}
	}
	
	static void sorted(Stack<Integer> stack , int val) {
		if(stack.isEmpty() || val < stack.peek() ) {
			stack.push(val);
		}else {
			int top = stack.pop();
			sorted(stack , val);
			stack.push(top);
		}
	}
	
}
