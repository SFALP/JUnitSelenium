package Day02_221215_WebElementsLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_Locators {
    WebDriver driver;

    @Before
    public void setup() {

        //Driver olusturuldu
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //sayfanin yuklenmesi beklendi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //LinkedIn sitesine gidildi
        driver.get("https://www.linkedin.com/");

        // driver imiz maximize edildi
        driver.manage().window().maximize();


    }

    @After
    public void tearDown() {

        // driver imiz kapatildi
        //driver.quit();
    }


    @Test
    public void idLocator() {
        // id Locator -> "email-or-phone"

        WebElement email = driver.findElement(By.id("email-or-phone"));
        email.sendKeys("Clarusway selenium dersinden selamlar");

    }

    @Test
    public void nameLocator() {
        // name locator -> "password"

        WebElement password = driver.findElement(By.name("password"));

        password.sendKeys("Sifre");
    }


    @Test
    public void classLocator() {

        // class locator -> "input__input"

        WebElement email = driver.findElement(By.className("input__input"));
        email.sendKeys("Class locator test");
    }

    @Test
    public void tagLocator() {

        // tag locator -> "input"

        List<WebElement> emailList = driver.findElements(By.tagName("input"));


        // 2. elementimiz email text alanimiz. Bu yuzden bu elemani email degiskenine assign ettik.
        WebElement email = emailList.get(1);

        email.sendKeys("Tag locator test");

    }

    @Test
    public void linkTextLocator() {
        // link text -> "Forgot password?"

        WebElement forgotPwd = driver.findElement(By.linkText("Forgot password?"));
        forgotPwd.click();
    }

    @Test
    public void partialLinkTextLocator() {
        // link text -> "Forgot password?"

        WebElement forgotPwd = driver.findElement(By.partialLinkText("Forgot"));
        forgotPwd.click();
    }

    @Test
    public void absoluteXPath() {
        WebElement email = driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div[1]/form/div[1]/input"));
        email.sendKeys("Faruk absolute xpath konusunda pekte basarili olamadi");
    }

    @Test
    public void relativeXPath() {
        //XPath locator--> "//*[@id="username"]"
        WebElement email = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        email.sendKeys("Faruk bu iste basarili olamasa da daha fazla calismali");
    }

    @Test
    public void multipleAttributeXPath() {
        //XPath locator--> "//input[@class='input__input'][@name='email-or-phone']"
        WebElement email = driver.findElement(By.xpath("//input[@class='input__input'][@name='email-or-phone']"));
        email.sendKeys("Faruk bu iste basarili olsa bile yine de calismali");
    }

    @Test
    public void andOrXPath() {
        //XPath locator--> "//input [@class='input__input' and @name='email-or-phone']"
        WebElement email = driver.findElement(By.xpath("//input [@class='input__input' and @name='email-or-phone']"));
        email.sendKeys("Faruk bu iste basarili olsa bile yine de calismali");
    }

    @Test
    public void containsXPath() {
        //XPath locator--> "//input[contains(@name,'email-or-phone')]"
        WebElement email = driver.findElement(By.xpath("//input[contains(@name,'email-or-phone')]"));
        email.sendKeys("Faruk bu iste basarili olsa bile yine de calismali");
    }
    //starts-with---> //input[starts-with(@name,'email')]
    //ends-with--->
    // text()--->//button[contains(text(),'Kabul Et ve Katıl')]
}