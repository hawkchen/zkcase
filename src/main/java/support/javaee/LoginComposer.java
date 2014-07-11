package support.javaee;

import java.io.FileNotFoundException;

import org.zkoss.zk.ui.*;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;

public class LoginComposer extends SelectorComposer {

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		System.out.println(Executions.getCurrent().getSession());
	}

	@Listen("onClick = #login")
	public void login() throws FileNotFoundException{
		Executions.getCurrent().getSession().setAttribute("me", "pass");
//		Executions.sendRedirect("/javaee/showSession.zul");
		Executions.sendRedirect("http://localhost:8080/zkcase/javaee/showSession.zul");
		return;
	}
}
