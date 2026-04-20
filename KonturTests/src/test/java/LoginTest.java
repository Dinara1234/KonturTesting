import org.junit.*;

public class LoginTest extends BaseTest {

    @Test
    public void loginTestCase() throws Exception {
        app.getNavigation().openLoginPage();
        UserAccount account = new UserAccount("mr.ruslanick@gmail.com", "20_Ruslan_05");
        app.getAuth().login(account);
    }

    @Test
    public void createCommentTestCase() throws Exception {
        app.getNavigation().openLoginPage();
        UserAccount account = new UserAccount("mr.ruslanick@gmail.com", "20_Ruslan_05");
        app.getAuth().login(account);

        app.getNavigation().openNewsPage();
        app.getContact().createComment("Комментарий");
    }

    @Test
    public void createNewCommunityTestCase() throws Exception {
        app.getNavigation().openLoginPage();
        UserAccount account = new UserAccount("mr.ruslanick@gmail.com", "20_Ruslan_05");
        app.getAuth().login(account);

        app.getNavigation().openCommunitiesPage();
        Community community = new Community("Сообщество", "Описа");
        app.getCommunity().createNewCommunity(community);
    }
}