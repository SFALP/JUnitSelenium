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

//    Go to URL: https://demoqa.com/
//    Click on Elements.
//    Click on Checkbox.
//    Verify if Home checkbox is selected.
//    Verify that "You have selected" is visible.
public class C05_CheckBoxes02 {
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
//        driver.quit();
    }

    @Test
    public void testCheckBox01() throws InterruptedException {
        driver.get("https://demoqa.com/");
        Thread.sleep(3500);

        //    Click on Elements.
        WebElement clickElements = driver.findElement(By.xpath("//div[@class='card mt-4 top-card'][1]"));
        clickElements.click();

//    Click on Checkbox.
        WebElement clickCheckBox = driver.findElement(By.xpath("//li[@id='item-1']"));
        clickCheckBox.click();

//    Verify if Home checkbox is selected.
        WebElement cB1=driver.findElement(By.xpath("//span[@class='rct-checkbox']"));
        cB1.click();

  //    if (!cB1.isSelected()){
  //        cB1.click();
  //    }
        Assert.assertTrue(cB1.isDisplayed());

        //    Verify that "You have selected" is visible.
        WebElement sonAdim=driver.findElement(By.xpath("//span[text()='You have selected :']"));
        Assert.assertTrue(sonAdim.isDisplayed());
    }
}