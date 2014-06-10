package support.queue;

import org.junit.*;
import org.zkoss.zats.mimic.*;
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
 
    //fail to test with server push
    @Test
    public void test() {
        DesktopAgent desktop = Zats.newClient().connect("/server-push/long.zul");
        ComponentAgent button = desktop.query("button");
        button.click();
//        org.zkoss.lang.Threads.sleep(9000);
        ComponentAgent label =  desktop.query("label");
        Assert.assertEquals("Success", label.as(Label.class).getValue());
    }
}
