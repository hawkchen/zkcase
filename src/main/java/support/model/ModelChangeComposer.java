package support.model;

import java.util.*;
import java.util.spi.LocaleServiceProvider;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.*;
import org.zkoss.zul.event.ListDataEvent;

public class ModelChangeComposer extends GenericForwardComposer {

	MyModel model;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		List data = new ArrayList<String>();
		
//		data.add("a");
//		data.add("b");
		data.addAll(Arrays.asList(Locale.getAvailableLocales()));

		model = new MyModel(data);

		((Listbox)comp.getFellow("lb")).setModel(model);
//		((Listbox)comp.getFellow("lb2")).setModel(model);

	}

	public void onClick$btn(Event e) throws InterruptedException{
//		model.fireContentsChanged();
		model.set(0, "replaced");
//		model.add("added");
	}


	class MyModel extends ListModelList<String> {

		public MyModel(List<String> data) {
			super(data);
		}

		public void fireContentsChanged() {
			fireEvent(ListDataEvent.CONTENTS_CHANGED, 0, 0);
		}
	}	
}
