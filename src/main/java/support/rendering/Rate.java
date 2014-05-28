package support.rendering;


public class Rate {
	private String country;
	private String rate;
	private String countryISOCode = "flag";
	
	public Rate(String country, String rate) {
		this.country = country;
		this.rate = rate;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getCountryISOCode() {
		return countryISOCode;
	}
	public void setCountryISOCode(String countryISOCode) {
		this.countryISOCode = countryISOCode;
	}
}
