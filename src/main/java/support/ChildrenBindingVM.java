package support;

import java.util.*;

import org.zkoss.bind.annotation.Init;

public class ChildrenBindingVM {

	private List<String> nodes = new LinkedList<String>();
	
	@Init
	public void init(){
		String[] values = {"a", "b", "c"};
		nodes.addAll(Arrays.asList(values));
	}
	
	public List<String> getNodes(){
		return nodes;
	}
}
