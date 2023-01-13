package Day06_221220_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/*
Go to URL: http://demo.automationtesting.in/Alerts.html
Click "Alert with OK" and click 'click the button to display an alert box:’
Accept Alert(I am an alert box!) and print alert on console.
Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
Cancel Alert  (Press a Button !)
Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box’
And then sendKeys «BootcampCamp» (Please enter your name)
Finally print on console this message "Hello BootcampCamp How are you today" assertion these message.

 */
public class C93_Hw7_AlertTask {
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
        driver.quit();
    }

    @Test
    public void test01() {
//Go to URL: http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

//Click "Alert with OK" and click 'click the button to display an alert box:’
        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='alertbox()']"));
        button1.click();

//Accept Alert(I am an alert box!) and print alert on console.
        driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

//Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
        WebElement button2 = driver.findElement(By.xpath("//a[@href='#CancelTab']"));
        button2.click();
        driver.findElement(By.xpath("//button[@onclick='confirmbox()']")).click();

//Cancel Alert  (Press a Button !)
        driver.switchTo().alert().dismiss();

//Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box’
        WebElement button3 = driver.findElement(By.xpath("//a[@href='#Textbox']"));
        button3.click();
        driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();

//And then sendKeys «BootcampCamp» (Please enter your name)
        driver.switchTo().alert().sendKeys("F4992-S.Faruk");
        driver.switchTo().alert().accept();

//Finally print on console this message "Hello BootcampCamp How are you today" assertion these message.
        WebElement message = driver.findElement(By.xpath("//p[@id='demo1']"));
        System.out.println("message.getText() = " + message.getText());//message.getText() = Hello F4992-S.Faruk How are you today
    }
}