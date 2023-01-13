package Day07_221221_iFrame_WindowHandles;

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

//        Go to URL: https://the-internet.herokuapp.com/iframe
//        Verify the Bolded text contains "Editor"
//        Locate the text box
//        Delete the text in the text box
//        Type "Hi everyone"
//        Verify the text Elemental Selenium text is displayed on the page.
public class C01_iFrameEx01 {
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
    public void iFrameExample() {
        //        Go to URL: https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");

//        Verify the Bolded text contains "Editor"
        WebElement boldedText = driver.findElement(By.tagName("h3"));
        String text = boldedText.getText();

        Assert.assertTrue(text.contains("Editor"));

//        Locate the text box
        driver.switchTo().frame(0);
        WebElement textBox = driver.findElement(By.id("tinymce"));
//        Delete the text in the text box
        textBox.clear();

//        Type "Hi everyone"
        textBox.sendKeys("Hi everyone");
//        Verify the text Elemental Selenium text is displayed on the page.

        //Sayfaya geri switch islemi yapilir.
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.findElement(By.partialLinkText("Elemental")).isDisplayed());

    }
}
