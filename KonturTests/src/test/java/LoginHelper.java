import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager manager) {
        super(manager);
    }

    public void login(UserAccount account) {
        driver.findElement(By.id("Username")).click();
        driver.findElement(By.id("Username")).clear();
        driver.findElement(By.id("Username")).sendKeys(account.getUsername());
        driver.findElement(By.id("Password")).click();
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys(account.getPassword());
        driver.findElement(By.name("button")).click();
    }
}
