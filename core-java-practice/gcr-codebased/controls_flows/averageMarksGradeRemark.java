package controls_flows;
import java.util.Scanner;
public class averageMarksGradeRemark {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the marks of physics , chemistry and maths : ");
		int phy = sc.nextInt();
		int che = sc.nextInt();
		int math = sc.nextInt();
		int avg = (phy + che + math)/3;
		System.out.println("Average Marks : " + avg);
		if(avg >= 80) {
			System.out.println("Grade : A  \nLevel 4 , above agency-normalized standards .");
		}
		else if (avg >= 70 && avg < 80) {
			System.out.println("Grade : B \nLevel 3 , at agency normalized standards .");
		}
		else if (avg >= 60 && avg < 70) {
			System.out.println("Grade : C \nLevel 2 , below , but approching agency-normalized standards .");
		}
		else if(avg >= 50 && avg < 60) {
			System.out.println("Grade : D \nLevel 1 , well below agency-normalized standrads .");
		}
		else if(avg >= 40 && avg < 50) {
			System.out.println("Grade : E \nLevel 1- , too below agency-normalized standards .");
		}
		else {
			System.out.println("Grade : R \n( Remedial Standrads )");
		}
	}
}
