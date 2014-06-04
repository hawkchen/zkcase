package support.navigation;

import org.zkoss.bind.annotation.*;
import org.zkoss.zul.*;

public class ClientVM {
	
	private String contentSrc;
	
//	private TreeModel<TreeMenuNode> treeModel;
	private ListModelList<Node> model = new ListModelList<Node>();
	
	@Init
	public void init(){
		
		/*
		 * Default Content Include
		 */
		
		this.contentSrc = "/navigation/clientNotes.zul";		
		
		/*
		 * Client Tree Menu
			
		TreeMenuNode root = new TreeMenuNode(null, 0, "Client");	
			
		TreeMenuNode detailsNode = new TreeMenuNode(root, 0, "Details");
		detailsNode.setSelected(true);
		detailsNode.setSrc("/client/clientDetail.zul");
		root.appendChild(detailsNode);
		
		TreeMenuNode accountsNode = new TreeMenuNode(root, 0, "Accounts");		
		root.appendChild(accountsNode);
		
		TreeMenuNode bankAccountsNode = new TreeMenuNode(root, 0, "Bank Accounts");		
		root.appendChild(bankAccountsNode);
		
		TreeMenuNode contactsNode = new TreeMenuNode(root, 0, "Contacts");		
		root.appendChild(contactsNode);		
		
		TreeMenuNode notesNode = new TreeMenuNode(root, 0, "Notes");		
		notesNode.setSrc("/client/clientNotes.zul");
		root.appendChild(notesNode);				
		
		this.setTreeModel(new TreeMenuModel(root));
		 */
		model.add(new Node("/navigation/clientDetails.zul", "details"));
		model.add(new Node("/navigation/clientNotes.zul", "notes"));
	}
	
	@Command
	@NotifyChange(".")
	public void content(@BindingParam("src") String src){
		
		this.contentSrc = src;
		System.out.println(this.contentSrc);
		
	}

	public String getContentSrc() {
		return contentSrc;
	}

	public void setContentSrc(String contentSrc) {
		this.contentSrc = contentSrc;
	}

	public ListModelList<Node> getModel() {
		return model;
	}

	public void setModel(ListModelList<Node> model) {
		this.model = model;
	}

//	public TreeModel<TreeMenuNode> getTreeModel() {
//		return treeModel;
//	}
//
//	public void setTreeModel(TreeModel<TreeMenuNode> treeModel) {
//		this.treeModel = treeModel;
//	}
	
	@Command
	@NotifyChange("model")
	public void resetModel(){
		System.out.println("reset model");
	}
}
