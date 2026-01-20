package CSV_dataHandling;
import java.io.*;

public class modifycsvFile {
	public static void main(String[] args) {
		String file1 = "csvFile/employee.csv";
		String file2 = "csvFile/update_employee.csv";
		try(BufferedReader br = new BufferedReader(new FileReader(file1));
			BufferedWriter bw = new BufferedWriter(new FileWriter(file2))
		){
			String line;
			br.readLine();
			bw.write("id , name , department , salary\n");
			while((line = br.readLine()) != null) {
				String[] col = line.split(",");
				if(col.length >= 4) {
					String id = col[0].replace("\"", "").trim();
					String name = col[1].replace("\"", "").trim();
					String dept = col[2].replace("\"", "").trim();
					int salary = Integer.parseInt(col[3].replace("\"", "").trim());
					
					if(dept.equalsIgnoreCase("IT")) {
						salary = (int)(salary + (salary * 10 /100));
					}
					
					bw.write(id + ", " + name + ", " + dept + ", " + salary );
					bw.newLine();
				}
				System.out.println("Updated...");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
