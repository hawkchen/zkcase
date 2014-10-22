package support.component;

import java.util.*;

import org.zkoss.zul.*;

public class MyTreeNode extends DefaultTreeNode {

	public MyTreeNode(Object data) {
		super(data);
	}

	public MyTreeNode(Object data, List children){
		super(data, children);
	}
	
	@Override
	public void add(TreeNode child) {
		List children = getChildren(); 
		if (children == null){
			children =  new LinkedList();
		}
		children.add(child);
		
	}

}
