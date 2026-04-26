package tests;

import org.junit.Before;
import appmanager.ApplicationManager;

public class BaseTest {
    protected ApplicationManager app;

    @Before
    public void setUp() {
        app = ApplicationManager.getInstance();
    }

}
