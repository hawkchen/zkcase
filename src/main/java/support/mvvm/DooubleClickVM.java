package support.mvvm;

import org.zkoss.bind.annotation.*;
import org.zkoss.zul.*;

public class DooubleClickVM extends InnerVM{

	long previous = 0;
	long current = 0;
	
	private String message;

	@Command
	public void cmd1() throws InterruptedException{
		System.out.println("cmd1 ");
		Thread.sleep(3000);
	}
	
	@Command
	public void checkCmd1(){
		previous = current;
		current = System.currentTimeMillis();
		if ((current-previous)>1000 ){
			System.out.println("check cmd1 "+(current-previous));
		}
	}
	
	@Command
	public void pop(@BindingParam("pop")Window win){
		//change window's content dynamically before showing
		win.setVisible(true);
	}
	
	@Command
	public void msg(){
		Messagebox.show("msg");
	}
	
	@Command 
	public void cmd2(){
		System.out.println("cmd2");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
