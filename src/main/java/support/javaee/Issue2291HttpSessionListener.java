package support.javaee;

import javax.servlet.http.*;

public class Issue2291HttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		event.getSession().setAttribute("issue", "2291");
		System.out.println("set atribute issue:2291");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
