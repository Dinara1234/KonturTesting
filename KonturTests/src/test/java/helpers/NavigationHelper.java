package helpers;
import appmanager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigationHelper extends HelperBase {
    private String baseUrl;

    public NavigationHelper(ApplicationManager manager, String baseUrl) {
        super(manager);
        this.baseUrl = baseUrl;
    }

    public void openLoginPage() {
        driver.get("https://staff-testing.testkontur.ru");
    }

    public void openNewsPage() {
        driver.get("https://staff-testing.testkontur.ru/news");
    }

    public void openCommunitiesPage() {
        driver.get("https://staff-testing.testkontur.ru/communities");
    }

    public void openProfilePage() {

        driver.findElement(By.xpath("//div[@id='root']/div/header/div/div[3]/div/div/div/div/span/button/div/span")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement profileMenuButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(), 'Мой профиль')]")
        ));

        profileMenuButton.click();
    }
}
