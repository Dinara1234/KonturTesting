package appmanager;

import helpers.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class ApplicationManager {
    private static ThreadLocal<ApplicationManager> app = new ThreadLocal<>();

    private WebDriver driver;
    private String baseUrl;

    private NavigationHelper navigation;
    private LoginHelper auth;
    private CommunityHelper community;
    private CommentHelper comment;

    private ApplicationManager() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseUrl = "https://staff-testing.testkontur.ru";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        auth = new LoginHelper(this);
        navigation = new NavigationHelper(this, baseUrl);
        community = new CommunityHelper(this);
        comment = new CommentHelper(this);
    }

    public static ApplicationManager getInstance() {
        if (app.get() == null) {
            ApplicationManager newInstance = new ApplicationManager();
            newInstance.getNavigation().openLoginPage();
            app.set(newInstance);
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    newInstance.getDriver().quit();
                } catch (Exception e) {

                }
            }));
        }
        return app.get();
    }

    public WebDriver getDriver() { return driver; }
    public NavigationHelper getNavigation() { return navigation; }
    public LoginHelper getAuth() { return auth; }
    public CommunityHelper getCommunity() { return community; }
    public CommentHelper getComment() { return comment; }
}