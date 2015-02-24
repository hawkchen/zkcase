package support.component.tree;


import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.Tree;
import org.zkoss.zul.event.TreeDataEvent;


public class TreeAddComposer extends SelectorComposer<Component> {

	private MyTreeModel mymodel;
	private MyNode level2;

	@Wire
	Tree mytree;

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		//		Tree mytree = (Tree) getFellow("mytree");

		MyNode level1 = new MyNode("Level1");
		level2 = new MyNode("Level2");
		level2.children.add(new MyNode("Content1"));
		level2.children.add(new MyNode("Content2"));
		level1.children.add(level2);

		MyNode myroot = new MyNode("TreeRoot");
		myroot.children.add(level1);

		mymodel = new MyTreeModel(myroot);
		mytree.setModel(mymodel);
		mymodel.addOpenPath(new int[] {0});
		mymodel.addOpenPath(new int[] {0, 0});
	}

	@Listen("onClick = #mybtn")
	public void onTestInsert(){
		level2.children.add(new MyNode("Content added"));
		mymodel.fireEvent(TreeDataEvent.INTERVAL_ADDED, new int[] {0,0}, 2, 2);
//		mymodel.fireEvent(TreeDataEvent.CONTENTS_CHANGED, new int[] {0}, 0, 0);
//		mymodel.fireEvent(TreeDataEvent.CONTENTS_CHANGED, new int[] {}, 0, 0);
	}
	
	@Listen("onClick = #change")
	public void fireChanged(){
		mymodel.fireEvent(TreeDataEvent.CONTENTS_CHANGED, new int[] {0}, 0, 0);
		mymodel.fireEvent(TreeDataEvent.CONTENTS_CHANGED, new int[] {}, 0, 0);
	} 
}
