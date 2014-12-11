package support.component.tree;


import java.util.Iterator;
import java.util.Random;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Path;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Menupopup;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.Window;


public class TestComposer extends GenericForwardComposer {
	
	DefaultTreeModel mymodelA,mymodelB,mymodelC;
	private Tree myTreeA, myTreeB, myTreeC;
	Window window;
	
	public static int NUM_ROWS=50;
	public static boolean ALEATORY_LEAFS=true;
	public static int UPDATE_MILIS=30;
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
        if(!comp.getDesktop().isServerPushEnabled()){
        	comp.getDesktop().enableServerPush(true);
        }	
        window = (Window)Path.getComponent("//mypage/mywindow");

		myTreeA= (Tree) window.getFellow("myTreeA");
		 mymodelA=new DefaultTreeModel(new DefaultTreeNode(null,new DefaultTreeNode[] {}));
		fillTree(myTreeA,mymodelA,"A");
//		addPopupListener(myTreeA, window);
/*
		myTreeB= (Tree) window.getFellow("myTreeB");
		 mymodelB=new DefaultTreeModel(new DefaultTreeNode(null,new DefaultTreeNode[] {}));
		fillTree(myTreeB,mymodelB,"B");
//		addPopupListener(myTreeB, window);
		
		myTreeC= (Tree) window.getFellow("myTreeC");
		 mymodelC=new DefaultTreeModel(new DefaultTreeNode(null,new DefaultTreeNode[] {}));
		fillTree(myTreeC,mymodelC,"C");
//		addPopupListener(myTreeC, window);
*/
//		TestThread thread= new TestThread((Window)comp);
//		thread.start();
	}

	private void fillTree(Tree myTree, DefaultTreeModel mymodel, String treeName) {
		myTree.setItemRenderer(new TreeRendererTest());
		DefaultTreeNode rootNode=(DefaultTreeNode)mymodel.getRoot();
		for (int i=0;i<NUM_ROWS;i++) {
			TestObject test0=new TestObject();
			test0.col0="Row "+treeName+" "+i;
			test0.col1=new Integer(0);
			test0.col2=new Double(0);
			test0.col3=new Long(0);
			test0.col4=new Float(0);
			test0.open=false;
			test0.leaf=false;
			int iNumLeafs=newRandomInt(3);
			if (!ALEATORY_LEAFS || iNumLeafs>0) {
				TestObject test1=new TestObject();
				test1.col0="SubRow "+treeName+" "+i+ " X";
				test1.col1=new Integer(0);
				test1.col2=new Double(0);
				test1.col3=new Long(0);
				test1.col4=new Float(0);
				test1.open=false;
				test1.leaf=true;
				if (!ALEATORY_LEAFS || iNumLeafs>1) {
					TestObject test2=new TestObject();
					test2.col0="SubRow "+treeName+" "+i+ " Y";
					test2.col1=new Integer(0);
					test2.col2=new Double(0);
					test2.col3=new Long(0);
					test2.col4=new Float(0);
					test2.open=false;
					test2.leaf=true;
					rootNode.add(new DefaultTreeNode(test0,new DefaultTreeNode[] {
		    			new DefaultTreeNode(test1),
		    			new DefaultTreeNode(test2)
		    		}));
				} else {
					rootNode.add(new DefaultTreeNode(test0,new DefaultTreeNode[] {
			    			new DefaultTreeNode(test1)}));
				}
			} else {
				rootNode.add(new DefaultTreeNode(test0));
			}
		}
		myTree.setModel(mymodel);
	}
	
	public void onCol1(Event event){
		updateCol(event,1);
	}

	public void onCol2(Event event){
		updateCol(event,2);
	}
	
	public void onCol3(Event event){
		updateCol(event,3);
	}
	
	public void onCol4(Event event){
		updateCol(event,4);
	}
	
	public void updateCol(Event event, int col){
	    DefaultTreeNode rootNode;
	    String id=(String)event.getData();
	    if (id.startsWith("Row A") || id.startsWith("SubRow A")) {
			rootNode=(DefaultTreeNode)mymodelA.getRoot();
	    } else if (id.startsWith("Row B") || id.startsWith("SubRow B")) {
			rootNode=(DefaultTreeNode)mymodelB.getRoot();
	    } else if (id.startsWith("Row C") || id.startsWith("SubRow C")) {
			rootNode=(DefaultTreeNode)mymodelC.getRoot();
	    } else {
	    	System.out.println("ERROR id="+id);
	    	return;
	    }
		Iterator it=rootNode.getChildren().iterator();
		TestObject row;
		DefaultTreeNode node;
		while(it.hasNext()) {
			node= (DefaultTreeNode)it.next();
			row=(TestObject)node.getData();
			if (row.col0.equals(id)) {
				if (col==1) {
					row.col1=newRandomInt(100);
				} else if (col==2) {
					row.col2=newRandomDouble();
				} else if (col==3) {
					row.col3=newRandomLong();
				} else if (col==4) {
					row.col4=newRandomFloat();
				}
				node.setData(row);
				break;
			} else if (id.startsWith("Sub"+row.col0)) {
				DefaultTreeNode nodeSub;
				TestObject rowSub;
				for (int index = 0; index < node.getChildCount(); index++) {
					nodeSub=(DefaultTreeNode)node.getChildAt(index);
					rowSub=(TestObject)nodeSub.getData();
					if (rowSub.col0.equals(id)) {
						if (col==1) {
							rowSub.col1=newRandomInt(100);
						} else if (col==2) {
							rowSub.col2=newRandomDouble();
						} else if (col==3) {
							rowSub.col3=newRandomLong();
						} else if (col==4) {
							rowSub.col4=newRandomFloat();
						}
					}
					nodeSub.setData(rowSub);
		        }
			}
		}
	}
	
	public static int newRandomInt(int n) {
		Random randomGenerator = new Random();
	    return randomGenerator.nextInt(n);
	}
	
	public static long newRandomLong() {
		Random randomGenerator = new Random();
	    return randomGenerator.nextLong();
	}
	
	public static double newRandomDouble(){
		double MEAN = 100.0f; 
	    double VARIANCE = 5.0f;
		Random randomGenerator = new Random();
		return MEAN+randomGenerator.nextGaussian()*VARIANCE;
	}
	
	public static float newRandomFloat(){
		float MEAN = 100.0f; 
		float VARIANCE = 5.0f;
		Random randomGenerator = new Random();
		return MEAN+randomGenerator.nextFloat()*VARIANCE;
	}
	
	/*
	private void addPopupListener (Tree tree, final Window win) {
		tree.addEventListener("onItemContext", new EventListener () {
			public void onEvent (Event event) {
				if (event instanceof ForwardEvent) {
					event = Events.getRealOrigin((ForwardEvent)event);
				}
				Treeitem item = (Treeitem)event.getTarget();
				TestObject data = (TestObject)((DefaultTreeNode)item.getValue()).getData();

				Menupopup popup = (Menupopup)win.getFellow("mpp");
				popup.setWidth("300px");
				popup.getChildren().clear();

				Menuitem mnc=new Menuitem("Change Col1 "+data.col0);
				mnc.addEventListener(Events.ON_CLICK , new EventListener() { 
					public void onEvent(Event event) throws Exception {
						Events.postEvent(new Event("onCol1",win, ((Menuitem)event.getTarget()).getLabel().substring(12) ));
					}
				});
				popup.appendChild(mnc);

				Menuitem mnc2=new Menuitem("Change Col2 "+data.col0);
				mnc2.addEventListener(Events.ON_CLICK , new EventListener() { 
					public void onEvent(Event event) throws Exception {
						Events.postEvent(new Event("onCol2",win, ((Menuitem)event.getTarget()).getLabel().substring(12)));
					}
				});
				popup.appendChild(mnc2);
				popup.open(item);
			}
		});
	}
	*/
}
