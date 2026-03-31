package sortingAlgorithms;
import java.util.*;

public class MergeSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int [] arr = new int[n];
		for(int i = 0 ;i < n ; i++) {
			arr[i] = sc.nextInt();
		}
		
		sort(arr , 0 , n-1);
		
		for(int show : arr) {
			System.out.print(show + " ");
		}
	}
	
	static void sort(int[] arr , int left , int right) {
		if(left < right) {
			int mid = (right + left) / 2;
			sort(arr , left , mid);
			sort(arr , mid + 1 , right);
			merge(arr , left , mid , right);
		}
	}

	static void merge(int[] arr ,int left , int mid, int right) {
		int n = mid - left + 1;
		int m = right - mid;
		
		int[] L = new int[n];
		int[] R = new int[m];
		
		for(int i = 0 ; i < n ; i++) {
			L[i] = arr[left + i];
		}
		for(int i = 0 ; i < m ; i++) {
			R[i] = arr[mid + i + 1];
		}
		
		int i = 0 , j = 0 , k = left;
		while(i < n && j < m) {
			if(L[i] <= R[j]) {
				arr[k++] = L[i++]; 
			}
			else {
				arr[k++] = R[j++];
			}
		}
		
		while(i < n) {
			arr[k++] = L[i++];
		}
		
		while(j < m) {
			arr[k++] = R[j++];
		}
	}
}
