package support.navigation;


public class Node {
	
	String src;
	String label;

	public Node(String src, String label) {
		this.src = src;
		this.label = label;
	}
	
	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
