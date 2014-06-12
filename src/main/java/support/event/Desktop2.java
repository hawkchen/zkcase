package support.event;



import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.util.GenericAutowireComposer;

public class Desktop2 extends GenericAutowireComposer {

	EventQueue queue;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		queue = EventQueues.lookup("myGroupQueue", EventQueues.SESSION, true);
	}
	
	// ������Ϣ
	public void onSend2SameDesktop(Event event) {
		Events.postEvent(new Event("onOK")); //broadcast events to all "onOK" listeners in the same desktop 
		
	}
	
	public void onOK(Event event){
		System.out.println("onOK at desktop2 ");
	}
	
	public void onSendEventQueue(Event event){
		queue.publish(new Event("EventQueue"));
	}
}
