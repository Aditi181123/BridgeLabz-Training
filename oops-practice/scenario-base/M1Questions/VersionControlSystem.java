package M1Questions;
import java.util.*;

public class VersionControlSystem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Solution1 sol  = new Solution1();
		int n = sc.nextInt();
		for(int i = 0 ; i < n ; i++) {
			String command = sc.next();
			String name = sc.next();
		
			if(command.equalsIgnoreCase("upload")) {
				String ver = sc.next();
				String s = sc.next();
				int size = Integer.parseInt(s);
				sol.upload(name,ver,size);
			}
			if(command.equalsIgnoreCase("fetch")) {
				sol.fetch(name);
			}
			if(command.equalsIgnoreCase("total_storage")){
				sol.total(name);
			}
			if(command.equalsIgnoreCase("latest")) {
				sol.latest(name);
			}
		}
	}
}

class Solution1{
	static class system{
		String ver;
		int stor;
		system(String n , int s){
			this.ver = n;
			this.stor = s;
		}
	}
	
	private Map<String , List<system>> storage = new HashMap<>();
	
	public void upload(String fname , String version , int size) {
		storage.putIfAbsent(fname, new ArrayList<>());
		List<system> list = storage.get(fname);
		
		for(system s : list) {
			if(s.ver.contains(version)) {
			}
		}
		list.add(new system(version, size));
	}
	
	public void fetch(String fname) {
		if(!storage.containsKey(fname)) {
			System.out.println("File Not Found");
			return;
		}
		List<system> list = new ArrayList<>(storage.get(fname));
		list.sort((a, b) -> {
		    if (a.stor != b.stor) {
		    	return a.stor - b.stor;
		    }
		    return a.ver.compareTo(b.ver);
		});
		
		for(system s : list) {
			System.out.println(fname + " " + s.ver + " " + s.stor);
		}
	}
	
	public void total(String fname) {
		if(!storage.containsKey(fname)) {
			System.out.println("File Not Found");
			
		}
		
		List<system> list = new ArrayList<>(storage.get(fname));
		
		int t = 0 ;
		
		for(system s : list) {
			t += s.stor;
		}
		
		System.out.println( fname + " " + t);
		
		
	}
	public void latest(String fname) {
		if(!storage.containsKey(fname) || storage.get(fname).isEmpty()) {
			System.out.println("File Not Found");
			
		}
		
		List<system> list = new ArrayList<>(storage.get(fname));
		
		system s = list.get(list.size() -1);
		System.out.println(fname + " " + s.ver + " "+ s.stor);
	}
}
