package support.event;



import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.Label;

public class EventThreadComposer extends SelectorComposer<Component> {

	@Wire
	Label lbl;

	@Listen("onClick = button")
	public void handle() throws InterruptedException{
		for (int i=1 ; i <=700 ; i++){
			org.zkoss.lang.Threads.sleep( 1000);
		}
		System.out.println("Thread sleeps down");
		lbl.setValue("SSS");
	}
}
