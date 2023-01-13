package Day09_221223_JSEScroll_Cookies_Files;

import Utilities.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
/*

            executeScript("window.scrollBy(x-piksel,y-piksel)");  ya da js.executeScript("scroll(x,y);");
            x-piksel x eksenindeki sayıdır, sayı pozitifse sola, sayı negatifse saga hareket eder.
            y-piksel y eksenindeki sayıdır, sayı pozitifse ise aşağı doğru,sayı negatif ise yukarı doğru hareket eder.
            js.executeScript("window.scrollBy(0,1000)"); // Dikey olarak 1000 piksel asagi kaydır
            js.executeScript("window.scrollTo(0, 0)");  // en asagiya gider
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); // en asagiya gider
                // scrollTo : Verilen pixele gider.
                // scrollBy : Verilen kadar daha ileri gider.
           scrollIntoView () web sayfasindaki bir ogenin gorunurlulugune gore kaydirir
           js.executeScript("arguments[0].scrollIntoView();"  , webelement);
 */

public class C02_ScrolWithJSExecutor extends BaseTest {
/* TASK
go to url : https://api.jquery.com/dblclick/
double click on the blue square at the bottom of the page and then write the changed color.
 */

    @Test
    public void doubleClickButton() {
        driver.get("https://api.jquery.com/dblclick/");
        driver.switchTo().frame(0);//frame icine giris yapildi

        WebElement blueBox = driver.findElement(By.cssSelector("body>div"));//blueBox adresi belirtildi.
        JavascriptExecutor jSE = (JavascriptExecutor) driver;
        jSE.executeScript("arguments[0].scrollIntoView();", blueBox);

        System.out.println("colour before: " + blueBox.getCssValue("background-color"));//colour before: rgba(0, 0, 255, 1)
        Actions act = new Actions(driver);//action class aktiflestirildi.

        act.doubleClick(blueBox).perform();//mavi kutuya cift tiklandi
        System.out.println("colour after: " + blueBox.getCssValue("background-color"));//colour after: rgba(255, 255, 0, 1)
    }
}