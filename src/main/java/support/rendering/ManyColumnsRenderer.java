package support.rendering;

import org.zkoss.zul.*;

public class ManyColumnsRenderer extends Row implements RowRenderer<String> {
	private static final int COLUMN_COUNT = 20;

	@Override
	public void render(Row row, String data, int index) {
		Cell indexCell = new Cell();
		indexCell.appendChild(new Label(Integer.toString(index)));
		row.appendChild(indexCell);
		for (int n=0 ; n<COLUMN_COUNT ; n++){
			Cell labelCell = new Cell();
			Label label = new Label(data);
//			label.setStyle("word-wrap:break-word");
			labelCell.appendChild(label);
			row.appendChild(labelCell);
		}
	}
}
