package support.zkforge.timeline;

import java.text.SimpleDateFormat;
import java.util.*;

import org.zkforge.timeline.Bandinfo;
import org.zkoss.zk.au.out.AuScript;

public class MyBandinfo extends Bandinfo{
	static SimpleDateFormat Rfc2882DateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'Z", Locale.US);
	
	@Override
	public void scrollToCenter(Date date) {
		if (date == null) return;
		String uuid = getUuid();		
		response("scrollToCenter", new AuScript(this,
				"zk.Widget.$(\""+ uuid +"\").scrollToCenter(\"" + uuid + "\"" + ",\""
						+ Rfc2882DateFormat.format(date) + "\")"));
		System.out.println(Rfc2882DateFormat.format(date));
	}
}
