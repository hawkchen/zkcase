package support.rod;

import java.util.*;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.*;

import support.rod.data.*;


public class ManualGroupForwardComposer extends GenericForwardComposer<Component>{

	Listbox listbox;
	
    private ListModelList<Food> model = new ListModelList<Food>();

    @Override
    public void doAfterCompose(Component comp) throws Exception {
    	super.doAfterCompose(comp);
    	model.addAll(loadGroups());
    	listbox.setModel(model);
    }
    
    private List loadGroups(){
    	//query database to get group list
    	
    	return Arrays.asList(FoodData.CATEGORY);
    }
    
    public void onOpen$listbox(ForwardEvent event){
    	String group = (String)event.getOrigin().getData();
    	int insertIndex = model.indexOf(group);
    	model.addAll(insertIndex+1, loadGroupsItems(group));
    }
    
    public void onClose$listbox(ForwardEvent event){
    	// remove items of a certain group
    	String group = (String)event.getOrigin().getData();
    	model.removeAll(FoodData.getFoodsByCategory(group));
    }

	private List<Food> loadGroupsItems(String group) {
		return FoodData.getFoodsByCategory(group);
	}
	
    
}