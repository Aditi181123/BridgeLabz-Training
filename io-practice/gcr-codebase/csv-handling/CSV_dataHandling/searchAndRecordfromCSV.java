package CSV_dataHandling;
import java.io.*;

public class searchAndRecordfromCSV {
	public static void main(String[] args) throws Exception {
		String file = "csvFile/employee.csv";
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			br.readLine();
			String line;
			while((line = br.readLine()) != null) {
				String[] col = line.split(",");
				if(col.length >= 4) {
					String name = col[1].replace("\"", "").trim();
					if(name.equalsIgnoreCase("Bob")) {
						System.out.println("Department: " + col[2].replace("\"", "").trim() 
								+ ", Salary: " + col[3].replace("\"", "").trim());
						break;
					}
					
				}
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
