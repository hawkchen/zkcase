package support.component.grid;

import java.util.*;

import org.hamcrest.core.IsInstanceOf;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;

public class PagingTextboxComposer extends SelectorComposer<Component>{
	
	@Wire
	Grid myGrid;
	@Wire
	Combobox choiceBox;
	
	ListModel localModel;
	ListModel numberModel;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		localModel = new ListModelList<Locale>(Locale.getAvailableLocales());
		myGrid.setRowRenderer(new MyRender());
		myGrid.setModel(localModel);
		myGrid.renderAll();
		Integer number[] = new Integer[100];
		for (int i=0 ; i <100 ; i++){
			number[i]=i;
		}
		numberModel = new ListModelList<Integer>(number);
	}
	
	@Listen("onSelect = #choiceBox")
	public void changeModel(){
		if ("locale".equals(choiceBox.getSelectedItem().getValue())){
			myGrid.setModel(localModel);
		}else{
			myGrid.setModel(numberModel);
		}
		myGrid.renderAll();
	}
	
	class MyRender implements RowRenderer<Object>{


		@Override
		public void render(Row row, Object data, int index) throws Exception {
			row.appendChild(new Label(data.toString()));
			Textbox box = new Textbox();
			box.addEventListener(Events.ON_CHANGE, new EventListener<Event>() {

				@Override
				public void onEvent(Event event) throws Exception {
					if (event instanceof InputEvent){
						InputEvent e = (InputEvent)event;
						System.out.println (e.getValue());
					}
					
				}
			});
			row.appendChild(box);
		}
		
	}
}
