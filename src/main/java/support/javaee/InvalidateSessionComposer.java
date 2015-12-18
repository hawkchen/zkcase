package support.javaee;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;

public class InvalidateSessionComposer extends SelectorComposer {

	@Listen("onClick = #i")
	public void invalidate(){
		/*
		HttpServletRequest vRequest = (HttpServletRequest)Executions.getCurrent().getNativeRequest();
		HttpSession vSession = vRequest.getSession(true);
		
		//after the password has been changed, invalidate the current session and create a new session
//		vSession.invalidate();
		Sessions.getCurrent().invalidate();
		

//		vSession = vRequest.getSession(true);
		Sessions.getCurrent().setAttribute("username", "john");
		vSession.setAttribute("email", "john@mobile-data.co.za");
		vSession.setAttribute("fullname", "john doe");
		vSession.setAttribute("cellphone", "27834545678");
		Executions.sendRedirect(null);
		*/
	}
	
	@Listen("onClick = #b")
	public void print(){
		System.out.println(Sessions.getCurrent());
		System.out.println(Sessions.getCurrent().getAttribute("username"));
	}
}
