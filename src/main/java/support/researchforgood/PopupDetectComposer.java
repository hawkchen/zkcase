package support.researchforgood;


import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.*;

public class PopupDetectComposer extends GenericForwardComposer<Vlayout> {

	Label output;
	A openPopup;
	A openWindow;
	int openPopupCount = 0;
	//create popup first
	Label popupContent = new Label();
	Popup popup = new Popup();

	int count = 0;

	//approach 1
	@Override
	public void doAfterCompose(Vlayout comp) throws Exception {
		super.doAfterCompose(comp);
		openPopup.appendChild(popup);
		popup.appendChild(popupContent);
		openPopup.setPopup(popup);
	}
	
	public void onClick$openPopup() {
		//change popup content dynamically
		popupContent.setValue("popup contents");
	}
	
	public void onTimer$timer() {
		List<Component> popupList = Selectors.find(getPage(), "popup[visible=true], window[mode='modal'][visible=true], window[mode='overlapped'][visible=true]");
		if ( popupList.size() > 0 ) {
			output.setValue("stopped");
		} else {
			output.setValue("running " + (count++));
		}
	}

	
	/*
	//approach 2
	@Override
	public void doAfterCompose(Vlayout comp) throws Exception {
		super.doAfterCompose(comp);
		openPopup.appendChild(popup);
		popup.appendChild(popupContent);
		openPopup.setPopup(popup);
		page.addEventListener("onOpen", new EventListener() {
			public void onEvent(Event event) {
				System.out.println(event.getTarget()+" "+((OpenEvent)event).isOpen());
				if (((OpenEvent)event).isOpen()){
					openPopupCount++;	
				}else{
					openPopupCount--;
				}
			}
		});
	}

	public void onClick$openPopup() {
		//change popup content dynamically
		popupContent.setValue("popup contents");
	}
	
	public void onTimer$timer() {
		List<Component> popupList = Selectors.find(getPage(), "window[mode='modal'][visible=true], window[mode='overlapped'][visible=true]");
		if ( popupList.size() + openPopupCount > 0 ) {
			output.setValue("stopped");
		} else {
			output.setValue("running " + (count++));
		}
	}
	 */

	

	//rest of the codes ----------------------
	
	public void onClick$openWindow() {
		Window win = new Window("Window","normal",true);
		win.appendChild(new Label("window contents"));
		openWindow.appendChild(win);
		win.doModal();
	}
	
}
