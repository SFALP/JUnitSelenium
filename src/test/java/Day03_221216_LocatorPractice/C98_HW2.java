package Day03_221216_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//Navigate to https://testpages.herokuapp.com/styled/index.html
// Click on Calculate under Micro Apps.
// Type any number in the first input.
// Type any number in the second input.
// Click on Calculate.
// Get the result.
// Print the result.
public class C98_HW2 {
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
//  driver.quit();
    }

    @Test
    public void hW2() {
//Istenen site ziyaret edildi.
        driver.get("https://testpages.herokuapp.com/styled/index.html");

//Calculator bolumu bulundu ve tiklandi
        WebElement calculator = driver.findElement(By.id("calculatetest"));
        calculator.click();
//1.sayi bolumu bulundu ve tanimlandi
        WebElement no1 = driver.findElement(By.id("number1"));
        no1.sendKeys("5");

//2.sayi bolumu bulundu ve tanimlandi
        WebElement no2 = driver.findElement(By.id("number2"));
        no2.sendKeys("3");

//Tanimlanan sayilarla ilgili islem yaptirildi.
        WebElement calc=driver.findElement(By.xpath("//input[@id='calculate']"));
        calc.click();
//Sonuc bolumu bulundu ve yazdirildi.
        String answer=driver.findElement(By.xpath("//p[text()='Answer : ']")).getText();
        System.out.println(answer);
    }
}