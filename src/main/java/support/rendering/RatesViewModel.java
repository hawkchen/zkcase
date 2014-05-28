package support.rendering;

import java.util.*;

import org.zkoss.bind.annotation.Init;

public class RatesViewModel {
	private static List<Rate> rateList = new LinkedList<Rate>();
	static{
		rateList.add(new Rate("Taiwan", "30"));
		rateList.add(new Rate("Korean", "300"));
//		rateList.add(new Rate("Spain", "4"));
//		rateList.add(new Rate("France", "5"));
//		rateList.add(new Rate("Japan", "20"));
//		rateList.add(new Rate("Iran", "33"));
//		rateList.add(new Rate("Brazil", "46"));
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
	
}
