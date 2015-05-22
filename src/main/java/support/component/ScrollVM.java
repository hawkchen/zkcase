package support.component;

import java.util.*;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.ListModelList;

public class ScrollVM {
	ListModelList model; 
	Set selectedCarriers;
	
	@Init
	public void init(){
		List names = new ArrayList();
		names.add("Jasmin");
		names.add("David");
		names.add("Richard");
		names.add("Jean");
		names.add("Norman");
		names.add("Thomas");
		names.add("Leonard");
		names.add("Janine");
		names.add("Daniel");
		names.add("Michael");
		names.add("Julia");
		names.add("Vitali");
		names.add("Katharina");
		names.add("Marie");
		names.add("Jenny");
		names.add("Reinhard");
		names.add("Christoph");
		names.add("Heiko");
		names.add("Ludwig");
		names.add("Nico");
		names.add("Rolf");
		model = new ListModelList(names);
		model.setMultiple(true);
	}

	public ListModelList getModel() {
		return model;
	}

	public void setModel(ListModelList model) {
		this.model = model;
	}

	public Set getSelectedCarriers() {
		return selectedCarriers;
	}

	public void setSelectedCarriers(Set selectedCarriers) {
		this.selectedCarriers = selectedCarriers;
	}
	
}
