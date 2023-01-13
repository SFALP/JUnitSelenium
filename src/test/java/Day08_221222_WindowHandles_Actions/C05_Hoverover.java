package Day08_221222_WindowHandles_Actions;

import Utilities.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C05_Hoverover extends BaseTest {
    //Hoverover = uzerinde gezinme veya uzerine gelme anlamina gelir. Tiklanmak istenen bazi yerlere tiklanmadan once
    // fareyle ilgili bolumun uzerine gelip beklemek gerekebilir. Bu durumlarda Hoverover kullanilir.
    @Test
    public void hoverOver() throws InterruptedException {
        driver.get("https://www.amazon.com.tr/");
        WebElement accountsAndLists = driver.findElement(By.id("nav-link-accountList"));

        Actions actions = new Actions(driver);

        actions.
                moveToElement(accountsAndLists).
                click(driver.findElement(By.xpath("(//span[@class='nav-text'])[3]"))).
                perform();
        Thread.sleep(1500);
        Assert.assertEquals("Amazon Giriş Yap", driver.getTitle());
    }

}
