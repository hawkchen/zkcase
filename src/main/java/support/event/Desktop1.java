package support.event;



import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.util.GenericAutowireComposer;
import org.zkoss.zul.Button;

public class Desktop1 extends GenericAutowireComposer {
	Button btn1;
	EventQueue queue;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		queue = EventQueues.lookup("myGroupQueue", EventQueues.SESSION, true);
		queue.subscribe(
				new EventListener() {
					public void onEvent(Event evt) {
						onOK(evt);
					}
				});
	}

	public void onOK(Event event) {
		System.out.println(event.getName()+", onOK at desktop1 ");
	}
	
}
