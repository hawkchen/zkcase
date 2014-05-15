package support.component;

import java.util.*;

import org.zkoss.bind.annotation.Init;

public class PopupVM {
	private String serviceFilterWorkspace;
	private String serviceFilterInvoice;
	private List<String> serviceWorkspace = new LinkedList<String>();
	private List<String> serviceInvoice = new LinkedList<String>();
	
	@Init
	public void init(){
		for (int i = 0; i<60 ;i ++){
			serviceWorkspace.add("Space "+i);
		}
		
		String[] invoice = {"invoice a", "invoice b","invoice c"};
		serviceInvoice.addAll(Arrays.asList(invoice));
	}
	
	public boolean getServiceManuel(){
		return true;
	}
	
	public void setServiceFilterWorkspace(String filter){
		this.serviceFilterWorkspace = filter;
	}
	
	public String getServiceFilterWorkspace(){
		return serviceFilterWorkspace;
	}
	
	public List<String> getServiceWorkspace(){
		return serviceWorkspace;
	}
	
	public List<String> getServiceInvoice(){
		return serviceInvoice;
	}
	
	public String getServiceFilterInvoice(){
		return serviceFilterInvoice;
	}
	
	public void setServiceFilterInvoice(String invoice){
		serviceFilterInvoice = invoice;
	}
}
