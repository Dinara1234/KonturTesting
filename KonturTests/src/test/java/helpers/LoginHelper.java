package helpers;

import org.example.UserAccount;
import org.openqa.selenium.By;
import appmanager.ApplicationManager;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager manager) {
        super(manager);
    }

    public void login(UserAccount account) {
        if (!isElementPresent(By.id("Username"))) {
            return;
        }
        driver.findElement(By.id("Username")).clear();
        driver.findElement(By.id("Username")).sendKeys(account.getUsername());

        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys(account.getPassword());

        driver.findElement(By.name("button")).click();
    }

    public boolean isLoggedIn() {
        return !isElementPresent(By.id("Username"));
    }

    public void logout() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    public String getLoggedInUserName() {

        return driver.findElement(By.xpath("//div[@id='root']/section/section[2]/section/div/div[2]/div")).getText();
    }

    public String getLoggedInUserEmail() {

        return driver.findElement(By.xpath("//div[@id='root']/section/section[2]/section[2]/div[2]/div/div/span/a/div")).getText();
    }
}
