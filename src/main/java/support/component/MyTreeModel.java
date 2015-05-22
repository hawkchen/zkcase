package support.component;

import org.zkoss.zul.*;

public class MyTreeModel extends AbstractTreeModel<DefaultTreeNode<String>> {

	boolean emptyChildrenAsLeaf = false;
	
	public MyTreeModel(DefaultTreeNode<String> root) {
		super(root);
	}
	
	public MyTreeModel(DefaultTreeNode<String> root, boolean emptyChildrenAsLeaf) {
		super(root);
		this.emptyChildrenAsLeaf = emptyChildrenAsLeaf;
	}
	
	@Override
	public boolean isLeaf(DefaultTreeNode<String> node) {
		if (emptyChildrenAsLeaf){
			return (node.getChildren()==null || node.getChildren().size()==0);
		}else{
			return node.getChildren()==null;
		}
	}

	@Override
	public DefaultTreeNode<String> getChild(DefaultTreeNode<String> parent, int index) {
		return (DefaultTreeNode<String>)parent.getChildAt(index);
	}

	@Override
	public int getChildCount(DefaultTreeNode<String> parent) {
		return parent.getChildCount();
	}

}
