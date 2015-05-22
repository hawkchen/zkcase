package support.component.grid;

import java.util.Locale;

import org.zkoss.zul.*;

public class SimpleRowRenderer implements RowRenderer<Object> {

	@Override
	public void render(Row row, Object data, int index) throws Exception {
		Locale l = (Locale)data;
		row.appendChild(new Label(l.toString()));
	}


}
