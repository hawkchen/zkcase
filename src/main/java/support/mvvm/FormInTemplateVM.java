package support.mvvm;

import java.util.*;

import org.zkoss.bind.*;
import org.zkoss.bind.annotation.*;
import org.zkoss.bind.validator.AbstractValidator;


public class FormInTemplateVM {
	
	RiskSection selectedRiskSection;
	List<RiskSection> riskSectionList = new LinkedList<FormInTemplateVM.RiskSection>();
	
	@Init
	public void init(){
		RiskSection r1 = new RiskSection();
		r1.setTitle("risk secion 1");
		r1.setRiskSectionRiskCode(new RiskSectionRiskCode(1, 11));
		
		RiskSection r2 = new RiskSection();
		r2.setTitle("risk secion 2");
		r2.setRiskSectionRiskCode(new RiskSectionRiskCode(2, 22));
		
		riskSectionList.add(r1);
		riskSectionList.add(r2);
		selectedRiskSection = r1;
	}
	
	@Command
	public void updateRiskSectionRiskCode(@BindingParam("riskSection") RiskSection riskSection){
		System.out.println("risk code value: "+riskSection.getRiskSectionRiskCode().getValue());
		/*
		riskSection.getRiskSectionRiskCodeList().add(riskSection.getRiskSectionRiskCode());
		riskSection.setSelectedRiskSectionRiskCode(riskSection.getRiskSectionRiskCode());
		this.modified = true;

		int index = this.risk.getRiskSectionList().indexOf(riskSection);
		if (index == -1) {
			this.risk.getRiskSectionList().add(riskSection);
		} else {
			this.risk.getRiskSectionList().set(index, riskSection);
		}

		if (close) {
			this.newRiskSectionRiskCode(riskSection);
			riskSection.setShowRiskSectionRiskCodeForm(false);
		} else {
			this.newRiskSectionRiskCode(riskSection);
		}

		BindUtils.postNotifyChange(null, null, risk.getRiskSectionList().get(index), "showRiskSectionRiskCodeForm");
		BindUtils.postNotifyChange(null, null, risk.getRiskSectionList().get(index), "riskSectionRiskCode");
		BindUtils.postNotifyChange(null, null, risk.getRiskSectionList().get(index), "riskSectionRiskCodeList");	
		*/
	}
	
	@Command
	public void select(@BindingParam("selected") RiskSection riskSection){
		setSelectedRiskSection(riskSection);
	}
	
	
	static public class RiskSection{
		String title;
		RiskSectionRiskCode riskSectionRiskCode;
		Validator riskSectionRiskCodeValidator = new AbstractValidator() {
	        public void validate(ValidationContext ctx) {
	        	Boolean enable =(Boolean)ctx.getBindContext().getValidatorArg("enable");
	        	if(enable){
	        		Map<String,Property> beanProps = ctx.getProperties(ctx.getProperty().getBase());
	        		Integer value = (Integer)ctx.getProperty().getValue();;
	        		if(value<10 || value>100){
	        			addInvalidMessage(ctx, "value must not < 10 or > 100, but is "+value);
	        		}
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

		public RiskSectionRiskCode getRiskSectionRiskCode() {
			return riskSectionRiskCode;
		}

		public void setRiskSectionRiskCode(RiskSectionRiskCode riskSectionRiskCode) {
			this.riskSectionRiskCode = riskSectionRiskCode;
		}
		
	}
	
	static public class RiskSectionRiskCode{
		private int id;
		private int value;

		public RiskSectionRiskCode(int id, int value) {
			this.id = id;
			this.value = value;
		}
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
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
