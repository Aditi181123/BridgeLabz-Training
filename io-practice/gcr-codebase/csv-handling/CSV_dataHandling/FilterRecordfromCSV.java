package CSV_dataHandling;
import java.io.*;

public class FilterRecordfromCSV {
	public static void main(String[] args) {
		String file = "csvFile/student.csv";
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			br.readLine();
			String line ;
			while((line = br.readLine())!= null) {
				String [] col = line.split(",");
				if(col.length >= 4) {
					int marks = Integer.parseInt(col[3].replace("\"", "").trim());

					if(marks >= 80) {
						System.out.println("ID: " + col[0].replace("\"", "").trim() + 
								", Name: " + col[1].replace("\"", "").trim() +
								", Age: " + col[2].replace("\"", "").trim() + 
								", Marks: "+ marks);
					}
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}
}

