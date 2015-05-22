package support.mvvm;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;

public class NestedChildrenVM extends InnerVM{

	Map<String, List<String>> checkGroups = new TreeMap<String, List<String>>();
	
	
	public Map<String, List<String>> getCheckGroups() {
		return checkGroups;
	}


	@Init
	public void init(){
		List itemsA = new LinkedList<String>();
		itemsA.add("check a-1");
		itemsA.add("check a-2");
		itemsA.add("check a-3");
		checkGroups.put("group a", itemsA);
		List itemsB = new LinkedList<String>();
		itemsB.add("check b-1");
		itemsB.add("check b-2");
		itemsB.add("check b-3");
		checkGroups.put("group b", itemsB);
		List itemsC = new LinkedList<String>();
		itemsC.add("check c-1");
		itemsC.add("check c-2");
		itemsC.add("check c-3");
		checkGroups.put("group c", itemsC);
	}
	
	@Command
	public void check(@BindingParam("checked")boolean checked, @BindingParam("arg")String arg){
		System.out.println(checked+","+arg);
	}
	
	
}
