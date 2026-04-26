package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.example.Community;
import org.example.UserAccount;

public class CommunityTests extends BaseTest {

    @Before
    public void ensurePreconditions() {
        app.getNavigation().openLoginPage();

        UserAccount account = new UserAccount("mr.ruslanick@gmail.com", "20_Ruslan_05");
        app.getAuth().login(account);

    }

    @Test
    public void test1_createNewCommunityTestCase() throws InterruptedException {
        Thread.sleep(2000);
        app.getNavigation().openCommunitiesPage();

        int beforeCount = app.getCommunity().getCommunityCount();
        Community community = new Community("Сообщество_Тест", "Описа");

        app.getCommunity().createNewCommunity(community);
        Thread.sleep(2000);

        String actualName = app.getCommunity().getCreatedCommunityName();
        Assert.assertEquals(community.getName(), actualName);

        app.getNavigation().openCommunitiesPage();
        Thread.sleep(1000);

        int afterCount = app.getCommunity().getCommunityCount();
        Assert.assertEquals(beforeCount + 1, afterCount);
    }

    @Test
    public void test2_deleteCommunityTestCase() throws InterruptedException {
        app.getNavigation().openCommunitiesPage();
        Thread.sleep(1000);

        int beforeCount = app.getCommunity().getCommunityCount();

        Community community = new Community("To Delete", "Delet");
        app.getCommunity().createNewCommunity(community);
        Thread.sleep(2000);

        app.getCommunity().selectLastCreatedCommunity();
        app.getCommunity().deleteCommunity(community);

        Thread.sleep(2000);

        app.getNavigation().openCommunitiesPage();
        Thread.sleep(1000);

        int afterCount = app.getCommunity().getCommunityCount();
        Assert.assertEquals(beforeCount, afterCount);
    }
}