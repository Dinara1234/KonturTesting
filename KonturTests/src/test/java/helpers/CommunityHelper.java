package helpers;
import appmanager.ApplicationManager;
import org.example.Community;
import org.openqa.selenium.By;


public class CommunityHelper extends HelperBase {

    public CommunityHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createNewCommunity(Community community) {
        initCommunityCreation();
        fillCommunityForm(community);
        submitCommunityCreation();
    }

    public void initCommunityCreation() {
        driver.findElement(By.xpath("//div[@id='root']/section/section[2]/section/div[2]/span/button")).click();
    }

    public void fillCommunityForm(Community community) {
        driver.findElement(By.xpath("//textarea")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Название'])[1]/following::textarea[1]")).clear();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Название'])[1]/following::textarea[1]")).sendKeys(community.getName());

        driver.findElement(By.xpath("//div[4]/label/div/div/textarea")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Краткое описание'])[1]/following::textarea[1]")).clear();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Краткое описание'])[1]/following::textarea[1]")).sendKeys(community.getDescription());
    }

    public void submitCommunityCreation() {

        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Краткое описание'])[1]/following::span[3]")).click();
    }


    public void selectLastCreatedCommunity() {
        driver.findElement(By.xpath("//div[@id='root']/section/section[2]/div/span/section/div/div[2]/div[4]/div/span/label/div/div/textarea")).click();
        driver.findElement(By.xpath("//div[@id='root']/section/section[2]/div/span/section/div")).click();
    }

    public void deleteCommunity(Community community) {
        driver.findElement(By.xpath("//div[@id='root']/section/section[2]/div/span/section/div/div[2]/div[3]")).click();
        driver.findElement(By.xpath("//div[@id='root']/section/section[2]/div/span/section/div[2]/div/button")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Вы действительно хотите удалить «" + community.getName() + "»?'])[1]/following::div[10]")).click();
    }

    public String getCreatedCommunityName() {
        return driver.findElement(By.xpath("//div[@id='root']/section/section[2]/div/span/section/div/div[2]/div[4]/div/span/label/div/div/textarea"))
                .getAttribute("value");
    }

    public int getCommunityCount() {
        String text = driver.findElement(By.xpath("//div[@id='root']/section/section[2]/div/div/section/div/span")).getText();
        String numberOnly = text.replaceAll("[^0-9]", "");

        if (numberOnly.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(numberOnly);
    }
}