import org.junit.After;
import org.junit.Before;

public class BaseTest {
    protected ApplicationManager app;

    @Before
    public void setUp() throws Exception {
        app = new ApplicationManager();
    }

    @After
    public void tearDown() throws Exception {
        app.stop();
    }
}
