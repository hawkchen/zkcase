package support.javaee;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import org.zkoss.util.resource.*;

public class MyLabelLocator implements LabelLocator2 {
	
	@Override
	public InputStream locate(Locale locale) {
		return getClass().getResourceAsStream("db-label.properties");
	}

	@Override
	public String getCharset() {
		return StandardCharsets.UTF_8.name();
	}

}
