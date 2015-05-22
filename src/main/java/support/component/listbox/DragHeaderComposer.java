package support.component.listbox;


import java.util.*;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.DropEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;

public class DragHeaderComposer extends SelectorComposer<Component> {
	
	

	@Wire
	Listbox dragBox;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		String[] headerOrder = {"name", "type","address"};
		dragBox.setAttribute("headerOrder", headerOrder);
		dragBox.setModel(new ListModelList<Locale>(Locale.getAvailableLocales())); //sample data
	}
	
	 @Listen("onDrop = listheader")
     public void onDroplHead(DropEvent ev) {

            // get the dragged Listheader and the one it is dropped on.
            Listheader dragged = (Listheader) ev.getDragged();
            Listheader droppedOn = (Listheader) ev.getTarget();

            Listbox listbox = droppedOn.getListbox();
            Listhead listhead = listbox.getListhead();

            // then get their indexes.
            int from = listhead.getChildren().indexOf(dragged);
            int to = listhead.getChildren().indexOf(droppedOn);

            // swap listheaders
            Listheader[] listHeaders = listhead.getChildren().toArray(new Listheader[0]);
            listHeaders = swap(listHeaders, from, to);
            listhead.getChildren().clear();
            listhead.getChildren().addAll(Arrays.asList(listHeaders));
//            listhead.insertBefore(dragged, droppedOn);
            
            String[] headerOrder = (String[])dragBox.getAttribute("headerOrder");
            headerOrder = swap(headerOrder, from, to);
            dragBox.setAttribute("headerOrder", headerOrder);
            // swap related Listcell in all Listitem instances
            for (Listitem item : listbox.getItems()) {
            	Component[] cells = item.getChildren().toArray(new Component[0]);
            	if (cells.length > from && cells.length> to) {
	                 cells = swap(cells, from, to);
	                 item.getChildren().clear();
	                 item.getChildren().addAll(Arrays.asList(cells));
            	}
            }            
            
	 }
	 
	 private <T> T[] swap(T[] objects, int index1, int index2){
		  T temp = objects[index1];
		  objects[index1] = objects[index2];
		  objects[index2] = temp;
		  
		  return objects;
	 }
	 
}
