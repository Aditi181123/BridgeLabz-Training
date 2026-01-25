package JSON;
import org.json.*;

public class CreateStudentJSONObject {
	public static void main(String[] args) {
		JSONArray arr = new JSONArray();
		arr.put("Java");
		arr.put("Math");
		
		JSONObject obj = new JSONObject();
		obj.put("name" ,"Aditi");
		obj.put("age", 21);
		
		
		obj.put("subjects", arr);
		
		System.out.println(obj.toString());

	}
}
