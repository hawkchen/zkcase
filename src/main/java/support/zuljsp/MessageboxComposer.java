package support.zuljsp;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zk.ui.sys.DesktopCtrl;
import org.zkoss.zul.*;

public class MessageboxComposer extends SelectorComposer<Component> {

	
	@Listen("onClick = [label='Test Button']")
	public void showMyMessage(){
        Messagebox.show("Test Buttons work", "Information", Messagebox.OK, Messagebox.INFORMATION);
  }
}
