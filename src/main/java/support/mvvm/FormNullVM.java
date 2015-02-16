package support.mvvm;

import org.zkoss.bind.*;
import org.zkoss.bind.annotation.*;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.Component;



public class FormNullVM {
	Site site = new Site();
	boolean invoiceAddressEnabled;
	
	@Command
	public void save(){
		System.out.println(site.getInvoiceAddress()==null?"null":site.getInvoiceAddress().getBusinessName());
	}
	
	@Command
	public void toggleInvoiceAddress(@BindingParam("form") SimpleForm form){
		if (invoiceAddressEnabled){
			site.setInvoiceAddress(new Address());
		}else{
			site.setInvoiceAddress(null);
			//clear the cache in form object 
			form.getFieldNames().remove("invoiceAddress.businessName");
			form.getSaveFieldNames().remove("invoiceAddress.businessName");
			form.getLoadFieldNames().remove("invoiceAddress.businessName");
			form.getFieldNames().remove("businessName");
			form.getSaveFieldNames().remove("businessName");
			form.getLoadFieldNames().remove("businessName");
		}
	}
	
	public Validator getMyValidator(){
		return new AbstractValidator() {
			
			@Override
			public void validate(ValidationContext ctx) {
				if ("a".equals(ctx.getProperty().getValue().toString())){
					//success
				}else{
					addInvalidMessage(ctx, "not a");
				}
			}
		};
	}
	public Converter getNullConverter(){
		return new Converter() {

			@Override
			public Object coerceToUi(Object beanProp, Component component, BindContext ctx) {
				return beanProp;
			}

			@Override
			public Object coerceToBean(Object compAttr, Component component,
					BindContext ctx) {
				if ("save".equals(ctx.getCommandName())){
					SimpleForm form = (SimpleForm)ctx.getConverterArg("form");
					if ("".equals(compAttr)){ //no user input, clear to null
						site.setInvoiceAddress(null); // this will cause an exception
						//clear the cache in form object 
						form.getFieldNames().remove("invoiceAddress.businessName");
						form.getSaveFieldNames().remove("invoiceAddress.businessName");
						form.getLoadFieldNames().remove("invoiceAddress.businessName");
						
					}else{
						site.setInvoiceAddress(new Address());
					}
				}
				return compAttr;
			}
		};
	}
	
	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public boolean isInvoiceAddressEnabled() {
		return invoiceAddressEnabled;
	}

	public void setInvoiceAddressEnabled(boolean invoiceAddressEnabled) {
		this.invoiceAddressEnabled = invoiceAddressEnabled;
	}
}
