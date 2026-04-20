import org.openqa.selenium.*;

public class CommunityHelper extends HelperBase {

    public CommunityHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createNewCommunity(Community community) {
        driver.findElement(By.xpath("//div[@id='root']/section/section/div/div/a[4]/span")).click();
        driver.findElement(By.xpath("//div[@id='root']/section/section[2]/section/div[2]/span/button")).click();
        driver.findElement(By.xpath("//textarea")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Название'])[1]/following::textarea[1]")).clear();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Название'])[1]/following::textarea[1]")).sendKeys(community.getName());
        driver.findElement(By.xpath("//div[4]/label/div/div/textarea")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Краткое описание'])[1]/following::textarea[1]")).clear();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Краткое описание'])[1]/following::textarea[1]")).sendKeys(community.getDescription());
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='" + community.getDescription() + "'])[2]/following::span[3]")).click();
    }
}