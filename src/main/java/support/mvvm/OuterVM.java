package support.mvvm;

import org.zkoss.bind.annotation.Init;

public class OuterVM {

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
}
