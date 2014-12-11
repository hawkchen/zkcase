package support.component.tree;


import java.util.Hashtable;

import org.zkoss.zk.ui.Path;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.OpenEvent;
import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.TreeitemRenderer;
import org.zkoss.zul.Treerow;


public class TreeRendererTest implements TreeitemRenderer{

	private static Hashtable<String,Integer> totals=new Hashtable<String,Integer>(){{
	    put("A", 0);
	    put("B", 0);
	    put("C", 0);
	}};
	private static long startTime=System.currentTimeMillis();
	
	@Override
	public void render(Treeitem treeItem, Object data, int id) throws Exception {

		DefaultTreeNode treeNode = (DefaultTreeNode) data;
		treeItem.setValue(treeNode);
		Treerow tr;
		if (treeItem.getTreerow() == null) {
			tr = new Treerow();
			tr.setParent(treeItem);
		} else {
			tr = treeItem.getTreerow();
			tr.getChildren().clear();
		}
		treeItem.addForward("onRightClick", treeItem.getTree(), "onItemContext");
		TestObject row = (TestObject)treeNode.getData();
		String treeid="";
		if (!row.leaf) {
			treeid=treeid+row.col0.charAt(4);
		} else {
			treeid=treeid+row.col0.charAt(7);
		}
		
		long timeFromStart=System.currentTimeMillis()-startTime;
		totals.put(treeid, totals.get(treeid)+1);//((float)(totals.get("A")*1000)/timeFromStart)
		System.out.println("Average tree updates per second \tA:"+((float)(totals.get("A")*1000)/timeFromStart)+"\tB:"+((float)(totals.get("B")*1000)/timeFromStart)+"\tC:"+((float)(totals.get("C")*1000)/timeFromStart));

		Treecell t0=new Treecell();
		t0.setLabel(row.col0);

		// This is to be able to open the row when it's blocked
		if (!row.leaf && !t0.isListenerAvailable(Events.ON_DOUBLE_CLICK, true)) { 
			t0.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener() { 
				public void onEvent(Event event) throws Exception {
					Treeitem ti=(Treeitem)event.getTarget().getParent().getParent();
					ti.setSelected(true);
					DefaultTreeNode dtn=(DefaultTreeNode)ti.getValue();
					TestObject row = (TestObject)dtn.getData();
					row.open=!row.open;
					ti.setOpen(row.open);
				}
			});
		}
		tr.appendChild(t0);
		
		Treecell t1=new Treecell();
		Div t1Div=new Div();
		t1Div.appendChild(new Label(row.col1.toString()));
		if (row.col1.intValue()>=50) {
			t1Div.setClass("green_class");
		} else if (row.col1.intValue()==0){
			t1Div.setClass("white_class");
		} else {
			t1Div.setClass("red_class");
		}
		t1.appendChild(t1Div);
		if (!t1.isListenerAvailable(Events.ON_CLICK, true)) { 
			t1.addEventListener(Events.ON_CLICK, new EventListener() { 
				public void onEvent(Event event) throws Exception {
            		//Executions.schedule(event.getTarget().getDesktop(), this, new Event("onCol1", Path.getComponent("//mypage/mywindow"), ((Treerow)event.getTarget().getParent()).getLabel() ));
					Events.postEvent(new Event("onCol1",Path.getComponent("//mypage/mywindow"),((Treerow)event.getTarget().getParent()).getLabel() ));
				}
			});
		}
		tr.appendChild(t1);
		
		Treecell t2=new Treecell();
		Div t2Div=new Div();
		t2Div.appendChild(new Label(row.col2.toString()));
		if (row.col2.doubleValue()>=100) {
			t2Div.setClass("green_class");
		} else if (row.col2.doubleValue()==0){
			t2Div.setClass("white_class");
		} else {
			t2Div.setClass("red_class");
		}
		t2.appendChild(t2Div);
		if (!t2.isListenerAvailable(Events.ON_CLICK, true)) { 
			t2.addEventListener(Events.ON_CLICK, new EventListener() { 
				public void onEvent(Event event) throws Exception {
					Events.postEvent(new Event("onCol2",Path.getComponent("//mypage/mywindow"), ((Treerow)event.getTarget().getParent()).getLabel() ));
				}
			});
		}
		tr.appendChild(t2); 
	
		Treecell t3=new Treecell();
		Div t3Div=new Div();
		t3Div.appendChild(new Label(row.col3.toString()));
		if (row.col3.longValue()>=100) {
			t3Div.setClass("green_class");
		} else if (row.col3.longValue()==0){
			t3Div.setClass("white_class");
		} else {
			t3Div.setClass("red_class");
		}
		t3.appendChild(t3Div);
		if (!t3.isListenerAvailable(Events.ON_CLICK, true)) { 
			t3.addEventListener(Events.ON_CLICK, new EventListener() { 
				public void onEvent(Event event) throws Exception {
					Events.postEvent(new Event("onCol3",Path.getComponent("//mypage/mywindow"), ((Treerow)event.getTarget().getParent()).getLabel() ));
				}
			});
		}
		tr.appendChild(t3); 
	
		Treecell t4=new Treecell();
		Div t4Div=new Div();
		t4Div.appendChild(new Label(row.col4.toString()));
		if (row.col4.floatValue()>=100) {
			t4Div.setClass("green_class");
		} else if (row.col4.floatValue()==0){
			t4Div.setClass("white_class");
		} else {
			t4Div.setClass("red_class");
		}
		t4.appendChild(t4Div);
		if (!t4.isListenerAvailable(Events.ON_CLICK, true)) { 
			t4.addEventListener(Events.ON_CLICK, new EventListener() { 
				public void onEvent(Event event) throws Exception {
					Events.postEvent(new Event("onCol4",Path.getComponent("//mypage/mywindow"), ((Treerow)event.getTarget().getParent()).getLabel() ));
				}
			});
		}
		tr.appendChild(t4); 
	
		
		if (!treeItem.isListenerAvailable(Events.ON_OPEN, true)) { 
			treeItem.addEventListener(1000,Events.ON_OPEN, new EventListener() { 
				public void onEvent(Event event) throws Exception {
					Treeitem ti=(Treeitem)event.getTarget();
					//ti.setSelected(true);
					DefaultTreeNode dtn=(DefaultTreeNode)ti.getValue();
					TestObject row = (TestObject)dtn.getData();
					row.open=(((OpenEvent)event).isOpen());
				}
			}); 			
		}
		
		treeItem.setOpen(row.open); 
		
		// With this we ensure the row can be opened after its updated
		DefaultTreeModel model = (DefaultTreeModel) treeItem.getTree().getModel();
		if (row.open)
			model.addOpenObject(data);		
		
		/*	
		 */
		
	}
}
