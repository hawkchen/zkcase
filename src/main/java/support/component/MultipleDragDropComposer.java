package support.component;


import java.util.*;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.*;

public class MultipleDragDropComposer extends SelectorComposer<Component> {
	
	@Listen("onDrop =listbox")
	public void move(DropEvent  event) {
		Component dragged = event.getDragged();
		Component self = event.getTarget();
        if (self instanceof Listitem) {
        	Set selected = ((Listitem)dragged).getListbox().getSelectedItems();
        	for (Object component: selected){
            	self.getParent().insertBefore((Component)component, self);
        	}
        } else if (self instanceof Listbox){
        	Set selected = ((Listitem)dragged).getListbox().getSelectedItems();
        	for (Object component : selected.toArray()){
        		((Listbox)self).appendChild((Component)component);
        	}
        }
    }
}
