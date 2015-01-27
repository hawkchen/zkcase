package support.mvvm;

import org.zkoss.bind.annotation.*;

public class DooubleClickVM extends InnerVM{

	long previous = 0;
	long current = 0;
	
	@Command
	public void cmd1(){
		previous = current;
		current = System.currentTimeMillis();
		if ((current-previous)>1000){
			System.out.println("cmd1 "+(current-previous));
		}
	}
	
	@Command
	public void cmd2(){
		System.out.println("cmd2");
	}
}
