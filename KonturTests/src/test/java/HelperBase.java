import org.openqa.selenium.WebDriver;


import org.openqa.selenium.*;


public class HelperBase {
    protected ApplicationManager manager;
    protected WebDriver driver;

    public HelperBase(ApplicationManager manager) {
        this.manager = manager;
        this.driver = manager.getDriver();
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}