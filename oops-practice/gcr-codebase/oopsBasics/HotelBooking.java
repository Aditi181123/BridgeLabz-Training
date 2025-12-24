package oopsBasics; 

public class HotelBooking{
	// Attributes
	String GName;
	String Rtype;
	int nights;
	
	// main method
	public static void main(String[] args) {
		// default constructor
		HotelBooking book1 = new HotelBooking();
		System.out.println("   Booking 1  ");
		book1.display();
		
		//  parameterized constructor
		HotelBooking book2 = new HotelBooking( "Aditi" , "Suite" , 4 );
		System.out.println("   Booking 2  ");
		book2.display();
		
		// copy constructor
		HotelBooking book3 = new HotelBooking(book2);
		System.out.println("   Bokking 3  ");
		book3.display();
		
	}
	
	// display Details
	void display() {
		System.out.println("Guest Name : " + GName);
		System.out.println("Room Type : " + Rtype);
		System.out.println("Number of nights : " + nights);
	}

	// default 
	HotelBooking(){
		GName = "Pooja";
		Rtype = "Single";
		nights = 2;
	}

    //  parameterized constructor
	HotelBooking(String GName, String Rtype, int nights) {
		// TODO Auto-generated constructor stub
		this.GName = GName;
		this.Rtype = Rtype;
		this.nights = nights;
	}

	HotelBooking(HotelBooking booking) {
		// TODO Auto-generated constructor stub
		this.GName = booking.GName;
		this.Rtype = booking.Rtype;
		this.nights = booking.nights;
	}
}
