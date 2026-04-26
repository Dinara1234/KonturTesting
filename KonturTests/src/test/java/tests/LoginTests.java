package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.example.UserAccount;

public class LoginTests extends BaseTest {

    @Before
    public void ensurePreconditions() {
        app.getNavigation().openLoginPage();

        if (app.getAuth().isLoggedIn()) {
            app.getAuth().logout();
            app.getNavigation().openLoginPage();
        }
    }

    @Test
    public void testValidLogin() throws InterruptedException {
        UserAccount account = new UserAccount("mr.ruslanick@gmail.com", "20_Ruslan_05");

        app.getAuth().login(account);

        Thread.sleep(2000);

        app.getNavigation().openProfilePage();
        Thread.sleep(1000);
        String actualName = app.getAuth().getLoggedInUserName();
        String actualEmail = app.getAuth().getLoggedInUserEmail();

        Assert.assertEquals("Валеев Руслан Тимурович", actualName);
        Assert.assertEquals("mr.ruslanick@gmail.com", actualEmail);
    }
}