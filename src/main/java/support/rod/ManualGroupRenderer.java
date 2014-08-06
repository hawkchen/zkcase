package support.rod;

import org.zkoss.zk.ui.event.*;
import org.zkoss.zul.*;

import support.rod.data.*;

public class ManualGroupRenderer implements ListitemRenderer<Object> {

	@Override
	public void render(final Listitem listitem,final Object obj, int index) throws Exception {
		
		if (isGroup(obj)){
			final String group = (String)obj;
			listitem.setZclass("my-group");
			Listcell listcell = new Listcell();
			Label groupIcon = new Label();
			groupIcon.setZclass("z-icon-angle-right");
			listcell.appendChild(groupIcon);
			listcell.appendChild(new Label(obj.toString()));
			listitem.appendChild(listcell);
			final Listbox listbox = listitem.getListbox();
			listitem.addEventListener("onClick", new EventListener<Event>() {
				public void onEvent(Event event) throws Exception {
					if (listitem.getAttribute("status")==null || "close".equals(listitem.getAttribute("status")) ){
						Events.sendEvent(new Event("onOpen", listbox, group));
						listitem.setAttribute("status", "open");
					}else{
						Events.sendEvent(new Event("onClose", listbox, group));
						listitem.setAttribute("status", "close");
					}
				};
			});
			
		}else{
			Food food = (Food)obj;
			listitem.appendChild(new Listcell(food.getName()));
		}

	}

	private boolean isGroup(Object data) {
		// TODO determine a group according to your data or environment
		return data instanceof String;
	}

}
