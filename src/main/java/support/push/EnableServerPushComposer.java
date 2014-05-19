package support.push;

import org.zkoss.zk.ui.*;
import org.zkoss.zk.ui.select.SelectorComposer;

public class EnableServerPushComposer extends SelectorComposer<Component> {

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.getDesktop().enableServerPush(true);
		System.out.println("enable server push");
	}

}
