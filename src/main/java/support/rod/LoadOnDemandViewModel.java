package support.rod;

import org.zkoss.zul.ListModel;

public class LoadOnDemandViewModel {
	 
    private ListModel<String> hugeList = new FakeListModel(2500);
 
    public ListModel<String> getHugeList() {
        return hugeList;
    }
}