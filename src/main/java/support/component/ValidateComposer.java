package support.component;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;

public class ValidateComposer extends SelectorComposer {
	@Wire
	private Textbox username;
	@Wire
	private Combobox listenCombo;

	@Wire
	private Combobox speakCombo;

	private String ERROR= "default";
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		listenCombo.setSelectedIndex(0);
	}

	@Listen("onClick = #validate")
	public void validate() {
		listenCombo.clearErrorMessage();
		if (ERROR.equals(listenCombo.getValue())) {
			throw new WrongValueException(listenCombo, "Please select.");
		}
		speakCombo.clearErrorMessage();
		if (ERROR.equals(speakCombo.getValue())) {
			throw new WrongValueException(speakCombo, "Please select.");
		}
	}

}
