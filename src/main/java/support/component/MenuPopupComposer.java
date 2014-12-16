package support.component;


import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;

public class MenuPopupComposer extends SelectorComposer<Component> {

	@Wire
	Menupopup contextMenu;
	
	@Listen("onRightClick = #win")
	public void rightClickWindow() throws InterruptedException{
		for (Component child: contextMenu.getChildren()){
			if (child instanceof Menuitem){
				Menuitem menuitem = (Menuitem)child;
				//switch enable status to simulate user's code
				menuitem.setDisabled(!menuitem.isDisabled());
			}
		}
		contextMenu.open(contextMenu);
		Thread.sleep(100);
	}
	
	@Listen("onOpen = #contextMenu")
	public void openMenuPopup( ) throws InterruptedException{
		Thread.sleep(100);
	}
	
}

