package support.mvvm;

import org.zkoss.bind.annotation.*;

public class InnerVM {
	protected String value ="";
	
	@Init
	public void init(){
		value = "initialized";
		System.out.println("inner init ");
	}
	
	@Command
	public void myCommand(){
		change();
		class Test{
			
		}
	}
	
	public void change(){
		System.out.println("my command ");
	}
}
