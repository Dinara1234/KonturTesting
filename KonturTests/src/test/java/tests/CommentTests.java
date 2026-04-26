package tests;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.example.UserAccount;

public class CommentTests extends BaseTest {

    @Before
    public void ensurePreconditions() {
        app.getNavigation().openLoginPage();

        if (app.getAuth().isLoggedIn()) {
            return;
        }

        UserAccount account = new UserAccount("mr.ruslanick@gmail.com", "20_Ruslan_05");
        app.getAuth().login(account);
    }

    @Test
    public void createCommentTestCase() throws InterruptedException {
        app.getNavigation().openNewsPage();
        Thread.sleep(2000);
        String expectedComment = "лалалаgf";
        app.getComment().createComment(expectedComment);

        Thread.sleep(2000);
        String actualComment = app.getComment().getCreatedCommentText();

        Assert.assertEquals(expectedComment, actualComment);
    }
}