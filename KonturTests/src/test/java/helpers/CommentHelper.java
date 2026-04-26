package helpers;

import appmanager.ApplicationManager;
import org.openqa.selenium.By;

public class CommentHelper extends HelperBase {

    public CommentHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createComment(String commentText) {
        driver.findElement(By.xpath("//div[@id='root']/section/section[2]/div/section[2]/div[2]/div/div[3]/div[2]/label/span[2]/input")).click();

        driver.findElement(By.xpath("//div[@id='root']/section/section[2]/div/section[2]/div[2]/div/div[3]/span/div/div[2]/span/label/div/div/textarea")).clear();
        driver.findElement(By.xpath("//div[@id='root']/section/section[2]/div/section[2]/div[2]/div/div[3]/span/div/div[2]/span/label/div/div/textarea")).sendKeys(commentText);

        driver.findElement(By.xpath("//div[@id='root']/section/section[2]/div/section[2]/div[2]/div/div[3]/span/div/div[2]/div/div/div/div[2]/div/span/span/button")).click();
    }

    public String getCreatedCommentText() {
        return driver.findElement(By.xpath("//div[@id='root']/section/section[2]/div/section[2]/div[2]/div/div[3]/div/div/div/div/div[2]")).getText();
    }
}
