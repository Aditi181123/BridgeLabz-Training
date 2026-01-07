package collections;
import java.util.*;

public class ReverseList{
	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<>();
		for (int i = 1; i <= 5; i++) arrayList.add(i); 
		System.out.println("Original ArrayList: " + arrayList);
		reverseAL(arrayList);
		System.out.println("Reversed Array List : " + arrayList);

		LinkedList<Integer> linkedList = new LinkedList<>(); 
		for (int i = 1; i <= 5; i++) linkedList.add(i);
		System.out.println("\nOriginal LinkedList: " + linkedList); 
		LinkedList<Integer> reversedLinkedList = reverseLL(linkedList); 
		System.out.println("Reversed LinkedList: " + reversedLinkedList);

	}



	private static LinkedList<Integer> reverseLL(List<Integer> linkedList) {
		// TODO Auto-generated method stub
		List<Integer> rev = new LinkedList<>();
		for (Integer element : linkedList) {
			rev.addFirst(element); // inserts at head 
		}
		return (LinkedList<Integer>) rev;

	}

	private static void reverseAL(List<Integer> AL) {
		// TODO Auto-generated method stub
		int n = AL.size();
		for(int i = 0 ; i < n/2 ; i++) {
			int temp = AL.get(i);
			AL.set(i, AL.get(n - i - 1));
			AL.set(n - i - 1, temp);
		}

	}
}
