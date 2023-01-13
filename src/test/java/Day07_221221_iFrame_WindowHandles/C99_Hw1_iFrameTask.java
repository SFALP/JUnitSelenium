package Day07_221221_iFrame_WindowHandles;

import Utilities.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/*
Go to URL: http://demo.guru99.com/test/guru99home/
Find the number of iframes on the page.
Link to the fourth iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.
Exit the iframe and return to the main page.

 */
public class C99_Hw1_iFrameTask extends BaseTest {
    @Override
    public void tearDown() {
        //super.tearDown();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/guru99home/");

//Find the number of iframes on the page.
        List<WebElement> iFrame = driver.findElements(By.xpath("//iframe"));
        System.out.println("iFrame.size() = " + iFrame.size());
        Thread.sleep(2000);//Tedbiren 2sn bekletildi

//1. Cerez kabul edildi
        driver.switchTo().frame("gdpr-consent-notice");
        WebElement cerezOnay = driver.findElement(By.xpath("//span[text()='Tümünü Kabul Et']"));
        cerezOnay.click();

//Link to the fourth iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.
        driver.switchTo().frame("a077aa5e");
        WebElement clickNew = driver.findElement(By.xpath("//a[@href='http://www.guru99.com/live-selenium-project.html']"));
        clickNew.click();
        Thread.sleep(2000);//Tedbiren 2sn beklendi.
//Exit the iframe and return to the main page.
    //2.cerez isleminin kabul edilmesi islemi
        driver.findElement(By.xpath("//button[@class='fc-button fc-cta-consent fc-primary-button']")).click();

        driver.close();
        driver.switchTo().defaultContent();
    }
}