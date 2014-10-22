package support.component;

import org.zkoss.zk.ui.HtmlMacroComponent;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;

public class ResetTextbox extends HtmlMacroComponent{

	@Wire("textbox")
	private Textbox textbox;
	
	public ResetTextbox() {
		//required, because macro is display:inline-block by default which make hflex not work
		setStyle("display:block"); 
		afterCompose(); //wire components
	}
	
	
	@Listen("onClick = label")
	public void reset(){
		textbox.setValue("");
	}
	
	@Override
	public void setHflex(String flex) {
		textbox.setHflex(flex);
	}
}
