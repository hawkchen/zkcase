package support.queue;

import org.zkoss.lang.Threads;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zk.ui.sys.DesktopCtrl;
import org.zkoss.zul.*;

public class LongOperationComposer extends SelectorComposer<Component> {

	@Wire
	Vbox inf;
	String result;
	EventQueue eq ; //create a queue

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		eq = EventQueues.lookup("longop", "session", true);
//		eq = EventQueues.lookup("longop");
		/*
		 have to enable server push manually when using desktop scope event queue
		((DesktopCtrl)comp.getDesktop()).enableServerPush(
				new org.zkoss.zk.ui.impl.PollingServerPush(1000,15000,5));
		eq = EventQueues.lookup("longop");
		 */
		//subscribe async listener to handle long operation
		final EventListener asyncListener = new EventListener() {
			public void onEvent(Event evt) {
				if ("doLongOp".equals(evt.getName())) {
					org.zkoss.lang.Threads.sleep(3000); //simulate a long operation
					result = "success"; //store the result
					eq.publish(new Event("endLongOp")); //notify it is done
				}
			}
		};
		eq.subscribe(asyncListener, true); //asynchronous
		
		//subscribe a normal listener to show the result to the browser
		eq.subscribe(new EventListener() {
			public void onEvent(Event evt) {
				if ("endLongOp".equals(evt.getName())) {
					print(result); //show the result to the browser
//					EventQueues.remove("longop","session");
					//EventQueues.remove("longop");
//					eq.unsubscribe(asyncListener);
				}
			}
		}); //synchronous
		
	}
	
	@Listen("onClick = [label='async long op']")
	public void start(){
		eq.publish(new Event("doLongOp")); //kick off the long operation		
	}

	void print(String msg) {
		new Label(msg).setParent(inf);
	}
}
