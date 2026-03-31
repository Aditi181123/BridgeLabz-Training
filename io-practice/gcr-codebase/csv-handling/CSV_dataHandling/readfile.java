package CSV_dataHandling;
import java.io.*;

public class readfile {
	public static void main(String[] args) {
		String file = "csvFile/student.csv";
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String line;
			while((line = br.readLine()) != null) {
				String[] col = line.split(",");
				if(col.length >= 4) {
					System.out.println("ID: " + col[0] + 
							", Name: " + col[1] +
							", Age: " + col[2] + 
							", Marks: "+col[3]);
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
