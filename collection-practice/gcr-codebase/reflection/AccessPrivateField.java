package reflection;
import java.lang.reflect.*;

class Person{
	private int age = 22;
}
public class AccessPrivateField {
	public static void main(String[] args) throws Exception {
		Person per = new Person();
		Class<?> cls = per.getClass();
		System.out.println(cls.getName());

		Field field = cls.getDeclaredField("age");
		field.setAccessible(true);
		
		System.out.println("Field name: " + field.get(per));
	}
}
