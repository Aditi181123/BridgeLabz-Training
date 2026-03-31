package streamsAPI;
import java.util.*;
import java.util.stream.*;

class Movies{
	String name;
	float rate;
	int year;
	public Movies(String name, float rate , int year) {
		this.name = name;
		this.rate = rate;
		this.year = year;
	}
}

public class TrendingMovies {
	public static void main(String[] args) {
		
		 List<Movies> movie = List.of(
	                new Movies("Inception", 4.8f, 2010),
	                new Movies("Skyfall", 4.5f, 2023),
	                new Movies("The Rip", 4.5f, 2025)
	        );
		
		 List<Movies> top5 = movie.stream().filter(m -> m.rate > 3.5)
				 .sorted(Comparator.comparing((Movies m) -> m.rate).reversed()
						 .thenComparing(m -> m.year , Comparator.reverseOrder()))
						 .limit(5).collect(Collectors.toList());
	
		  top5.forEach(m ->
          System.out.println(m.name + " | " + m.rate + " | " + m.year)
  );
	}
}
