package support.security.xss;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Textbox;

public class XssDemo extends GenericForwardComposer {

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        Textbox box = new Textbox();
        box.setValue("</script foo=bar>");
        comp.appendChild(box);
    }
}
