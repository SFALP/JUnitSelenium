package Practice_221224;

import Utilities.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

/*
    1- https://the-internet.herokuapp.com/context_menu sitesine gidelim.
    2- Çizili alan üzerinde sağ click yapalım.
    3- Alert'te çıkan yazının "You selected a context menu" olduğunu test edelim.
    4- Tamam diyerek Alert'i kapatalım.
    5- Elemental Selenium linkine tıklayalım.
    6- Açılan sayfada h1 tagında "Elemental Selenium" yazdığını test edelim.
 */
public class C07_Task07_RightClick_Alert extends BaseTest {
    @Override
    public void tearDown() {
//        super.tearDown();
    }

    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);

//Çizili alan üzerinde sağ click yapalım.
        WebElement box = driver.findElement(By.id("hot-spot"));
        actions.contextClick(box).perform();//sag click contextClick ile yapilir.

        actions.sendKeys(Keys.ESCAPE);
//Alert'te çıkan yazının "You selected a context menu" olduğunu test edelim.
        Assert.assertEquals(driver.switchTo().alert().getText(), "You selected a context menu");

//Tamam diyerek Alert'i kapatalım.
        driver.switchTo().alert().accept();
        actions.sendKeys(Keys.ESCAPE).perform();

//Elemental Selenium linkine tıklayalım.
        WebElement click1 = driver.findElement(By.xpath("//a[@target='_blank']"));
        click1.click();

//Açılan sayfada h1 tagında "Elemental Selenium" yazdığını test edelim.
        String firstPageHandle = driver.getWindowHandle();
        Set<String> allWindowPageHandle = driver.getWindowHandles();
        String secondPageHandle = "";

        for (String each : allWindowPageHandle) {
            if (!each.equals(firstPageHandle)) {
                secondPageHandle = each;
            }
        }
        driver.switchTo().window(secondPageHandle);
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Elemental Selenium", "İkinci sayfadaki text istenenden farklı.");
    }
}