package support.mvvm;

import org.zkoss.bind.*;
import org.zkoss.zk.ui.Executions;

public class CommandPhaseListener implements PhaseListener {

	@Override
	public void prePhase(Phase phase, BindContext ctx) {
		if (phase== Phase.COMMAND){
			Executions.getCurrent().setAttribute("command", ctx.getCommandName());
			System.out.println(ctx.getCommandName());
		}
	}

	@Override
	public void postPhase(Phase phase, BindContext ctx) {
		
	}

}
