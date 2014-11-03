package support.macro;


import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;

public class UseMacroComposer extends SelectorComposer<Window> {
	
	@Wire("barcodebox")
	Barcodebox barcodebox;
	@Wire
	Label barcodeLabel;
	
	@Listen("onClick = #openButton")
	public void open(){
		barcodebox.setVisible(true);
	}
	
	@Listen("onOK = barcodebox")
	public void ok(){
		barcodeLabel.setValue(barcodebox.getValue());
	}
}
