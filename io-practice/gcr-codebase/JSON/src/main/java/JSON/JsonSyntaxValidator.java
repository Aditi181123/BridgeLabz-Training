package JSON;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSyntaxValidator {
	
	public static void main(String[] args) {
		String json = "{ \"name\": \"Aditi\", \"age\": 22 }";
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			mapper.readTree(json);  
			System.out.println("true");
		} catch (Exception e) {
			System.out.println("false");
		}
	}
}
