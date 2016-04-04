package support.client;

import java.util.Calendar;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;

public class AutoReloadComposer extends SelectorComposer<Component> {

	@Wire
	Label toUpdate;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		setTotalValues();
	}

	@Listen("onTimer = #timer")
	public void setTotalValues(){
		//Do some db queries
		toUpdate.setValue(Calendar.getInstance().getTime().toString());
	}

	public synchronized void onTimer$timer() {
		setTotalValues();
	}
}
