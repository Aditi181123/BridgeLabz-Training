package scenario_base;
import java.util.*;

class CreatorStats{
	private String CreatorName;
	private double[] weeklyLikes;
	public String getCreatorName() {
		return CreatorName;
	}
	public void setCreatorName(String creatorName) {
		CreatorName = creatorName;
	}
	public double[] getWeeklyLikes() {
		return weeklyLikes;
	}
	public void setWeeklyLikes(double[] weeklyLikes) {
		this.weeklyLikes = weeklyLikes;
	}
}

public class StreamBuzz {
	public static List<CreatorStats> EngagementBoard = new ArrayList<>();
	
	public static void main(String[] args) {
		
		StreamBuzz buzz = new StreamBuzz();
		
		Scanner sc = new Scanner(System.in);
		int ch;
		while(true){
			System.out.println("1. Register Creator");
			System.out.println("2. Show Top Posts");
			System.out.println("3. Calculate Average Likes");
			System.out.println("4. Exit");
			System.out.println("Enter your choice: ");
			
			ch = sc.nextInt();
			if(ch == 4) {
				System.out.println("Logging off - Keep Creating with StreamBuzz!");
				break;
			}
			switch(ch) {
			case 1 : 
				System.out.println("Enter Creator Name:");
				String name = sc.next();
				System.out.println("Enter weekly likes (Week 1 to 4): ");
				double [] likes = new double[4];
				for(int i = 0 ; i < 4 ; i++) {
					likes[i] = sc.nextDouble();				
				}
				CreatorStats stats = new CreatorStats();
				
				stats.setCreatorName(name);
				stats.setWeeklyLikes(likes);
				
				buzz.RegisterCreator(stats);
				
				System.out.println("Creator registered successfully \n");
				break;
			case 2 :
				System.out.println("Enter like threshold:");
				double like = sc.nextDouble();
				
				Dictionary<String , Integer> top = buzz.GetTopPostCounts(EngagementBoard, like);
						
				if(top.isEmpty()) {
					System.out.println("No top-performing posts this week \n");
				}
				else {
					for(Map.Entry<String, Integer> entry : ((Hashtable<String , Integer>)top).entrySet() ) {
						System.out.println(entry.getKey() + " - " + entry.getValue());
					}
					System.out.println();
				}
				break;
			case 3 :
				double avg = buzz.CalculateAverageLikes();
				System.out.print("Overall average weekly likes: " + avg + "\n");
				System.out.println();
				break;
			default:
                System.out.println("Invalid choice. \n");
			}
		}
		
	}
	public void RegisterCreator(CreatorStats record) {
		EngagementBoard.add(record);
	}

	public Dictionary< String , Integer> GetTopPostCounts(List < CreatorStats > record, double likeThreshold){
		Dictionary <String , Integer> result = new Hashtable<>();

		for(CreatorStats cs : record) {
			int count = 0 ;
			for(double likes : cs.getWeeklyLikes()) {
				if(likes >= likeThreshold) {
					count++;
				}
			}
			if(count > 0) {
				result.put(cs.getCreatorName(), count);
			}
		}
		return result;
	}

	public double CalculateAverageLikes() {
		double sum = 0;
		double count = 0 ;
		
		for(CreatorStats cs : EngagementBoard) {
			for(double likes : cs.getWeeklyLikes()) {
				sum += likes;
				count++;
			}
		}
		if(count == 0) {
			return 0 ;
		}
		else {
			return sum / count;
		}

	}
}
