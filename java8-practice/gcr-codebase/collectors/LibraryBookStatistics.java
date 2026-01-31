package collectors;
import java.util.*;
import java.util.stream.*;

class Book {
    String genre;
    int pages;

    Book(String genre, int pages) {
        this.genre = genre;
        this.pages = pages;
    }
}

public class LibraryBookStatistics {
    public static void main(String[] args) {

        List<Book> books = List.of(
                new Book("Fiction", 300),
                new Book("Fiction", 500),
                new Book("Science", 400)
        );

        Map<String, IntSummaryStatistics> stats =
                books.stream()
                        .collect(Collectors.groupingBy(
                                b -> b.genre,
                                Collectors.summarizingInt(b -> b.pages)
                        ));

        stats.forEach((genre, summary) -> {
            System.out.println(genre);
            System.out.println("Total Pages: " + summary.getSum());
            System.out.println("Average Pages: " + summary.getAverage());
            System.out.println("Max Pages: " + summary.getMax());
        });
    }
}
