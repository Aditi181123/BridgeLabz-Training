package reflection;
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
 @interface Author{
	String Name() default "Author Name: ";
}
class AuthorName{
	@Author(Name = "Author Name")
	public void name() {
		
	}
}
public class RetrieveAnnotationsatRuntime {
	public static void main(String[] args) throws Exception{
		AuthorName an = new AuthorName();
		Method meth = an.getClass().getMethod("name");
		if(meth.isAnnotationPresent(Author.class)) {
			Author annotation = meth.getAnnotation(Author.class);
			String str = "S.T.Abby";
			System.out.println(annotation.Name()+": " + str );
		}
		
	}
}
