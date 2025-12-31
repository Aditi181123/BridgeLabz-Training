package scenario_base;

import java.util.*;

public class EmployeeWages {

    // Constants
    static final int parttime = 1;
    static final int fulltime = 2;
    static final int wages = 20;
    static final int fullhour = 8;
    static final int parthour = 4;
    static final int maxday = 20;
    static final int maxhour = 100;

    public static void main(String[] args) {

        System.out.println("Welcoming you on the Employee Wage Computation Program");

        Random random = new Random();

        int tworkingdays = 0;
        int tworkinghour = 0;
        int totalWage = 0;

        // UC 1 to UC 6
        while (tworkingdays < maxday && tworkinghour < maxhour) {

            tworkingdays++;
            int empCheck = random.nextInt(3);
            int empHours = 0;

            // UC 4: Switch Case
            switch (empCheck) {
                case fulltime:
                    empHours = fullhour;
                    System.out.println("\nDay " + tworkingdays + ": Employee is Full Time");
                    break;

                case parttime:
                    empHours = parthour;
                    System.out.println("\nDay " + tworkingdays + ": Employee is Part Time");
                    break;

                default:
                    empHours = 0;
                    System.out.println("\nDay " + tworkingdays + ": Employee is Absent");
            }

            tworkinghour += empHours;
            int dailyWage = empHours * wages;
            totalWage += dailyWage;

            System.out.println("Daily Wage: ₹" + dailyWage);
           
        }

        // UC 5 & UC 6 Result
        System.out.println("\nTotal Working Days: " + tworkingdays);
        System.out.println("Total Working Hours: " + tworkinghour);
        System.out.println("Total Monthly Wage: ₹" + totalWage);
    }
}