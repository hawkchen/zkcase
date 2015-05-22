package support.component.tree;

import java.util.*;

import org.zkoss.bind.annotation.*;
import org.zkoss.zul.event.TreeDataEvent;

public class TreeEventVM {

	private MyTreeModel model = new MyTreeModel(new MyNode("root"));
	private MyNode selectedItem;

	@Init
	public void init(){
		List<MyNode> children = model.getRoot().getChildren();
		MyNode node1 = new MyNode("node 1");
		node1.getChildren().add(new MyNode("node 1-1"));
		node1.getChildren().add(new MyNode("node 1-2"));
		children.add(node1);
		children.add(new MyNode("node 2"));
		children.add(new MyNode("node 3"));
	}
	
	@Command 
	// @NotifyChange("model") simple but cost more effort for it renders the whole tree again 
	public void add(){
		if (selectedItem != null){
			MyNode newChild = new MyNode(Calendar.getInstance().getTime().toString());
			selectedItem.getChildren().add(newChild);
			int index = selectedItem.getChildren().indexOf(newChild);
			//fire an event upon situations, please refer to TreeDataEvent for complete list of tree data events
			model.fireEvent(TreeDataEvent.INTERVAL_ADDED, model.getPath(selectedItem) , index, index);
			// no effect for no binding on root
			//		BindUtils.postNotifyChange(null, null, model.getRoot(), "*"); 
		}
	}



	public MyTreeModel getModel() {
		return model;
	}


	public void setModel(MyTreeModel model) {
		this.model = model;
	}

	public MyNode getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(MyNode selectedItem) {
		this.selectedItem = selectedItem;
	}
	
}

