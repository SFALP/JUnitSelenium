package Day05_221219_LocatorPractice;

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

//    Go to URL:  https://www.facebook.com/
//    Click on Create an Account button.
//    Then click on the radio buttons.
//    Click 'Kadin',
//    Click 'Erkek',
//    Validate 'Kadin is not selected and 'Erkek' is selected'
public class C06_RadioButtons {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
    //    driver.close();
    }

    @Test
    public void redioButtons() {
        driver.get("https://www.facebook.com/");
        WebElement cerez = driver.findElement(By.xpath("//button[@title='Sadece temel çerezlere izin ver']"));
        cerez.click();
        WebElement createAccount = driver.findElement(By.xpath("  //a[contains(@data-testid,'registration-form')]"));
        createAccount.click();
    WebElement kadinRadio=driver.findElement(By.xpath("//input[@name='sex' and @value='1']"));
    WebElement erkekRadio=driver.findElement(By.xpath("//input[@name='sex' and @value='2']"));

    kadinRadio.click();
    erkekRadio.click();

        Assert.assertTrue(erkekRadio.isSelected());
        Assert.assertTrue(!kadinRadio.isSelected());
    }
}
