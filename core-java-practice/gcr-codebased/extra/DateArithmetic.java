package extra;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateArithmetic {

    static LocalDate calculateDate(LocalDate date) {
        date = date.plusDays(7);
        date = date.plusMonths(1);
        date = date.plusYears(2);
        date = date.minusWeeks(3);
        return date;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter date in format dd-MM-yyyy");
        String input = sc.nextLine();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(input, format);

        LocalDate result = calculateDate(date);

        System.out.println("Final Date : " + result.format(format));
    }
}
