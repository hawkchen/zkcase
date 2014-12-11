package support.component;


import java.util.*;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.CheckEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;
import org.zkoss.zul.ext.Selectable;

public class CustomSelectAllComposer extends SelectorComposer<Component> {

	@Wire
	Listbox lb;

	@Listen("onCheckSelectAll=#lb")
	public void doCheckSelectAll(CheckEvent evt) {
		ListModel model = lb.getModel();
		if (evt.isChecked()) {
			int sz = model.getSize();
			Collection clt = new ArrayList();
			for (int i = 0; i < sz; i++) {
				if (i % 2 == 0) {
					Object obj = model.getElementAt(i);
					clt.add(obj);
				}
			}
			((Selectable) model).setSelection(clt);
		} else {
			((Selectable) model).clearSelection();
		}
	}
}
