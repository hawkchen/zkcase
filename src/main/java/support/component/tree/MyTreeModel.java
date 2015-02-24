/*
 * MyTreeModel.java
 */

package support.component.tree;

import org.zkoss.zul.AbstractTreeModel;

public class MyTreeModel extends AbstractTreeModel
{
    private MyNode root;

    public MyTreeModel(MyNode root)
    {
        super(root);
        this.root = root;
    }

    public boolean isLeaf(Object item)
    {
        if (item instanceof MyNode) {
            MyNode node = (MyNode) item;
            return (node.children.isEmpty());
        } else {
            return true;
        }
    }

    public Object getChild(Object parent, int index)
    {
        if (parent instanceof MyNode) {
            MyNode node = (MyNode) parent;
            return node.children.get(index);
        } else {
            return null;
        }
    }

    public int getChildCount(Object item)
    {
        if (item instanceof MyNode) {
            MyNode node = (MyNode) item;
            return node.children.size();
        } else {
            return 0;
        }
    }

}
