package support.mvvm;

import org.zkoss.bind.annotation.*;

public class ChildVM extends InnerVM{

	
	
	@Init(superclass = true)
	public void init2(){
		value = "initialized";
		System.out.println("init2");
	}
	
	public void change(){
		System.out.println("another vm command ");
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
