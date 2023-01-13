package Day03_221216_LocatorPractice;

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

//https://id.heroku.com/login sayfasına gidiniz.
//Bir mail adresi giriniz.
//Bir password giriniz.
//Login butonuna tıklayınız.
//"There was a problem with your login." text görünür ise "Kayıt Yapılamadı" yazdırınız.
//Eğer yazı görünür değilse "Kayıt Yapıldı" yazdırınız.
//Tüm sayfaları kapatınız.
public class C99_HW1 {
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
    public void hW01() throws InterruptedException {
        driver.get("https://id.heroku.com/login");
        Thread.sleep(3000);//Aksiyonlarin yuklenmesi pc ve net hizina gore degiskenlik gosterdigi icin onlem amaciyla bekleme suresi eklendi

//Cerez onayi icin karsimiza cikan ekran reddedilerek ana ekrana tekrar donuldu.
        WebElement cookies = driver.findElement(By.xpath("//button[text()='Tümünü Reddet']"));
        cookies.click();

//mail alanina mail bilgisi yazildi.
        WebElement eMail = driver.findElement(By.name("email"));
        eMail.sendKeys("abcd@hallomail.com");

//Password alanina password verisi girildi.
        WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
        pass.sendKeys("Pass12345");

//Login bilgileri girildikten sonra login tusuna tiklandi
        WebElement login = driver.findElement(By.xpath("//button[@name='commit']"));
        login.click();

        Thread.sleep(1000);//Aksiyonlarin yuklenmesi pc ve net hizina gore degiskenlik gosterdigi icin onlem amaciyla bekleme suresi eklendi
        String message = driver.findElement(By.xpath("//div[text()='There was a problem with your login.']")).getText();

        //Login olma hali kontrol edilerek ekranda output yazdirildi.
        if (message.contains("There was a problem with your login.")) {
            System.out.println("Kayit yapilamadi");
        } else System.out.println("Kayit yapildi");
    }
}