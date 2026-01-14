package reflection;
import java.lang.reflect.*;

class Student{
	String name = "John";
	public boolean eligible(int age) {
		if(age >= 18) {
			return true;
		}
		return false;
	}

}
class Teacher{
	private String name;
	public Teacher(String name) {
		this.name = name;
	}
	public void display() {
		System.out.println("Teacher name: " + name);
	}
}
public class GetClassInformation {
	public static void main(String[] args) throws Exception {
		Student stud = new Student();
		// get class name
		Class<?> cls1 = stud.getClass();
		System.out.println("Class Name: " + cls1.getName());
		// get field name
		Field field = cls1.getDeclaredField("name");
		System.out.println("Feild: " + field.get(stud));
		// get method name
		Method method = cls1.getDeclaredMethod("eligible", int.class);
		boolean vote = (boolean)method.invoke(stud, 19);
		System.out.println("Eligible to vote " +vote);
		// get constructor
		Class<?> cls2 = Teacher.class;
		Constructor<?> cons = cls2.getConstructor(String.class);
		Teacher teac = (Teacher) cons.newInstance("Emma");
		teac.display();
	}
}
