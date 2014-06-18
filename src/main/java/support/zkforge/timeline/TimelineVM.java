package support.zkforge.timeline;

import java.util.*;

import org.zkforge.timeline.data.OccurEvent;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;

public class TimelineVM{

	@Command
	public void update() {

		OccurEvent event = new OccurEvent();
		event.setText("Test Event");
		event.setStart(Calendar.getInstance().getTime());
		Map args = new HashMap<String, OccurEvent>();
		args.put("event", event);
		BindUtils.postGlobalCommand("myqueue", null, "update",args);
	}
}
