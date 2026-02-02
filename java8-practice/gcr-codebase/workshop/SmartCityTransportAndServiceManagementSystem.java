package scenario;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.time.*;

public class SmartCityTransportAndServiceManagementSystem {

	@FunctionalInterface
	interface FareCalculator {
		double calculateFare(double distanceKm);
	}


	interface TransportService {
		default void printServiceDetails() {
			System.out.println( );
		}
	}

	interface GeoUtils {
		static double calculateDistance(double lat1, double lon1,
				double lat2, double lon2) {
			return 0;
		}
	}

	static class BusService implements TransportService {
		private final String route;
		private final double fare;
		private final LocalTime time;

		BusService(String route, double fare, LocalTime time) {
			this.route = route;
			this.fare = fare;
			this.time = time;
		}


	}

	static class MetroService implements TransportService {
		private final String route;
		private final double fare;
		private final LocalTime time;

		MetroService(String route, double fare, LocalTime time) {
			this.route = route;
			this.fare = fare;
			this.time = time;
		}


	}

	static class TaxiService implements TransportService {
		private final String route;
		private final double fare;
		private final LocalTime time;

		TaxiService(String route, double fare, LocalTime time) {
			this.route = route;
			this.fare = fare;
			this.time = time;
		}


	}


	public static void main(String[] args) {
	}
}
