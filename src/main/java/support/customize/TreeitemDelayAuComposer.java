package support.customize;


import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;

public class TreeitemDelayAuComposer extends SelectorComposer<Window> {
	
	@Wire
	Textbox txtbox;

	@Listen("onClick = treeitem")
	public void onClick(Event e) throws InterruptedException{
		txtbox.setValue(txtbox.getValue() + "\nClick");
	}  

	@Listen("onDoubleClick = treeitem")
	public void onDoubleClick(Event e) throws InterruptedException{
		txtbox.setValue(txtbox.getValue() + "\nDoubleClick");
	}
	
	@Listen("onSelect = treeitem")
	public void onSelect(Event e){
		System.out.println("select");
	}
	
	@Listen("onSelect = tree")
	public void onSelectTree(SelectEvent e){
		System.out.println(e.getKeys());
		System.out.println("select tree");
	}
}
