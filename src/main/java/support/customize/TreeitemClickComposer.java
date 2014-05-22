package support.customize;


import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.select.*;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.*;

public class TreeitemClickComposer extends SelectorComposer<Window> {
	
	@Wire
	Textbox txtbox;
	@Wire
	Tree tree;
	
	
	@Listen("onClick = treeitem")
	public void onClick(Event e) throws InterruptedException{
		txtbox.setValue(txtbox.getValue() + "\nClick");
	}  

	@Listen("onDoubleClick = treeitem")
	public void onDoubleClick(Event e) throws InterruptedException{
		txtbox.setValue(txtbox.getValue() + "\nDoubleClick");
	}
	
//	@Listen("onSelect = treeitem")
//	public void onSelect(Event e){
//		System.out.println("select");
//	}
//	
//	@Listen("onSelect = tree")
//	public void onSelectTree(SelectEvent e){
//		System.out.println(e.getKeys());
//		System.out.println("select tree");
//	}
}
