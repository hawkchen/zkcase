package support.lifecycle;


import java.util.Map;

import org.zkoss.zk.ui.*;
import org.zkoss.zk.ui.util.Initiator;

public class CreateInitiator implements Initiator {

	@Override
	public void doInit(Page page, Map<String, Object> args) throws Exception {
		Executions.createComponents("/mvvm/textbox-instant.zul", null, null);
	}
	
}
