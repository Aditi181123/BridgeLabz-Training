package JUnit;

public class Calculator {
	
	// addition
	public int add(int a , int b) {
		return a + b ;
	}
	
	// Subtraction
	public int sub(int a , int b ) {
		return a - b ;
	}
	
	// multiplication
	public int multi(int a , int b ) {
		return a*b;
	}
	
	// division
	public int divide(int a , int b) {
		if(b == 0) {
			throw new ArithmeticException("Can not divide by zero");
		}
		return a / b;
	}
}
