package JUnit;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {
	
	StringUtils str = new StringUtils();
	
	@Test
	@DisplayName("Reverse String")
	
	void testrev() {
		assertEquals("elosnoc" , str.reverse("console"));
	}
	
	@Test
	@DisplayName("Palindrome String")
	
	void testpalin() {
		assertEquals(true, str.isPalindrome("madam"));
	}
	
	@Test
	@DisplayName("Upercase String")
	
	void testupper() {
		assertEquals("TEST" , str.uppercase("Test"));
	}
}
