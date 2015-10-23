package support.mvvm;

import java.util.Calendar;

import org.zkoss.bind.annotation.*;

public class MainModuleVM{

	private ModuleVM[] modules = new ModuleVM[3];
	
	@Init
	public void init(){
		modules[0] = new ModuleVM(1);
		modules[1] = new ModuleVM(2);
		modules[2] = new ModuleVM(3);
	}

	public ModuleVM[] getModules() {
		return modules;
	}

	public void setModules(ModuleVM[] modules) {
		this.modules = modules;
	}
}
