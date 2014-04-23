package support;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.*;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.Window;

public class FindVisibilityComposer extends SelectorComposer<Component>{

	
	
	@Listen("onTimer = #timer")
	public void printVisibleWindows(){
		List<Component> popupList = Selectors.find(getPage(), "popup");
		List<Component> windowList =  Selectors.find(getPage(), "window[mode='modal'][visible=true], window[mode='overlapped'][visible=true]");
		
		
		System.out.println(popupList.size()+" popup");
		System.out.println(windowList.size()+" window");
	}
}
