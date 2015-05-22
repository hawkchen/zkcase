package support.mvvm;

import java.util.*;

import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;

public class InitVM {

	Map<String,Object> myargs = new HashMap<String,Object>();
	
	@Init
	public void init(){
		myargs.put("init", "init");
	}

	@Command
	public void newRisk(){

		myargs.put("test", "test");
		Window riskModalWindow = (Window) Executions.createComponents("riskModal.zul", null, myargs);
		riskModalWindow.doModal();

	}

	public Map<String, Object> getMyargs() {
		return myargs;
	}

	public void setMyargs(Map<String, Object> args) {
		this.myargs = args;
	}
}
