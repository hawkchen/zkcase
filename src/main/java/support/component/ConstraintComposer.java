package support.component;


import java.util.List;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;

public class ConstraintComposer extends SelectorComposer<Window> {
	
	@Wire("textbox")
	List<Textbox> textboxes;
	
	@Listen("onClick = button")
	public void submit(){
		for (Textbox box : textboxes){
			if (box.isVisible()){
			}
		}
	}
	
}
