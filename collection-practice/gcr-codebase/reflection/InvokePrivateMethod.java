package reflection;
import java.lang.reflect.*;

class Calculator{
	private int multiply(int a , int b) {
		return a * b;
	}
}

public class InvokePrivateMethod {
	public static void main(String[] args) throws Exception {
		Calculator calc = new Calculator();
		Class<?> cls = calc.getClass();
		System.out.println("Class Name: "+ cls.getName());
		
		Method meth = cls.getDeclaredMethod("multiply", int.class, int.class);
		meth.setAccessible(true);
		int mul = (int)meth.invoke(calc, 5 , 8);
		System.out.println("Multiplication : " + mul);
	}
}
