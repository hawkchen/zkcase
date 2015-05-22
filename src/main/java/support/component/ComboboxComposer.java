package support.component;


import java.util.ArrayList;

import org.zkoss.zk.ui.event.SelectEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;
import org.zkoss.zul.ext.Selectable;

public class ComboboxComposer extends SelectorComposer<Window> {
	
	@Wire
	Combobox cbox;
	
	public void doAfterCompose(Window main) throws Exception {
		super.doAfterCompose(main);
		ArrayList<String> al = new ArrayList<String>();
		al.add("One");
		al.add("Two");
		al.add("Three");
		ListModel lm = new ListModelList<String>(al);
		((Selectable<String>)lm).addToSelection("Two");
		cbox.setModel(lm);
	}

	@Listen("onSelect = #localeBox")
	public void changeSentence(SelectEvent e){
		Object selectedItem = e.getSelectedItems().iterator().next();
		//clear existing components in the target area , with  or getChildren().clear() or Component.detach()
		Textbox textbox = new Textbox();
		// set up values
		Combobox combobox = new Combobox();
		//append to the target area, maybe a div or window
	}
}
