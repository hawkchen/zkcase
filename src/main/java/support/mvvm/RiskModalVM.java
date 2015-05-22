package support.mvvm;

import java.util.Map;

import org.zkoss.bind.annotation.*;

public class RiskModalVM{


	@Init
	public void init(@BindingParam("args") Map<String, Object> args, @BindingParam("args2") String args2) {

		System.out.println("args:"+args);
		System.out.println("args2:"+args2);
	}
}
