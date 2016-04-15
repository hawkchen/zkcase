package support.client;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.DesktopCleanup;
import org.zkoss.zul.Div;

public class CloseComposer extends SelectorComposer<Component> {

	@Wire
	Div root;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		//or register in zk.xml
		getPage().getDesktop().addListener(new MyDesktopCleanupListener());
	}
	
	@Listen("onClick = #exit")
	public void processBeforeExit(){
		System.out.println("processBeforeClose " + root.getId());
	}
	
	class MyDesktopCleanupListener implements DesktopCleanup{

		@Override
		public void cleanup(Desktop desktop) throws Exception {
			// or determine by the getRequestPath()
			if (getPage().getDesktop().equals(desktop)){
				processBeforeExit();
				System.out.println(desktop.getRequestPath());
			}
		}
		
	}
}
