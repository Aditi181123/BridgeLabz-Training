package JUnit;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DataConnectionTest {
	DataConnection db = new DataConnection();
	
	@BeforeEach
	void setUp() {
		db.connect();
	}
	
	@AfterEach
	void tearDown() {
		db.disconnect();
	}
	
	@Test
	void testConnection() {
		assertTrue(db.isConnected());
	}
	
	@Test
	void testAgain() {
		assertTrue(db.isConnected());
	}
}
