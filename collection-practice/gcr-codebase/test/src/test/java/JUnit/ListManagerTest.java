package JUnit;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ListManagerTest {
	ListManager lm = new ListManager();
	List<Integer> list = new ArrayList<>();
	
	@Test
	void testadd() {
		lm.addElement(list, 52);
		lm.addElement(list, 48);
		assertTrue(list.contains(48));
		assertEquals(2 , lm.getSize(list));
	}
	
	@Test
	void testremove() {
		lm.addElement(list, 42);
		lm.addElement(list, 52);
		lm.removeElemnet(list, 52);
		assertFalse(list.contains(52));
		assertEquals(1,lm.getSize(list));
	}
}
