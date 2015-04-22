package support.mvvm;

//import org.hibernate.validator.constraints.Length;
import org.zkoss.bind.*;
import org.zkoss.zk.ui.Component;

public class Site{
	String url = "www.tes.com";
	Address invoiceAddress;

	public Address getInvoiceAddress() {
		return invoiceAddress;
	}

	public void setInvoiceAddress(Address invoiceAddress) {
		this.invoiceAddress = invoiceAddress;
	}

	//@Length(min=5)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	

}