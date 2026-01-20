package CSV_dataHandling;
import java.io.*;

public class writeFile {
	public static void main(String[] args) throws Exception{
		String file = "csvFile/employee.csv";
		try(BufferedWriter wr = new BufferedWriter(new FileWriter(file ))){
			wr.write("ID , Name , Department , Salary\n");
			wr.write("101, Alice, Finance    , 62000\n");
			wr.write("102, John , Management , 52000\n");
			wr.write("103, Bob  , Sales      , 42000\n");
			wr.write("104, Jack , Product    , 54000\n");
			wr.write("105, aditi, IT         , 30000\n");
			wr.write("106, neha , IT         , 12000\n");
		}
		try(BufferedReader br = new BufferedReader (new FileReader(file))){
			String line;
			while((line = br.readLine()) != null) {
				String[] col = line.split(",");
				if(col.length >= 2) {
					System.out.println("ID: " + col[0] + 
							", Name: " + col[1] +
							", Department: " + col[2] + 
							", Salary: "+col[3]);
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
