package support.component;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.MouseEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;

import org.zkoss.zul.addon.ICheckbox;

public class IcheckboxComposer extends SelectorComposer<Component> {

	@Wire("#cb")
	private ICheckbox cb;
	@Wire("#cb1")
	private ICheckbox cb1;
	@Wire("#cb2")
	private ICheckbox cb2;
	@Wire("#l")
	private Label l;
	@Wire("#l2")
	private Label l2;

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}

	@Listen("onClick = #indeterminate, #checked, #unchecked, #cb")
	public void showProp(MouseEvent event) {
		l.setValue("id: " + cb.getId() + " checked: " + cb.getChecked());
	}
	
	@Listen("onClick = #cb1")
	public void showProp1(MouseEvent event) {
		l.setValue("id: " + cb1.getId() + " checked: " + cb1.getChecked());
	}
	
	@Listen("onClick = #cb2")
	public void showProp2(MouseEvent event) {
		l.setValue("id: " + cb2.getId() + " checked: " + cb2.getChecked());
	}
}