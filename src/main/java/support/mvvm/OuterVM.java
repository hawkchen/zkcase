package support.mvvm;

import java.util.Locale;

import org.zkoss.bind.annotation.*;
import org.zkoss.zul.ListModelList;

public class OuterVM {

	private String bean = "apple";
	private ListModelList<Locale> model = new ListModelList<Locale>(Locale.getAvailableLocales());
	
	
	public ListModelList<Locale> getModel() {
		return model;
	}

	public String getBean() {
		return bean;
	}

	public void setBean(String bean) {
		this.bean = bean;
	}

	public InnerVM innerVM = new InnerVM(){
		
		@Init(superclass = true)
		public void init2(){
			System.out.println("init2");
		}
		
		@Override
		public void change() {
			System.out.println("override change");
		};
	};
	
	public InnerVM getInnerVm(){
		return innerVM;
	}
	
	@Command
	public void initTab(){
		System.out.print("inittab");
	}
}
