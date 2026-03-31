package JUnit;
//import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class NumberTest {
	Number para = new Number();
	
	@ParameterizedTest
	@ValueSource(ints = {2,4,6,7,9})
	void testeven(int num) {
		if (num % 2 == 0) {
            assertTrue(para.isEven(num));
        } else {
            assertFalse(para.isEven(num));
        }
		
//		assertTrue(num%2==0);
	}
}
