package support.javaee;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import org.zkoss.util.resource.*;

public class MyLabelLocator implements LabelLocator2 {
	DbLocator dbLocator = new DbLocator();
	
	@Override
	public InputStream locate(Locale locale) {

		if (locale != null && !locale.getLanguage().isEmpty()){
			return dbLocator.getResourceAsStream("db-label_"+locale.getLanguage()+".properties");
		}else{
			return dbLocator.getResourceAsStream("db-label.properties");
		}
	}

	@Override
	public String getCharset() {
		return StandardCharsets.UTF_8.name();
	}

}
