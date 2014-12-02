package support.mvvm;

import java.util.*;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Listbox;

public class EventCommand {
	private List<String> model = Arrays.asList("A", "B", "C");
	private String selectedEntry;

	
	/*
	@Wire
    Listbox lb;
 
    @AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);
        lb.addForward("onSelect", view, "onSelectEntry");
    }
    */
    
    
	public List<String> getModel() {
		return model;
	}

	@GlobalCommand
	public void entrySelected(@BindingParam("selectedEntry") String entry) {
//		Messagebox.show("Passed Command Param: " + entry + "\nBound selection: " + selectedEntry);
		System.out.println("Passed Command Param: " + entry + ", Bound selection: " + selectedEntry);
	}
	
	@Command
	public void entrySelected2() {
		System.out.println("current selection: " + selectedEntry);
	}
	
	@Command
	public void globalSelected() {
		HashMap<String, Object> args = new HashMap<String, Object>();
		args.put("selectedEntry", selectedEntry);
		BindUtils.postGlobalCommand(null, null, "entrySelected", args);
	}

	public String getSelectedEntry() {
		System.out.println("getSelectedEntry");
		return selectedEntry;
	}

	public void setSelectedEntry(String selectedEntry) {
		this.selectedEntry = selectedEntry;
		System.out.println("setSelectedEntry");
	}
}
