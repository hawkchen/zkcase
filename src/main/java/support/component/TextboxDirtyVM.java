package support.component;

import org.zkoss.bind.annotation.*;

public class TextboxDirtyVM {

	private String originalValue = "init"; //this value might come from data model object
	private String value;
	private String statusStyle = "";
	
	@Init
	public void init(){
		value = originalValue;
	}
	
	@Command @NotifyChange("statusStyle")
	public void dirtyCheck(){
		if (originalValue.equals(value)){
			statusStyle = "";
		}else{
			statusStyle = "dirty";
		}
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getStatusStyle() {
		return statusStyle;
	}

	public void setStatusStyle(String statusStyle) {
		this.statusStyle = statusStyle;
	}
	
}
