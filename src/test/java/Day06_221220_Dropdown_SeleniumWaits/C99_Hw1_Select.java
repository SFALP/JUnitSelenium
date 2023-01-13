package Day06_221220_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

/*
- https://demoqa.com/select-menu sitesine gidin
- <select> elementini locate edin
- <select> elementinin seceneklerini yazdirin
- Sirasiyla selectByIndex, selectByValue, selectByVisibleText methodlarini kullanarak;
    * Yellow (index)
    * Purple (value)
    * Black  (text)
    seceneklerini secin
 */
public class C99_Hw1_Select {
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
    public void selectPrint() {
        driver.get("https://demoqa.com/select-menu");
        WebElement select01=driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
        Select select1=new Select(select01);
        List<WebElement> listOpt=select1.getOptions();
        for (WebElement opt1:listOpt) {
            System.out.println("opt1.getText() = " + opt1.getText());
        }
    }
    @Test
    public void selectByIndex(){
        driver.get("https://demoqa.com/select-menu");
        WebElement select02=driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
        Select select2=new Select(select02);
        select2.selectByIndex(3);
    }
    @Test
    public void selectByValue(){
        driver.get("https://demoqa.com/select-menu");
        WebElement select03=driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
        Select select3=new Select(select03);
        select3.selectByValue("4");
    }
    @Test
    public void selectByVisibleText(){
        driver.get("https://demoqa.com/select-menu");
        WebElement select03=driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
        Select select3=new Select(select03);
        select3.selectByVisibleText("Black");
    }
}
