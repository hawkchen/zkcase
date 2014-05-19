package support.push;

import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.util.DesktopInit;
/**
 * Not work.
 * java.lang.NullPointerException
	at org.zkoss.zk.ui.impl.UiEngineImpl.addResponse(UiEngineImpl.java:330)
	at org.zkoss.zk.ui.impl.AbstractExecution.addAuResponse(AbstractExecution.java:402)
	at org.zkoss.zk.ui.util.Clients.response(Clients.java:60)
	at org.zkoss.zkex.ui.comet.CometServerPush.startClientPush(CometServerPush.java:87)
	at org.zkoss.zkex.ui.comet.CometServerPush.start(CometServerPush.java:148)
	at org.zkoss.zkmax.ui.comet.CometServerPush.start(CometServerPush.java:74)
	at org.zkoss.zk.ui.impl.DesktopImpl.enableServerPush0(DesktopImpl.java:1431)
	at org.zkoss.zk.ui.impl.DesktopImpl.enableServerPush(DesktopImpl.java:1385)
	at org.zkoss.zk.ui.impl.DesktopImpl.enableServerPush(DesktopImpl.java:1370)
	at org.zkoss.zk.ui.impl.DesktopImpl.enableServerPush(DesktopImpl.java:1366)
	at support.push.EnableServerPush.init(EnableServerPush.java:10)
	at org.zkoss.zk.ui.util.Configuration.invokeDesktopInits(Configuration.java:835)
	at org.zkoss.zk.ui.impl.DesktopImpl.<init>(DesktopImpl.java:267)
	at org.zkoss.zk.ui.impl.AbstractUiFactory.newDesktop(AbstractUiFactory.java:85)
	at org.zkoss.zk.ui.http.WebManager.newDesktop(WebManager.java:485)
	at org.zkoss.zk.ui.http.WebManager.getDesktop(WebManager.java:466)
	at org.zkoss.zk.ui.http.DHtmlLayoutServlet.process(DHtmlLayoutServlet.java:187)
	at org.zkoss.zk.ui.http.DHtmlLayoutServlet.doGet(DHtmlLayoutServlet.java:136)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:707)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:820)
	at org.mortbay.jetty.servlet.ServletHolder.handle(ServletHolder.java:511)
	at org.mortbay.jetty.servlet.ServletHandler.handle(ServletHandler.java:401)
	at org.mortbay.jetty.security.SecurityHandler.handle(SecurityHandler.java:216)
	at org.mortbay.jetty.servlet.SessionHandler.handle(SessionHandler.java:182)
	at org.mortbay.jetty.handler.ContextHandler.handle(ContextHandler.java:766)
	at org.mortbay.jetty.webapp.WebAppContext.handle(WebAppContext.java:450)
	at org.mortbay.jetty.handler.HandlerWrapper.handle(HandlerWrapper.java:152)
	at org.mortbay.jetty.Server.handle(Server.java:326)
	at org.mortbay.jetty.HttpConnection.handleRequest(HttpConnection.java:542)
	at org.mortbay.jetty.HttpConnection$RequestHandler.headerComplete(HttpConnection.java:928)
	at org.mortbay.jetty.HttpParser.parseNext(HttpParser.java:549)
	at org.mortbay.jetty.HttpParser.parseAvailable(HttpParser.java:212)
	at org.mortbay.jetty.HttpConnection.handle(HttpConnection.java:404)
	at org.mortbay.io.nio.SelectChannelEndPoint.run(SelectChannelEndPoint.java:410)
	at org.mortbay.thread.QueuedThreadPool$PoolThread.run(QueuedThreadPool.java:582)
 * @author Hawk
 *
 */
public class EnableServerPush implements DesktopInit {

	@Override
	public void init(Desktop desktop, Object request) throws Exception {
		desktop.enableServerPush(true);
		System.out.println("enable server push");
	}

}
