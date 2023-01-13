package Day09_221223_JSEScroll_Cookies_Files;

import Utilities.BaseTest;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class C01_ScrollActions extends BaseTest {

    @Test
    public void scrollPageUpDown() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Actions action = new Actions(driver);

        action.sendKeys(Keys.PAGE_DOWN).perform();//1 sayfa boyunca asagi iner
        Thread.sleep(1000);//Tedbiren 1sn beklenir

        action.sendKeys(Keys.PAGE_DOWN).perform();//1 sayfa boyunca asagi iner
        Thread.sleep(1000);//Tedbiren 1sn beklenir

        action.sendKeys(Keys.PAGE_UP).perform();//1 sayfa boyunca yukari cikar
        Thread.sleep(1000);//Tedbiren 1sn beklenir

        action.sendKeys(Keys.PAGE_UP).perform();//1 sayfa boyunca yukari cikar
        Thread.sleep(1000);//Tedbiren 1sn beklenir
    }

    @Test
    public void scrollArrowUpDown() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Actions act = new Actions(driver);
        Thread.sleep(2000);//Tedbiren 2sn beklenir


        act.sendKeys(Keys.ARROW_DOWN).perform();//1 ok hareketi kadar asagi iner.
        Thread.sleep(2000);//Tedbiren 2sn beklenir

        act.sendKeys(Keys.ARROW_DOWN).perform();//1 ok hareketi kadar asagi iner.
        Thread.sleep(2000);//Tedbiren 2sn beklenir

        act.sendKeys(Keys.ARROW_UP).perform();//1 ok hareketi kadar yukari cikar.
        Thread.sleep(2000);//Tedbiren 2sn beklenir

        act.sendKeys(Keys.ARROW_UP).perform();//1 ok hareketi kadar yukari cikar.
    }
}