package support.component;


import java.util.*;
import java.util.Calendar;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;

public class TreeComposer extends SelectorComposer<Component> {
	
	@Wire
	Tree tree1;
	MyTreeModel model;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		List children = new LinkedList();
		children.add(new DefaultTreeNode("1st", new LinkedList()));
		DefaultTreeNode root = new DefaultTreeNode("root", children);
		initEmptyAsLeaf(root);
	}
	
	
	public void init(DefaultTreeNode root) {
		model = new support.component.MyTreeModel(root);
		tree1.setModel(model);
	}
	
	public void initEmptyAsLeaf(DefaultTreeNode root) {
		model = new support.component.MyTreeModel(root, true);
		tree1.setModel(model);
	}

	@Listen("onClick = #add")
	public void add() {
		List children = new LinkedList();
		DefaultTreeNode node = new DefaultTreeNode(Calendar.getInstance().getTime(),
				children);
		DefaultTreeNode parent = model.getSelection().iterator().next();
		int index = parent.getChildCount(); // before add a node
		parent.add(node);
		//fire yourself because DefaultTreeModel only fire events for DefaultTreeModel
		model.fireEvent(org.zkoss.zul.event.TreeDataEvent.INTERVAL_ADDED,
				model.getPath(parent), index, index);
	}
}
