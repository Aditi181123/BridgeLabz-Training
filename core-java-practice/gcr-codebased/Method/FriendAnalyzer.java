package Method;

import java.util.Scanner;

public class FriendAnalyzer {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int[] age = new int[3];
	        double[] height = new double[3];
	        String[] name = {"Amar", "Akbar", "Anthony"};

	        for (int i = 0; i < 3; i++) {
	            age[i] = sc.nextInt();
	            height[i] = sc.nextDouble();
	        }

	        System.out.println("Youngest: " + name[findYoungest(age)]);
	        System.out.println("Tallest: " + name[findTallest(height)]);
	       

	    }
    public static int findYoungest(int[] ages) {
        int min = 0;
        for (int i = 1; i < ages.length; i++)
            if (ages[i] < ages[min]) min = i;
        return min;
    }

    public static int findTallest(double[] heights) {
        int max = 0;
        for (int i = 1; i < heights.length; i++)
            if (heights[i] > heights[max]) max = i;
        return max;
    }

   
}