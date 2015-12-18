package support.component.listbox;


import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

@SuppressWarnings("serial")
public class ScrollToComposer extends SelectorComposer<Component> {
    
    private static final int INIT_SIZE = 100;

    @Wire
    private Grid box;
    
    private int count = INIT_SIZE;
    
    private ListModel<String> model;
    
    public ListModel<String> getModel() {
        return model;
    }
    
    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < INIT_SIZE; i++)
            list.add("Item " + i);
        model = new ListModelList<String>(list);
        
        box.setModel(model);
    }
    
    @Listen("onClick = #btn")
    public void addRow() {
        ((ListModelList<String>)model).add("Item " + (count++));
        Clients.scrollIntoView(box.getRows().getLastChild());    // scroll to the last item
    }
    
    @Listen("onClick = #replace")
    public void replace() {
        ((ListModelList<String>)model).set(model.getSize()-1, "replaced item");
    }
}
