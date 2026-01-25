package JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class ListToJsonArray {

 
    static class Student {
        private int id;
        private String name;

        
        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

       
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) throws Exception {
 
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Aditi"));
        students.add(new Student(2, "Rahul"));
        students.add(new Student(3, "Neha"));
 
        ObjectMapper mapper = new ObjectMapper();
        String jsonArray = mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(students);
 
        System.out.println(jsonArray);
    }
}
