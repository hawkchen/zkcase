package support.component;


import java.util.*;
import java.util.Calendar;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;

public class DefaultTreeComposer extends SelectorComposer<Component> {
	
	@Wire
	Tree tree1;
	DefaultTreeModel<String> model ;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		List children = new LinkedList();
		children.add(new DefaultTreeNode("1st", new LinkedList()));
		DefaultTreeNode root = new DefaultTreeNode("root", children);
		model = new DefaultTreeModel<String>(root, true);
		tree1.setModel(model);
	}
	
	@Listen("onClick = #add")
	public void add() {
		List children = new LinkedList();
		DefaultTreeNode newNode = new DefaultTreeNode(Calendar.getInstance().getTime(),
				children);
		TreeNode parent = model.getSelection().iterator().next();
		parent.add(newNode);
	}
	
	@Listen("onClick = #del")
	public void del() {
		DefaultTreeNode selected = (DefaultTreeNode)model.getSelection().iterator().next();
		selected.removeFromParent();
	}
}
