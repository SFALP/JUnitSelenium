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

//Go to URL: https://demoqa.com/radio-button
//Soruya verilen 3 seçeneğin de seçilme durumlarını doğrulayınız.
//Her bir seçenek seçildiğinde aşağıda çıkan text’leri konsolda yazdırınız.
public class RadioButtonExamples02 {
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
        driver.close();
    }

    @Test
    public void test01() {
        driver.get("https://demoqa.com/radio-button");
       WebElement cB1 = driver.findElement(By.xpath("//label[text()='Yes']"));
       if (!cB1.isSelected()) cB1.click();

       WebElement outputCB1 = driver.findElement(By.xpath("//p[@class='mt-3']"));
       System.out.println("outputCB1.getText() = " + outputCB1.getText());
//outputCB1.getText() = You have selected Yes

        WebElement cB2 = driver.findElement(By.xpath("//label[text()='Impressive']"));
        if (!cB2.isSelected()) cB2.click();

        WebElement outputCB2 = driver.findElement(By.xpath("//p[@class='mt-3']"));
        System.out.println("outputCB2.getText() = " + outputCB2.getText());
//outputCB2.getText() = You have selected Impressive

        WebElement cB3 = driver.findElement(By.xpath("//label[text()='No']"));
        cB3.click();
        Assert.assertFalse(cB3.isSelected());

    }
}