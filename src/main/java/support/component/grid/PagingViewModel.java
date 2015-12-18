package support.component.grid;

import java.util.*;

import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.*;

public class PagingViewModel {
	
	@Wire
	private Grid gridSaldiGiornalieri;
	
	private int totalSize = 26;
	ListModelList list = new ListModelList();
	List dataList = new LinkedList();
	private int pageSize = 5;
	private int activePage = 0;
	List<String> columnList = new LinkedList();
	

	@Init
	public void init() {
		for (int i = 0; i < totalSize ; i++){
			list.add("row "+i);
		}
		for (int i = 0; i < 20 ; i++){
			columnList.add("col "+i);
		}
	}
	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
//		displayOnlyInError = false;
	}
	
	
	@Command 
    @NotifyChange({"activePge", "list"}) 
    public void paging(){        
		updateList();
		Columns columns = gridSaldiGiornalieri.getColumns();
		gridSaldiGiornalieri.removeChild(columns);
		columns = new Columns();

		Column employeeColumn = new Column();
		employeeColumn.setWidth("200px");
		employeeColumn.setLabel("stampings.employee");

		columns.appendChild(employeeColumn);

		for (String giornata : columnList) {
			Column newColumn = new Column();
			newColumn.setLabel(giornata);
			newColumn.setWidth("75px");

			columns.appendChild(newColumn);
		}

		gridSaldiGiornalieri.appendChild(columns);
    }
	
	@Command
	public void addFirst(){
		String element = "first";
		list.add(0, element);
		list.addToSelection(element);
	}
	
	public ListModel getList(){
		return list;
	}
	
	private void updateList(){
		int start = activePage * pageSize;
		int end = start + pageSize > dataList.size()-1 ? dataList.size() : start + pageSize; 
		list = new ListModelList(dataList.subList(start, end));
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getActivePage() {
		return activePage;
	}

	public void setActivePage(int activePage) {
		this.activePage = activePage;
	}

	public List getColumns() {
		return columnList;
	}

	public void setColumns(List columns) {
		this.columnList = columns;
	}
	public List<String> getColumnList() {
		return columnList;
	}
}
