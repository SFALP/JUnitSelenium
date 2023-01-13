package Day09_221223_JSEScroll_Cookies_Files;

import Utilities.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;

/*
https://api.jquery.com/ sitesine gidelim
arama alanina json yazalim
Enter islemini robot class kullanrak yapalim
 */
public class C99_RobotClass_Hw extends BaseTest {
    @Override
    public void tearDown() {
//        super.tearDown();
    }

    @Test
    public void test01() throws AWTException {
        driver.get("https://api.jquery.com/");
//arama alanina json yazalim

        WebElement search= driver.findElement(By.name("s"));
        search.click();

        search.sendKeys("json");

//Enter islemini robot class kullanrak yapalim
        Robot rbt=new Robot();
        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);
    }
}