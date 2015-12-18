package support.client;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.BookmarkEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Textbox;

public class WidgetListenerComposer extends SelectorComposer<Component> {

	@Wire
	private Textbox target;

	@Listen("onBookmarkChange = window")
	public void fillForm(BookmarkEvent e){
		target.setValue(e.getBookmark());
	}
}
