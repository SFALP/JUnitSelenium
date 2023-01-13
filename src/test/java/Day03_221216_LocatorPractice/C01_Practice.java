package Day03_221216_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//    Go to https://www.linkedin.com/
//    When we write an e-mail without the @ sign in the e-mail box and press enter.
//    Let's test the "Invalid email address" warning.
public class C01_Practice {

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void xPathPractice() {
        //1.Adim--> Linkedin sitesine git.
        driver.get("https://www.linkedin.com/");
        driver.manage().window().maximize();

//2.Adim--> email alanina @ sembolu bulunmayan bir mail adresi gir.
        driver.findElement(By.xpath("//input[@name='email-or-phone']")).//sayfada ilgili alan bulundu
                sendKeys("F4992farukmail.com" + Keys.ENTER);//bulunan alana @ isareti olmadan "F4992farukmail.com" ifadesi yazildi
        //ve sonrasinda Keys.ENTER komutuyla enter'a basildi yani submit yapildi.

        //3.Adim--> Hata mesajinin goruntulendigini dogrula.
        WebElement alertMessage = driver.findElement(By.xpath("//p[@class='alert-content']"));
        Assert.assertTrue(alertMessage.isDisplayed());
//2.Varyasyon:        Assert.assertEquals(true, alertMessage.isDisplayed());
//3.Varyasyon:        Assert.assertFalse(!alertMessage.isDisplayed());

    }

}
