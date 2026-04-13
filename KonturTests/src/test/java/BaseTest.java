import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.fail;

public class BaseTest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        js = (JavascriptExecutor) driver;
    }

    public void openLoginPage() throws Exception {
        //ERROR: Caught exception [unknown command []]
        driver.get("https://staff-testing.testkontur.ru");
    }
    public void openNewsPage() throws Exception {
        //ERROR: Caught exception [unknown command []]
        driver.get("https://staff-testing.testkontur.ru/news");
    }
    public void openCommunitiesPage() throws Exception {
        //ERROR: Caught exception [unknown command []]
        driver.get("https://staff-testing.testkontur.ru/communities");
    }

    public void login(UserAccount account) throws Exception {
        driver.findElement(By.id("Username")).click();
        driver.findElement(By.id("Username")).clear();
        driver.findElement(By.id("Username")).sendKeys(account.getUsername());
        driver.findElement(By.id("Password")).click();
        driver.findElement(By.xpath("//div/div")).click();
        driver.findElement(By.id("Password")).click();
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys(account.getPassword());
        driver.findElement(By.name("button")).click();
    }

    public void createComment(String comment) {
        driver.findElement(By.xpath("//div[@id='root']/section/section[2]/div/section[2]/div[2]/div/div[3]/div[2]/label/span[2]/input")).click();
        driver.findElement(By.xpath("//div[@id='root']/section/section[2]/div/section[2]/div[2]/div/div[3]/span/div/div[2]/span/label/div/div/textarea")).clear();
        driver.findElement(By.xpath("//div[@id='root']/section/section[2]/div/section[2]/div[2]/div/div[3]/span/div/div[2]/span/label/div/div/textarea")).sendKeys(comment);

    }

    public void createNewCommunity(Community community) throws Exception {
        driver.findElement(By.xpath("//div[@id='root']/section/section/div/div/a[4]/span")).click();
        driver.findElement(By.xpath("//div[@id='root']/section/section[2]/section/div[2]/span/button")).click();
        driver.findElement(By.xpath("//textarea")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Название'])[1]/following::textarea[1]")).clear();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Название'])[1]/following::textarea[1]")).sendKeys(community.getName());
        driver.findElement(By.xpath("//div[4]/label/div/div/textarea")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Новое сообщество'])[1]/following::div[1]")).click();
        driver.findElement(By.xpath("//div[4]/label/div/div/textarea")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Краткое описание'])[1]/following::textarea[1]")).clear();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Краткое описание'])[1]/following::textarea[1]")).sendKeys(community.getDescription());
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Новое сообщество'])[1]/following::div[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Краткое описание'])[1]/following::textarea[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='" + community.getDescription() + "'])[2]/following::span[3]")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
