package JSON;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmailValidation {

    public static void main(String[] args) throws Exception {

        String json = """
        {
          "email": "aditi.mittal@example.com"
        }
        """;

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(json);
 
        if (!node.has("email")) {
            System.out.println("Email field missing ");
            return;
        }

        String email = node.get("email").asText();
 
        boolean isValid = email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

        if (isValid) {
            System.out.println("Valid email ");
        } else {
            System.out.println("Invalid email ");
        }
    }
}
