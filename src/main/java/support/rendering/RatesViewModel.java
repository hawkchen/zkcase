package support.rendering;

import java.util.*;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.*;

public class RatesViewModel {
	private static List<Rate> rateList = new LinkedList<Rate>();
	static  GroupsModel groupModel;
	static{
		rateList.add(new Rate("Taiwan", "30"));
		rateList.add(new Rate("Korean", "300"));
		rateList.add(new Rate("Spain", "4"));
		rateList.add(new Rate("France", "5"));
		rateList.add(new Rate("Japan", "20"));
		rateList.add(new Rate("Iran", "33"));
		rateList.add(new Rate("Brazil", "46"));
		
        String[][] datas = new String[][] {
                new String[] { //group 1
                    // Today
                    "RE: Bandbox Autocomplete Problem",
                    "RE: It's not possible to navigate a listbox' ite",
                    "RE: FileUpload"
                },
                new String[] { //group 2
                    // Yesterday
                    "RE: Opening more than one new browser window",
                    "RE: SelectedItemConverter Question"
                },
                new String[] { //group 3
                    "RE: Times_Series Chart help",
                    "RE: SelectedItemConverter Question"
                }            
            };
            groupModel = new SimpleGroupsModel(datas,
                new String[]{"Date: Today", "Date: Yesterday", "Date: Last Week"});
                //the 2nd argument is a list of group head
	}
	
	@Init
	public void init(){
	}

	public List<Rate> getRateList() {
		return rateList;
	}

	public void setRateList(List<Rate> rateList) {
		RatesViewModel.rateList = rateList;
	}

	public GroupsModel getGroupModel() {
		return groupModel;
	}

	public void setGroupModel(GroupsModel groupModel) {
		RatesViewModel.groupModel = groupModel;
	}
	
}
