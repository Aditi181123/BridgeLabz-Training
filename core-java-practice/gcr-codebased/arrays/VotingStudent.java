package arrays;
import java.util.*;
public class VotingStudent {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter age of students : ");
		int [] age = new int[10];
		for(int i = 0 ; i < 10 ; i++) {
			age[i] = sc.nextInt();
		}
		
		for(int i = 0 ; i < 10 ; i++ ) {
			if(age[i] >= 18) {
				System.out.println("The student with the age "+ age[i] + " can vote .");
			}
			else {
				System.out.println("The student with the age "+age[i] +" can not vote .");
			}
		}
	}
}
