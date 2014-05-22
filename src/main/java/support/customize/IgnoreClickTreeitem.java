package support.customize;


import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Treeitem;

public class IgnoreClickTreeitem extends Treeitem {
	static{
		/*  Make click event be ignored by the server when the server receives multiple events in 
		 *  the same AU requests but not processed yet. 
		 *  In other words, the server will remove the duplicate AU requests if it was queued. 
		 */
		addClientEvent(IgnoreClickTreeitem.class, Events.ON_CLICK, CE_DUPLICATE_IGNORE);
	}
	
}
