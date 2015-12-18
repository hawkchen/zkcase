package support.component;


import java.util.ArrayList;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.SelectEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.ext.Selectable;

public class ComboboxComposer extends SelectorComposer<Component> {
	
	@Wire
	Combobox cbox;
	
	public void doAfterCompose(Component main) throws Exception {
		super.doAfterCompose(main);
		ArrayList<String> al = new ArrayList<String>();
		al.add("One");
		al.add("Two");
		al.add("Three");
		ListModel model = new ListModelList<String>(al);
		cbox.setModel(model);
		cbox.setValue("Three");
		((Selectable<String>)model).addToSelection("Two");
//		cbox.setSelectedIndex(2); don't work for it check component size
		
		System.out.println(cbox.getAnnotations("value", "test"));
		cbox.addAnnotation("value", "api-add", null);
		Combobox box2 = (Combobox)cbox.clone();
		System.out.println(box2.getAnnotation("test"));
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
	
	@Listen("onClick = #print")
	public void printDesktop(){
		System.out.println(getSelf().getDesktop().getId());
	}
}
