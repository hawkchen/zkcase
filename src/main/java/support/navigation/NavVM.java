package support.navigation;

import org.zkoss.bind.annotation.*;
import org.zkoss.zul.*;

public class NavVM {
	
	private String contentSrc;
	
	
	public String getContentSrc() {
		return contentSrc;
	}

	public void setContentSrc(String contentSrc) {
		this.contentSrc = contentSrc;
	}


	@GlobalCommand
	@NotifyChange("contentSrc")
	public void nav(@BindingParam("src") String src){
		this.contentSrc = src;
	}

	
	

}
