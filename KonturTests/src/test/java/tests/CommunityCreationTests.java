package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.Community;
import org.example.UserAccount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class CommunityCreationTests extends BaseTest {

    private Community community;

    public CommunityCreationTests(Community community) {
        this.community = community;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> communitiesFromXmlFile() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();

        List<Community> list = xmlMapper.readValue(
                new File("communities.xml"),
                new TypeReference<List<Community>>() {}
        );

        List<Object[]> parameters = new ArrayList<>();
        for (Community c : list) {
            parameters.add(new Object[]{c});
        }
        return parameters;
    }


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
    public void createNewCommunityTestCase() throws InterruptedException {
        Thread.sleep(2000);
        app.getNavigation().openCommunitiesPage();

        int beforeCount = app.getCommunity().getCommunityCount();

        app.getCommunity().createNewCommunity(this.community);

        Thread.sleep(2000);

        String actualName = app.getCommunity().getCreatedCommunityName();
        Assert.assertEquals(this.community.getName(), actualName);

        app.getNavigation().openCommunitiesPage();
        Thread.sleep(1000);

        int afterCount = app.getCommunity().getCommunityCount();
        Assert.assertEquals(beforeCount + 1, afterCount);
    }
}
