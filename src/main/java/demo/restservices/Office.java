package demo.restservices;

public class Office {

	private String country;
	private String city;
	
	// Default constructor.
	public Office() {
	}

	// Full-blown constructor.
	public Office(String country, String city) {
		this.country = country;
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Office [city=" + city + ", country=" + country + "]";
	}
}
