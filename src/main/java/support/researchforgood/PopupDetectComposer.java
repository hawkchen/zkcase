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

	int count = 0;

	@Override
	public void doAfterCompose(Vlayout comp) throws Exception {
		super.doAfterCompose(comp);
		//approach 1
		Popup popup = new Popup();
		popup.appendChild(new Label("popup contents"));
		openPopup.appendChild(popup);
		openPopup.setPopup(popup);
		//approach 2
		page.addEventListener("onOpen", new EventListener() {
		    public void onEvent(Event event) {
		    	System.out.println(((OpenEvent)event).isOpen());
		    }
		});
	}

	public void onTimer$timer() {
		List<Component> popupList = Selectors.find(getPage(), "popup[visible=true], window[mode='modal'][visible=true], window[mode='overlapped'][visible=true]");
//		popupList = Selectors.find(getPage(), "popup");
		if ( popupList.size() > 0 ) {
			output.setValue("stopped");
		} else {
			output.setValue("running " + (count++));
		}
	}

//	public void onClick$openPopup() {
//		Popup popup = new Popup();
//		popup.appendChild(new Label("popup contents"));
//		openPopup.appendChild(popup);
//		openPopup.setPopup(popup);//not work
//		popup.open(openPopup);
//	}

	public void onOpen(){
		
	}
	
	public void onClick$openWindow() {
		Window win = new Window("Window","normal",true);
		win.appendChild(new Label("window contents"));
		openWindow.appendChild(win);
		win.doModal();
	}
}
