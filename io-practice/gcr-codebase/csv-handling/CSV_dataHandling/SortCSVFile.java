package CSV_dataHandling;
import java.io.*;
import java.util.*;

public class SortCSVFile {
	public static void main(String[] args) {
		String file = "csvFile/update_employee.csv";
		String header = null;
		List<String[]> record = new ArrayList<>();
		try(BufferedReader br = new BufferedReader (new FileReader(file))){
			header = br.readLine();
			String line;
			while((line = br.readLine()) != null) {
				String [] col = line.split(",");
				if(col.length >= 4) {
					record.add(col);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		for(int i = 0 ; i < record.size() ; i++) {
			int max = i;
			for(int j = i + 1 ; j < record.size() ; j++) {
				int maxS = Integer.parseInt(record.get(max)[3].replace("\"", "").trim());
				int curr = Integer.parseInt(record.get(j)[3].replace("\"", "").trim());

				if(curr > maxS) {
					max = j;
				}
			}
			String[] temp = record.get(i);
			record.set(i, record.get(max));
			record.set(max, temp);
		}
		
		try(BufferedWriter bw = new BufferedWriter (new FileWriter (file))){
			bw.write(header);
			bw.newLine();
			for(String[] col : record) {
				bw.write(col[0].replace("\"", "").trim() + "," 
			            + col[1].replace("\"", "").trim() + ","
						+ col[2].replace("\"", "").trim() 
						+ "," + col[3].replace("\"", "").trim());
				bw.newLine();
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
