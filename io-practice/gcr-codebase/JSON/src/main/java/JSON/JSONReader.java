package JSON;
import com.fasterxml.jackson.databind.*;
import java.io.*;

class User {
    public String id;
    public String name;
    public String email;
    public String phone;
    public String city;
}

public class JSONReader {
	public static void main(String[] args) {
		try {
			ObjectMapper obj = new ObjectMapper();
			User user = obj.readValue(new File("src/main/resources/user.json"), User.class);
			System.out.println("User Name: " + user.name);
			System.out.println("User Email: " + user.email);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
