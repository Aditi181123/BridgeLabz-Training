package oopsBasics;

public class OnlineCourse {
	String Cname;
	double duration;
	double fee;
	static String Iname = "BridgeLabz";
	
	public static void main(String[]args) {
		
		OnlineCourse c1 = new OnlineCourse("dsa" , 2 , 2500 );
		OnlineCourse c2 = new OnlineCourse("design" , 5 , 5000);
		
		c1.display();
		c2.display();
		
		OnlineCourse.Update("GLA University");
		

		c1.display();
		c2.display();
		
	}

	
	OnlineCourse(String Cname , double duration , double fee){
		this.Cname = Cname;
		this.duration = duration;
		this.fee = fee;
	}
	
	void display() {
		System.out.println("Course Name : " + Cname);
		System.out.println("Course Duration (in months) : " + duration);
		System.out.println("Course fees : "+ fee);
		System.out.println("Institution Name : " + Iname);
	}
	
	static void Update(String name) {
		Iname = name;
	}
}
