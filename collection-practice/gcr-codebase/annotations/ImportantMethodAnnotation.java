package annotations;
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod{
	String level() default "High";
}

class Task{
	@ImportantMethod(level = "Medium")
	public void Task1(){
		
	}
}

public class ImportantMethodAnnotation {
	public static void main(String[] args) throws Exception {
		Task task = new Task();
		Method mtd = task.getClass().getMethod("Task1");
		
		System.out.print(mtd.getName()+ ": ");
		ImportantMethod[] annotation = mtd.getAnnotationsByType(ImportantMethod.class);
		
		for(ImportantMethod ant : annotation) {
			System.out.println(ant.level());
		}
		
	}
}
