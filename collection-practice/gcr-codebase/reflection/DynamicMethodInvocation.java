package reflection;
import java.lang.reflect.*;
import java.util.*;

class  MathOperations {
	public int add(int a , int b) {
		return a + b;
	}
	public int sub(int a , int b) {
		return a - b;
	}
	public int mult(int a, int b) {
		return a * b;
	}
	
}

public class DynamicMethodInvocation {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the method (add, sub, mult) than enter numbers:");
		String str = sc.next();
		int a = sc.nextInt();
		int b = sc.nextInt();
		MathOperations math = new  MathOperations();
		Class<?> cls = math.getClass();
		System.out.println("Class Name; " + cls.getName());
		
		Method meth = cls.getDeclaredMethod(str, int.class, int.class);
		int res = (int)meth.invoke(math, a, b);
		System.out.println("Result: " + res);
	}
}
