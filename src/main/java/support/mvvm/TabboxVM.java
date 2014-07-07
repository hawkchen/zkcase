package support.mvvm;

import java.util.*;

import org.zkoss.bind.*;
import org.zkoss.bind.annotation.*;
import org.zkoss.bind.validator.AbstractValidator;


public class TabboxVM {
	
	RiskSection selectedRiskSection;
	List<RiskSection> riskSectionList = new LinkedList<TabboxVM.RiskSection>();
	
	@Init
	public void init(){
		RiskSection r1 = new RiskSection();
		r1.setTitle("risk secion 1");
		r1.setRiskSectionRiskCode(11);
		
		RiskSection r2 = new RiskSection();
		r2.setTitle("risk secion 2");
		r2.setRiskSectionRiskCode(22);
		
		riskSectionList.add(r1);
		riskSectionList.add(r2);
		selectedRiskSection = r1;
	}
	
	@Command
	public void updateRiskSectionRiskCode(@BindingParam("riskSection") RiskSection riskSection){
		System.out.println("risk code: "+riskSection.getRiskSectionRiskCode());
	}
	
	
	static public class RiskSection{
		String title;
		Integer riskSectionRiskCode;
		Validator riskSectionRiskCodeValidator = new AbstractValidator() {
	        public void validate(ValidationContext ctx) {
	        	 Map<String,Property> beanProps = ctx.getProperties(ctx.getProperty().getBase());
	             Integer code = (Integer)beanProps.get("riskSectionRiskCode").getValue();
	            if(code<10 || code>100){
	                addInvalidMessage(ctx, "value must not < 10 or > 100, but is "+code);
	            }
	        }
	    };
	    
		boolean showRiskSectionRiskCodeForm = true;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}


		public Validator getRiskSectionRiskCodeValidator() {
			return riskSectionRiskCodeValidator;
		}

		public void setRiskSectionRiskCodeValidator(Validator riskSectionRiskCodeValidator) {
			this.riskSectionRiskCodeValidator = riskSectionRiskCodeValidator;
		}

		public boolean isShowRiskSectionRiskCodeForm() {
			return showRiskSectionRiskCodeForm;
		}

		public void setShowRiskSectionRiskCodeForm(boolean showRiskSectionRiskCodeForm) {
			this.showRiskSectionRiskCodeForm = showRiskSectionRiskCodeForm;
		}

		public Integer getRiskSectionRiskCode() {
			return riskSectionRiskCode;
		}

		public void setRiskSectionRiskCode(Integer riskSectionRiskCode) {
			this.riskSectionRiskCode = riskSectionRiskCode;
		}
		
	}

	public RiskSection getSelectedRiskSection() {
		return selectedRiskSection;
	}

	public void setSelectedRiskSection(RiskSection selectedRiskSection) {
		this.selectedRiskSection = selectedRiskSection;
	}


	public List<RiskSection> getRiskSectionList() {
		return riskSectionList;
	}

	public void setRiskSectionList(List<RiskSection> riskSectionList) {
		this.riskSectionList = riskSectionList;
	}
}
