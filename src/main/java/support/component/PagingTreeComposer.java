package support.component;


import java.util.ArrayList;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.*;

public class PagingTreeComposer extends SelectorComposer<Component> {

	@Wire("tree")
	Tree tree;
	
	TreeModel model;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		model = new support.component.BinaryTreeModel<Integer>(new ArrayList<Integer>(
				new support.component.BigList(1000)));
		tree.setModel(model);
	}
	
	public void deleteFirstNode(){
//		tree.getSelectedItem().getValue()
	}
}
