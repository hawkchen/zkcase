package support.zkforge.timeline;

import java.text.SimpleDateFormat;
import java.util.*;

import org.zkforge.json.simple.JSONObject;
import org.zkforge.timeline.decorator.SpanHighlightDecorator;

public class MySpanHighlightDecorator extends SpanHighlightDecorator {
	static SimpleDateFormat Rfc2882DateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'Z", Locale.US);
	
	public MySpanHighlightDecorator(Date start, Date end) {
		super(start, end);
	}
	
	@Override
	public String toString() {
		JSONObject json = new JSONObject();
		json.put("id", new Integer(getId()));
		json.put("HighlightDecoratorName", "SpanHighlightDecorator");
		json.put("startDate", Rfc2882DateFormat.format(getStartDate()));
		json.put("endDate", Rfc2882DateFormat.format(getEndDate()));
		json.put("startLabel", getStartLabel());
		json.put("endLabel", getEndLabel());
		json.put("color", getColor());
		json.put("opacity", new Integer(getOpacity()));

		return json.toString();
	}
}
