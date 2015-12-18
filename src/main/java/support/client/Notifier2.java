package support.client;



import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.DesktopUnavailableException;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Window;

public class Notifier2 extends SelectorComposer<Window>implements EventListener<Event> {

	private Desktop desktop;

	@Override
	public void doAfterCompose(Window comp) throws Exception {
		super.doAfterCompose(comp);
		this.desktop = Executions.getCurrent().getDesktop();
		Executions.getCurrent().getDesktop().enableServerPush(true);

		Clients.showBusy(getSelf(), "I am busy2");
		final Thread t = new Thread(new Runner());
		t.start();
	}

	/**
	 * Second thread, do nothing only wait 1ms and report the a result.
	 *
	 * @author PPI AG Informationstechnologie
	 * @version $Revision$
	 */
	private class Runner implements Runnable {
		public void run() {
			try {
				Thread.sleep(1);
				reportResult();
			} catch (final InterruptedException e) {
			}
		}
	}

	/**
	 * Report a result called by creating an event by worker-thread.
	 *
	 * @throws InterruptedException
	 * @throws DesktopUnavailableException
	 */
	private void reportResult() throws DesktopUnavailableException, InterruptedException {
		Executions.schedule(desktop, this, new Event("ready2"));
	}

	/**
	 * Clear the busy marker. Executed on gui-thread. Scheduled by
	 * {@link #reportResult()}.
	 */
	@Override
	public void onEvent(Event ev) throws Exception {
		System.out.println("clear busy 2");
		Clients.clearBusy(getSelf());
	}
}
