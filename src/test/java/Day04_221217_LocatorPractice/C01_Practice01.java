package Day04_221217_LocatorPractice;

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

//Navigate to website  https://testpages.herokuapp.com/styled/index.html
// Under the ORIGINAL CONTENTS
// Click on Alerts
// Print the URL
// Navigate back
// Print the URL
// Click on Basic Ajax
// Print the URL
// Enter value  20 and Enter
// And then verify Submitted Values is displayed open page
// Close driver.
public class C01_Practice01 {

    static WebDriver driver;

    @Before
    public void setup() {
        //Driver'la ilgili her turlu initial(baslangic/atama) islemi burada yapilir
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        //Test sonrasinda driver'i kapatma islemi yapilir
//        driver.close();
    }

    @Test
    public void test01() {
        //Alerts linki locate edildi.
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement alertsLink = driver.findElement(By.xpath("//*[@id=\"alert\"]"));
        //alerts linkine tiklandi.
        alertsLink.click();

        //Current URL yazdirildi
        String alertsUrl = driver.getCurrentUrl();
        System.out.println("alertsUrl = " + alertsUrl);

        //1 sayfa geriye gidildi
        driver.navigate().back();
        //Geri gidilme isleminde sonraki link yazdirild.
        String currentUrl02 = driver.getCurrentUrl();
        System.out.println("currentUrl02 = " + currentUrl02);

        // Click on Basic Ajax (farkli bir ornek olmasi icin By.id olan method'la islem yapildi)
        WebElement basicAjaxLink = driver.findElement(By.id("basicajax"));

        //basicAjax sayfasina gidecek linke tiklandi
        basicAjaxLink.click();

        //basicAjax linki once atandi sonra yazdirildi
        String basicAjaxUrl = driver.getCurrentUrl();
        System.out.println("basicAjaxUrl = " + basicAjaxUrl);

        // Text alanina 20 yazilip ENTER'a tiklanma islemi;
        driver.findElement(By.id("lteq30")).sendKeys("20"+ Keys.ENTER);

        // Sayfada "Submitted Values" yazisi olup olmadiginin testi yapilir.
        WebElement submittedValueText= driver.findElement(By.xpath("//p[text()='Submitted Values']"));
        Assert.assertTrue(submittedValueText.isDisplayed());


    }
}
