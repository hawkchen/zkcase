package support.mvvm;

import java.util.Calendar;

import org.zkoss.bind.annotation.*;

public class ModuleVM{

	private String value="init";
	private int index = 0;
	
	public ModuleVM() {
	}
	
	public ModuleVM(int index){
		this.index = index;
	}
	
	@Command @NotifyChange("value")
 	public void mycmd(){
		value = Calendar.getInstance().getTime().toString();
	}
	
	@GlobalCommand @NotifyChange("value")
	public void refresh(@BindingParam("key")String data){
		value = "refresh, key "+ data;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
}
