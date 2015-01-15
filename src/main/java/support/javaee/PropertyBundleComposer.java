package support.javaee;

import java.util.Locale;

import org.zkoss.util.resource.PropertyBundle;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;

public class PropertyBundleComposer extends SelectorComposer {

	DbLocator dbLocator = new DbLocator();
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
//		comp.appendChild(new Label(Labels.getLabel("path")));
		PropertyBundle labelsUS = PropertyBundle.getBundle("zk-label", Locale.US, dbLocator);
		System.out.println(labelsUS.getProperty("dbpath"));
	}

	@Listen("onClick = button")
	public void getBundle(){
		PropertyBundle labelsUS = PropertyBundle.getBundle("db-label", Locale.US, dbLocator);
		System.out.println(labelsUS.getProperty("path"));
		System.out.println(labelsUS.getProperty("dbpath"));
		
	}
}
