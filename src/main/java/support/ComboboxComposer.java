package support;


import java.util.ArrayList;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;
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

}
