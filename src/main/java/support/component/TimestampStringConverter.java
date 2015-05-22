package support.component;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.zkoss.zk.ui.Component;
import org.zkoss.zkplus.databind.TypeConverter;

public class TimestampStringConverter  implements TypeConverter, Serializable {
	private static final long serialVersionUID = 6459213652698290650L;

//	private Log log = LogFactory.getLog(this.getClass().getName());

	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public Object coerceToUi(Object obj, Component comp) {

		if (obj != null && obj instanceof String) {
			try {
				Date datum = format.parse((String) obj);
				return datum;
			} catch (ParseException e) {
//				log.error("",e);
				e.printStackTrace();
			}
		}
		return obj;
	}

	public Object coerceToBean(Object timestamp, Component comp) {

		if (timestamp != null) {
			String sDatum = format.format(timestamp);
			return sDatum;
		}
		return timestamp;
	}

}
