package support.component;


import java.util.*;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.*;

public class InplaceComposer extends SelectorComposer<Component> {
	
	List<Person> people = new ListModelList();
//	List<Boolean> editStatus = new LinkedList<Boolean>();

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		people.add(new Person());
		people.add(new Person());
		people.add(new Person());
		//initialize checkbox, label status upon data model
	}
	/*
	 * show a checkbox
	 */
	@Listen("onClick = label")
	public void startEdit(Event event){
		Label label = (Label)event.getTarget();
		Checkbox checkbox = (Checkbox) label.getNextSibling();
		label.setVisible(false);
		checkbox.setVisible(true);
	}
	
	@Listen("onCheck = checkbox")
	public void edit(Event event){
		Checkbox checkbox = (Checkbox)event.getTarget();
		Label label = (Label)checkbox.getPreviousSibling();
		label.setVisible(true);
		checkbox.setVisible(false);
		label.setValue(Boolean.toString(checkbox.isChecked()));
		//save data back to model
	}
	

	public List<Person> getPeople() {
		return people;
	}
	public void setPeople(List<Person> people) {
		this.people = people;
	}
}
