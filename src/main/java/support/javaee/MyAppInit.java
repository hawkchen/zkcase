package support.javaee;

import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.WebApp;

public class MyAppInit implements org.zkoss.zk.ui.util.WebAppInit {

	public void init(WebApp wapp) throws Exception {
		Labels.register(new MyLabelLocator());
	}
}
