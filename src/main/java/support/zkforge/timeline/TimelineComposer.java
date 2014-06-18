package support.zkforge.timeline;

import org.zkforge.timeline.Bandinfo;
import org.zkforge.timeline.data.OccurEvent;
import org.zkoss.bind.GlobalCommandEvent;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zkmax.ui.select.annotation.Subscribe;

public class TimelineComposer extends SelectorComposer<Component> {

	private static final long serialVersionUID = 1L;

	@Wire
	private Bandinfo bandinfoMonth;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		//		OccurEvent event = new OccurEvent();
		//		event.setText("Test Event");
		//		event.setStart(Calendar.getInstance().getTime());
		//		bandinfoMonth.addOccurEvent(event);

		//		SimpleTimeZone bst = new SimpleTimeZone(1 * 60 * 60 * 1000, "BST");
		//		bandinfoMonth.setTimeZone(bst);		
	}


	@Subscribe("myqueue")
	public void update(Event event){
		if(event instanceof GlobalCommandEvent){
			GlobalCommandEvent gcEvent = (GlobalCommandEvent)event;
			if("update".equals(gcEvent.getCommand())){
				OccurEvent oEvent = (OccurEvent)gcEvent.getArgs().get("event");
				bandinfoMonth.addOccurEvent(oEvent);
			}               
		}
	}
}
