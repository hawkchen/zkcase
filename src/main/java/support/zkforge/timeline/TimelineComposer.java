package support.zkforge.timeline;


import java.util.*;

import org.zkforge.timeline.Bandinfo;
import org.zkforge.timeline.data.OccurEvent;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ListModelList;

public class TimelineComposer extends SelectorComposer<Component> {
	
	@Wire
	Bandinfo bandinfoMonth;
	
	public void doAfterCompose(Component main) throws Exception {
		super.doAfterCompose(main);
		ArrayList<OccurEvent> eventList = new ArrayList<OccurEvent>();
		OccurEvent e1 = new OccurEvent();
		e1.setText("ZK 5.0.2 Released");
		Date today = Calendar.getInstance().getTime();
		e1.setStart(today);
		eventList.add(e1);
		
		bandinfoMonth.setModel(new ListModelList<OccurEvent>(eventList));
	}

}
