import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {
    private WebDriver driver;
    private String baseUrl;

    private NavigationHelper navigation;
    private LoginHelper auth;
    private CommunityHelper community;
    private CommentHelper comment;

    public ApplicationManager() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseUrl = "https://staff-testing.testkontur.ru";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        auth = new LoginHelper(this);
        navigation = new NavigationHelper(this, baseUrl);
        community = new CommunityHelper(this);
        comment = new CommentHelper(this);
    }

    public void stop() {
        driver.quit();
    }

    public WebDriver getDriver() { return driver; }
    public NavigationHelper getNavigation() { return navigation; }
    public LoginHelper getAuth() { return auth; }
    public CommunityHelper getCommunity() { return community; }
    public CommentHelper getContact() { return comment; }
}