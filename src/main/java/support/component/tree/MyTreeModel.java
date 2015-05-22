/*
 * MyTreeModel.java
 */

package support.component.tree;

import java.util.*;

import org.zkoss.zul.*;

public class MyTreeModel extends AbstractTreeModel<MyNode>
{

    public MyTreeModel(MyNode root){
        super(root);
    }
	@Override
	public boolean isLeaf(MyNode node) {
		 return node.getChildren().isEmpty();
	}

	@Override
	public MyNode getChild(MyNode parent, int index) {
		return parent.getChildren().get(index);
	}

	@Override
	public int getChildCount(MyNode parent) {
		return parent.getChildren().size();
	}
	
	public int[] getPath(MyNode parent, MyNode child) {
		final MyNode root = getRoot();
		List<Integer> p = new ArrayList<Integer>();
		while (root != child) {
			if (parent != null) {
				for (int i = 0, j = parent.getChildren().size(); i < j; i++) {
					if (parent.getChildren().get(i) == child) {
						p.add(0, i);
						break;
					}
				}
				child = parent;
			} else break; // ZK-838
		}
		final Integer[] objs = p.toArray(new Integer[p.size()]);
		final int[] path = new int[objs.length];
		for (int i = 0; i < objs.length; i++)
			path[i] = objs[i].intValue();
		return path;
	}
}
