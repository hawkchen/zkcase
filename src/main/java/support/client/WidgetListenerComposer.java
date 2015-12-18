package support.client;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;

public class WidgetListenerComposer extends SelectorComposer<Component> {

	@Wire
	private Datebox myDatebox;
	@Wire
	private Combobox myCombobox;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		myDatebox.setWidgetListener("onBind", "jq(this.getInputNode()).attr('aria-label','This is my datebox'); jq(this.getInputNode()).attr('aria-required',true);");
		myCombobox.setWidgetListener("onBind", "jq(this.getInputNode()).attr('aria-label','my combobox'); jq(this.getInputNode()).attr('aria-required',true);");
	}
}
