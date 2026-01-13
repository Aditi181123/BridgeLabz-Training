package JUnit;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {
	private Calculator calc = new Calculator();
	
//	@BeforeEach
//	
//	void setup(){
//		calc = new Calculator();
//	}
//	
	@Test
	@DisplayName("Test Addition")
	
	void testadd() {
		assertEquals(5, calc.add(2,3));
	}
	
	@Test
	@DisplayName("Test Subtraction")
	
	void testsub() {
		assertEquals(5 , calc.sub(19, 14));
	}
	
	@Test
	@DisplayName("Test Multiplication")
	
	void testmullti() {
		assertEquals(6, calc.multi(2, 3));
	}
	
	@Test
	@DisplayName("Test Division")
	
	void testdiv() {
		assertEquals(2, calc.divide(6, 3));
	}
	
	@Test
	@DisplayName("Test Division  by zero")
	
	void testdivbyzero() {
		assertThrows(ArithmeticException.class, () -> calc.divide(6, 0));
	}
}
