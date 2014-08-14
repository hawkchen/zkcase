package support.mvvm;

import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.ListModelList;


public class FulfillVM {

	ListModelList<Screen> screenList  = null;

	@Init
	public void init(){
		this.screenList = new ListModelList<Screen>();
		screenList.add(new Screen("url 1"));
		screenList.add(new Screen("url 2"));
		screenList.add(new Screen("url 3"));
	}



	static public class Screen{
		String url ="default url";
		String name;

		public Screen(String url){
			this.url = url;
		}
		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

	}
	

	public ListModelList<Screen> getScreenList() {
		return screenList;
	}

	public void setScreenList(ListModelList<Screen> screenList) {
		this.screenList = screenList;
	}	
	
	@Command
	public void render(@BindingParam("target") Component target){
		Events.postEvent("onInitRender", target, null);
	}
}
