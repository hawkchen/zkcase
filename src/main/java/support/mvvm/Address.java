package support.mvvm;

//import org.hibernate.validator.constraints.*;


public class Address{
	String businessName;
	
	//@Length(min=3)
	public String getBusinessName() {
		return businessName;
	}
	
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	
}