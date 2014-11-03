package support.macro;


import org.zkoss.zk.ui.HtmlMacroComponent;
import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;

public class Barcodebox extends HtmlMacroComponent  {
	
	@Wire("textbox")
	Textbox textbox;
	
	@Wire("window")
	Window window;
	


	@Override
	public boolean setVisible(boolean visible) {
		return window.setVisible(visible);
	}
	
	public String getValue(){
		return textbox.getValue();
	}
	
	
	@Listen("onClick = window #okBtn")
	public void ok(){
		setVisible(false);
		//you can use any event name you like
		Events.postEvent("onOK", this, textbox.getValue());
	}
	
	@Listen("onClick= window #cancelBtn")
	public void cancel(){
		setVisible(false);
		Events.postEvent(this, new Event("onCancel"));
	}
}
