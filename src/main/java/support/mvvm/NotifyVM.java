package support.mvvm;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.*;
import org.zkoss.zul.ListModelList;


public class NotifyVM {

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
	
	@GlobalCommand
	public void updateScreen(@BindingParam("url") String url) {

		//            int index = this.screenList.indexOf(this.selectedScreen);
		int index  = 1;

		Screen screen = this.screenList.get(index);
//		screen.setScreenName(name);
		screen.setUrl("url "+System.currentTimeMillis());

//		this.screenList.set(index, screen);
		screenList.remove(index);
		screenList.add(0,screen);
//		BindUtils.postNotifyChange(null, null, screen, "*");
//		BindUtils.postNotifyChange(null, "application", screen, "*");
		return;
	}

	public ListModelList<Screen> getScreenList() {
		return screenList;
	}

	public void setScreenList(ListModelList<Screen> screenList) {
		this.screenList = screenList;
	}	
}
