package support;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.OpenEvent;
import org.zkoss.zk.ui.select.*;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Popup;

public class FindVisibilityComposer extends SelectorComposer<Component>{

	
	
	@Listen("onTimer = #timer")
	public void printVisibleWindows(){
		List<Component> popupList = Selectors.find(getPage(), "popup");
		List<Component> windowList =  Selectors.find(getPage(), "window[mode='modal'][visible=true], window[mode='overlapped'][visible=true]");
		
		
		System.out.println(popupList.size()+" popup");
		System.out.println(windowList.size()+" window");
		
		popupList = Selectors.find(getPage(), "popup");
		int visibleCount = 0;
		for (Component c : popupList){
			Popup p = (Popup)c;
			if (p.isVisible()){
				visibleCount++;
			}
		}
		System.out.println(visibleCount+" visible popup");
	}
	
	@Listen("onOpen = popup")
	public void onOpen(OpenEvent event){
		System.out.println(event.isOpen());
	}
}
	
