package strings;

public class NullPointerExceptionDemo {
	public static void main(String[] args) {
		System.out.println("Null Pointer Exception ");
		
		try {
			generate();
		}catch (NullPointerException e) {
			System.out.println("Null Pointer Exception generated : " + e.getMessage());
		}
		
		handle();
		
	}

	private static void handle() {
		// TODO Auto-generated method stub
		String str = null;
		
		try {
			System.out.println(str.length());
		}
		catch(NullPointerException e) {
			System.out.println("Null Pointer Exception Caught");
		}
		
	}

	private static void generate() {
		// TODO Auto-generated method stub
		String str = null;
		
		System.out.println(str.length());
		
	}
	
}
