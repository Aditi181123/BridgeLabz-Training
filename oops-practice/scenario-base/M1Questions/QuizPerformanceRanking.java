package M1Questions;
import java.util.*;

class Quiz{
	static class Performance{
		String sname;
		String dep;
		int q1;
		int q2;
		int q3;

		Performance(String sname , String dept , int q1, int q2, int q3){
			this.sname = sname;
			this.dep =dept;
			this.q1 = q1;
			this.q2 = q2;
			this.q3 = q3;
		}
	}

	List<Performance> list = new ArrayList<>();

	public void Record(String sname , String dept, int q1, int q2, int q3) {
		list.add(new Performance(sname , dept , q1, q2, q3));
		System.out.println("Record Added: " + sname);
	}

	public void TopDept(String dept) {
		if(list.isEmpty()) {
			System.out.println("No Records Found");
			return;
		}

		int max = 0;
		for(Performance p : list) {
			if(p.dep.equals(dept)) {
				int total = p.q1 + p.q2 + p.q3;
				if(total > max) {
					max = total;
				}
			}
		}

		if(max == 0) {
			System.out.println("Department Not Found");
			return;
		}

		for(Performance p : list) {
			int total = p.q1 + p.q2 + p.q3;
			if(p.dep.equals(dept) && total == max) {
				System.out.println(p.sname + " " + total);
			}
		}

	}

	public void ToQuiz(String quiz) {
		if(list.isEmpty()) {
			System.out.println("No Record Found");
			return;
		}

		int max = 0 ;

		for(Performance p : list) {
			if(quiz.equals("Q1")) {
				max = Math.max(max, p.q1);
			}
			if(quiz.equals("Q2")) {
				max = Math.max(max, p.q2);
			}
			if(quiz.equals("Q3")) {
				max = Math.max(max, p.q3);
			}
		}

		for(Performance p : list) {
			if(quiz.equals("Q1") && max == p.q1) {
				System.out.println(p.sname + " " + max);
			}
			if(quiz.equals("Q2") && max == p.q2) {
				System.out.println(p.sname + " " + max);
			}
			if(quiz.equals("Q3") && max == p.q3) {
				System.out.println(p.sname + " " + max);
			}
		}
	}
}

public class QuizPerformanceRanking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Quiz q = new Quiz();
		int n = sc.nextInt();
		for(int i = 0 ; i < n ; i++) {
			String com = sc.next();
			if(com.equalsIgnoreCase("Record")) {
				String name = sc.next();
				String dept = sc.next();
				int q1 = Integer.parseInt(sc.next());
				int q2 = Integer.parseInt(sc.next());
				int q3 = Integer.parseInt(sc.next());

				q.Record(name, dept, q1, q2, q3);
			}
			if(com.equalsIgnoreCase("Top")) {
				String top = sc.next();
				if(top.startsWith("Q")) {
					q.ToQuiz(top);
				}
				else {
					q.TopDept(top);
				}
			}
		}
	}

}
