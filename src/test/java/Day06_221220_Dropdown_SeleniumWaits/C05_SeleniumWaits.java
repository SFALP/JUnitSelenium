package Day06_221220_Dropdown_SeleniumWaits;

import Utilities.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C05_SeleniumWaits extends BaseTest {
    //Explicit wait

    @Test
    public void webDriverWait() throws InterruptedException {

        driver.get("https://demoqa.com/interaction");
//Adim 1--> WebDriverWait objemizi olusturuyoruz.
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement category=driver.findElement(By.xpath("(//div[@class='icon'])[2]"));


//until, cok kullanilan bir methoddur. Belli bir kriter gerceklesene (artik hangi durumsa bu) kadar bekler.


//ElementToBeClickable (WebElement Kullanimi)
        wait.until(ExpectedConditions.elementToBeClickable(category)).click();

//ElementToBeClickable (By Kullanimi)
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(., 'Practice Form')]"))).click();

//Yukaridaki kadun anlami: Beklenen element tiklanabilir olana kadar 10 sn boyunca bekler,
// tiklanabilir oldugundqa da elementi teslim eder.
    }
}