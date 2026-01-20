package CSV_dataHandling;
import java.io.*;

public class readAndCountRows {
	public static void main(String[] args) throws Exception{
		String file = "csvFile/employee.csv";
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String line;
			int count = 0;
			while((line = br.readLine()) != null) {
				String[] col = line.split(",");
				if(col.length >= 2) {
					System.out.println("ID: " + col[0] + 
							", Name: " + col[1] +
							", Department: " + col[2] + 
							", Salary: "+col[3]);
				}
				count++;
			}
			System.out.println("Count: " + count);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
