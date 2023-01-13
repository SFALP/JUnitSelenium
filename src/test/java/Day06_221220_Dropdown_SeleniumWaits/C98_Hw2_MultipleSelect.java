package Day06_221220_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

/*
- https://demoqa.com/select-menu sitesine gidin
- Multiple select yapabileceginiz <select> elementini locate edin
- Birden fazla secim yapip secimlerinizi DOGRULAyin
 */
public class C98_Hw2_MultipleSelect {
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
        //  driver.close();
    }

    @Test
    public void test01() {
        driver.get("https://demoqa.com/select-menu");
        WebElement multipleSelect = driver.findElement(By.id("cars"));
        Select select = new Select(multipleSelect);
        System.out.println("select.isMultiple() = " + select.isMultiple());

        select.selectByIndex(0);//Volvo secildi
        select.selectByValue("saab");//Saab secildi
        select.selectByVisibleText("Opel");//Opel secildi
        select.selectByIndex(3);//Audi secildi
        Assert.assertTrue(select.isMultiple());
    }
}