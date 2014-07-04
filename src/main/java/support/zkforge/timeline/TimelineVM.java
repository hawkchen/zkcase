package support.zkforge.timeline;

import java.util.*;

import org.zkforge.timeline.data.OccurEvent;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.zul.SimpleListModel;

public class TimelineVM{

	@Command
	public void update() {

		OccurEvent event = new OccurEvent();
		event.setText("Test Event");
		event.setStart(Calendar.getInstance().getTime());
		List<OccurEvent> events = new LinkedList<OccurEvent>();
		events.add(event);
		SimpleListModel timeLineEventList = new SimpleListModel(events);
		Map args = new HashMap<String, OccurEvent>();
		args.put("event", timeLineEventList);
		BindUtils.postGlobalCommand("myqueue", null, "update",args);
	}
}
