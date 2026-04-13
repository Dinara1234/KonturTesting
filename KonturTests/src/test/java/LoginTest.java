import org.junit.*;

public class LoginTest extends BaseTest{

    @Test
    public void loginTestCase() throws Exception {
        //ERROR: Caught exception [unknown command []]
        openLoginPage();
        UserAccount account = new UserAccount("mr.ruslanick@gmail.com", "20_Ruslan_05");
        login(account);
    }


    @Test
    public void createCommentTestCase() throws Exception {
        //ERROR: Caught exception [unknown command []]
        openLoginPage();
        UserAccount account = new UserAccount("mr.ruslanick@gmail.com", "20_Ruslan_05");
        login(account);
        openNewsPage();
        createComment("Комментарий");
    }


    @Test
    public void createNewCommunityTestCase() throws Exception {
        //ERROR: Caught exception [unknown command []]
        openLoginPage();
        UserAccount account = new UserAccount("mr.ruslanick@gmail.com", "20_Ruslan_05");
        login(account);
        openCommunitiesPage();
        Community community = new Community("Сообщество", "cjj,o");
        createNewCommunity(community);
    }









}
