package review;

final class num{
	
}
public class FinalKeyword {
	public static void main(String[] args) {
		final int n = 1;
		
		int m = 2;
		
		System.out.println(n);
		
		add(n ,m);
	}

	 final static void add(int n, int m) {
		int a = n + m;
		System.out.println(a);
	}
}

