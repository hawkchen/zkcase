package support.component.listbox;

import java.util.Locale;

import org.zkoss.zul.*;

public class DragItemRenderer implements ListitemRenderer<Locale> {

	@Override
	public void render(Listitem item, Locale data, int index) throws Exception {
		String[] headerOrder = (String[])item.getAttribute("headerOrder", true);
		for (int i=0; i < headerOrder.length ; i++){
			item.appendChild(new Listcell(headerOrder[i]+"-"+data.toString()));
		}
		
	}

}
