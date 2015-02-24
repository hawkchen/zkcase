/*
 * MyNode.java
 */

package support.component.tree;

import java.util.*;

public class MyNode
{
    public String title;
    public List children = new ArrayList();

    public MyNode(String title)
    {
        this.title = title;
    }

    public String toString()
    {
        return title;
    }

}
