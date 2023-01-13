package Day03_221216_LocatorPractice;
//    Create the driver with BeforeClass and make it static inside the class.
//    Go to http://www.google.com
//    Type "Green Mile" in the search box and print the number of results.
//    Type "Premonition" in the search box and print the number of results.
//    Type "The Curious Case of Benjamin Button" in the search box and print the number of results.
//    Close with AfterClass.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Practice {

    static WebDriver driver;

    @BeforeClass
    public static void createDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Before
    public void beforeEach(){
        driver.get("http://www.google.com");

    }

    @AfterClass
    public static void closeDriver(){
//        driver.quit();
    }
    @Test//Green Mile Testi
    public void test01(){
        //div[text()='Tümünü kabul et']
        WebElement cerez= driver.findElement(By.xpath("//div[text()='Tümünü kabul et']"));
        cerez.click();

        WebElement search=driver.findElement(By.name("q"));
        search.sendKeys("Green Mile"+ Keys.ENTER);

        WebElement results = driver.findElement(By.id("result-stats"));
        System.out.println("Green Mile: "+results.getText());
        //OUTPUT: Green Mile: Yaklaşık 463.000.000 sonuç bulundu (0,42 saniye)
    }
    @Test//Premonition
    public void test02(){
        //div[text()='Tümünü kabul et']
        WebElement cerez= driver.findElement(By.xpath("//div[text()='Tümünü kabul et']"));
        cerez.click();

        WebElement search=driver.findElement(By.name("q"));
        search.sendKeys("Premonition"+ Keys.ENTER);

        WebElement results = driver.findElement(By.id("result-stats"));
        System.out.println("Premonition: "+results.getText());
        //OUTPUT: Premonition: Yaklaşık 13.400.000 sonuç bulundu (0,34 saniye)
    }
    @Test//The Curious Case of Benjamin Button
    public void test03(){
        //div[text()='Tümünü kabul et']
        WebElement cerez= driver.findElement(By.xpath("//div[text()='Tümünü kabul et']"));
        cerez.click();

        WebElement search=driver.findElement(By.name("q"));
        search.sendKeys("The Curious Case of Benjamin Button"+ Keys.ENTER);

        WebElement results = driver.findElement(By.id("result-stats"));
        System.out.println("The Curious Case of Benjamin Button: "+results.getText());
        //OUTPUT: The Curious Case of Benjamin Button: Yaklaşık 5.320.000 sonuç bulundu (0,54 saniye)
    }

}
