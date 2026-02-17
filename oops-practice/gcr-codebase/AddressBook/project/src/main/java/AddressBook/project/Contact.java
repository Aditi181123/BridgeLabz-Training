package AddressBook.project;

//list of Person Details 

public class Contact {

	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	String pincode;
	String phoneNumber;
	String email;

	Contact(String firstName, String lastName, String address,
			String city, String state, String zip,
			String phoneNumber, String email) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String  phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return getFullName() +
				", " + address +
				", " + city +
				", " + state +
				" - " + pincode +
				", Phone: " + phoneNumber +
				", Email: " + email;
	}

	public String getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}

	public String toFileString() {
        return firstName + "," + lastName + "," + address + "," + city + "," +
               state + "," + pincode + "," + phoneNumber + "," + email;
    }

    public static Contact fromFileString(String line) {
        String[] data = line.split(",");
        return new Contact(data[0], data[1], data[2], data[3], data[4],
                           data[5], data[6], data[7]);
    }

}

