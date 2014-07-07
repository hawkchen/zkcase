package support.rendering;

import org.zkoss.zul.*;

public class ManyCellsRenderer implements ListitemRenderer<String> {

	@Override
	public void render(Listitem item, String data, int index) throws Exception {
		// TODO Auto-generated method stub
		for (int i=0; i<30 ; i++){
			Listcell cell = new Listcell();
			cell.appendChild(new Label(data));
			item.appendChild(cell);
		}
		Thread.sleep(50);
	}
	

}
