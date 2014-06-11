package support.queue;

import org.junit.*;
import org.zkoss.zats.mimic.*;
import org.zkoss.zats.mimic.operation.*;
import org.zkoss.zul.Label;

public class LongOperationTest {
    @BeforeClass
    public static void init() {
        Zats.init("./src/main/webapp"); 
    }
 
    @AfterClass
    public static void end() {
        Zats.end();
    }
 
    @After
    public void after() {
        Zats.cleanup();
    }
 
    @Test
    public void test() {
        DesktopAgent desktop = Zats.newClient().connect("/server-push/long.zul");
        ComponentAgent button = desktop.query("button");
        button.click(); //trigger long operation
        
        AuData dummyData = new AuData("dummy");
        /*
         * Send dummy AU request to simulate polling 
         * and keep checking expected result until time out.
         * Time out period depends on your environment
         */
        for (int i=0; i < 10 ; i++){  
        	button.as(AuAgent.class).post(dummyData);
        	org.zkoss.lang.Threads.sleep(500);
        	ComponentAgent label =  desktop.query("label");
        	//assert expected status then break
        	if ( label != null){
        		Assert.assertEquals("success", label.as(Label.class).getValue());
        		break;
        	}
        }
    }
}
