package support.rod;

import java.util.*;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;

import support.rod.data.*;


public class ManualGroupComposer extends SelectorComposer<Component>{

	@Wire
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
    
    @Listen("onOpen = #listbox")
    public void insertItemsOfGroup(Event event){
    	String group = (String)event.getData();
    	int insertIndex = model.indexOf(group);
    	model.addAll(insertIndex+1, loadGroupsItems(group));
    }
    
    @Listen("onClose = #listbox")
    public void removeItemsOfGroup(Event event){
    	// remove items of a certain group
    	String group = (String)event.getData();
    	model.removeAll(FoodData.getFoodsByCategory(group));
    }

	private List<Food> loadGroupsItems(String group) {
		return FoodData.getFoodsByCategory(group);
	}
    
    
}