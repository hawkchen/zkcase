package support.rendering;

import java.util.Arrays;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zul.*;

public class ManyColumnsController extends SelectorComposer<Component> {
    private static final long serialVersionUID = 1L;
    
    String[] values = {"aaaaaaaaa", "bbbbbbbbbb", "cccccccc"};
    private ListModel<String> labelList = new ListModelList<String>(Arrays.asList(values));
 
    public ListModel<String> getLabelList() {
        return labelList;
    }
}
