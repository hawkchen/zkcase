/*
 * MyNode.java
 */

package support.component.tree;

import java.util.*;

public class MyNode
{
    public String data;
    public List<MyNode> children = new ArrayList();

    public MyNode(String data)
    {
        this.data = data;
    }

    public String toString()
    {
        return data;
    }

	public List<MyNode> getChildren() {
		return children;
	}

}
