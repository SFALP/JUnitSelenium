package Day06_221220_Dropdown_SeleniumWaits;
/*
driver.switchTo().alert().accept();//ok demek
driver.switchTo().alert().dismiss();//cancel demek
driver.switchTo().alert().getText();//metni getirir
driver.switchTo().alert().sendKeys("");//metin kutusu doldurulur
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BasicAuthentication {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        //       driver.close();
    }

    @Test
    public void basicAuth() {
        //GENEL SYNTAX: https://USERNAME:PASSWORD@URL
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        WebElement content=driver.findElement(By.id("content"));
        Assert.assertTrue(content.getText().contains("Congratulations"));
    }
}