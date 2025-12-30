package stackQueueHashmaps;
import java.util.*;

class Queue{
	private Stack<Integer> stackenqueue;
	private Stack<Integer> stackdequeue;
	
	public Queue() {
		stackenqueue = new Stack<>();
		stackdequeue = new Stack<>();
	}
	
	public void enqueue(int x) {
		stackenqueue.push(x);
	}

	public void shiftstacks() {
		if(stackdequeue.isEmpty()) {
			while(!stackenqueue.isEmpty()) {
				stackdequeue.push(stackenqueue.pop());
			}
		}
	}
	
	public int dequeue() {
		shiftstacks();
		if(stackdequeue.isEmpty()) {
			System.out.println("Queue is Empty");
		}
		return stackdequeue.pop();
	}
	
	public int peek() {
		shiftstacks();
		if(stackdequeue.isEmpty()) {
			System.out.println("Queue is Empty");
		}
		return stackdequeue.peek();
	}
	public boolean isEmpty() {
		return stackdequeue.isEmpty() && stackenqueue.isEmpty();
	}
}
public class QueuebyStack {
	public static void main(String [] args) {
		  Queue queue = new Queue();

	        queue.enqueue(10);
	        queue.enqueue(20);
	        queue.enqueue(30);

	        System.out.println(queue.dequeue());
	        queue.enqueue(40);
	        System.out.println(queue.peek());
	        System.out.println(queue.dequeue());
	        System.out.println(queue.dequeue());
	        System.out.println(queue.dequeue());
	        System.out.println(queue.isEmpty());
	}
}
