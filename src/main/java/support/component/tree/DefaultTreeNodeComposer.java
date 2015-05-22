package support.component.tree;


import java.util.LinkedList;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;
import org.zkoss.zul.event.TreeDataEvent;


public class DefaultTreeNodeComposer extends SelectorComposer<Component> {

	private DefaultTreeModel<DefaultTreeNode<String>> mymodel;
	DefaultTreeNode level2;
	DefaultTreeNode level1 = new DefaultTreeNode<String>("Level1", new LinkedList<DefaultTreeNode<String>>());
	@Wire
	Tree mytree;

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		level2 = new DefaultTreeNode("Level2", new LinkedList<DefaultTreeNode<String>>());
		level2.add(new DefaultTreeNode("Content1"));
		level2.add(new DefaultTreeNode("Content2"));
		level1.add(level2);

		DefaultTreeNode myroot = new DefaultTreeNode("TreeRoot", new LinkedList<DefaultTreeNode<String>>());
		myroot.add(level1);

		mymodel = new DefaultTreeModel<DefaultTreeNode<String>>(myroot);
		mytree.setModel(mymodel);
		mymodel.addOpenPath(new int[] {0});
		mymodel.addOpenPath(new int[] {0, 0});
	}

	@Listen("onClick = #mybtn")
	public void onTestInsert(){
//		level2.add(new DefaultTreeNode("Content added"));
		level1.setData("4");
		level2.setData("3");
	} 
}
