package Day05_221219_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//https://www.teknosa.com/ adresine gidiniz.
// Arama çubuğuna ''oppo'’ yazıp ENTER tıklayınız.
// Sonuç sayısını yazdırınız.
// Çıkan ilk ürüne tıklayınız.
// Sepete ekleyiniz.
// Sepetime gite tıklayınız.
// Konsolda "Sipariş Özeti" WebElement'inin text'ini yazdırınız.
// Alışverişi tamamlayınız.
// Son olarak "Teknosa'ya Hoş Geldiniz" WebElement'inin text'ini yazdırınız.
// Driver'ı kapatınız.
public class C02_Task {
    WebDriver driver;

    @Test
    public void teknosaTest01() throws InterruptedException {
        driver.get("https://www.teknosa.com/");
        WebElement searchButton = driver.findElement(By.xpath("//input[@name='s']"));
        searchButton.sendKeys("oppo" + Keys.ENTER);
        WebElement searchAnswer = driver.findElement(By.xpath("//div[@class='plp-info']"));
        System.out.println("Sonuc sayisi = " + searchAnswer.getText());

        // ilk urune tiklanip urunun secilmesi islemi:
        WebElement ilkUrun = driver.findElement(By.className("prd-link"));
        ilkUrun.click();

        /* Eger ilk urun degil de 5.urune tiklanmak istenseydi; buradaki urunlerin xPath'lerini bir List'e atmamiz gerekirdi.
        List<WebElement> urunler = driver.findElements(By.className("prd-link"));
        urunler.get(4).click();--> buradaki 4.index'e tiklarsak bu bizi 5.urune goturecektir.
        */

        Thread.sleep(5000);
        WebElement sepeteEkle = driver.findElement(By.xpath("//button[@id='addToCartButton'][1]"));
        //19 sonuc arasindan 1.'si bu kodla secilir.
        sepeteEkle.click();
        //Sepete git butonuna tiklandi
        WebElement sepeteGitButton = driver.findElement(By.xpath("//a[@class='btn btn-secondary']"));
        sepeteGitButton.click();

        //Siparis ozeti texti yazdirildi
        WebElement siparisOzet = driver.findElement(By.xpath("//div[@class='cart-sum-body']"));
        System.out.println(siparisOzet.getText());

        //Alisveris tamamla butonuna basildi
        WebElement alisverisTamamlaButton = driver.findElement(By.partialLinkText("Alışverişi Tamamla"));
        alisverisTamamlaButton.click();

        //Teknosaya hosgeldiniz texti yazdirildi
        WebElement hosgeldiniz = driver.findElement(By.xpath("//div[@class='lrp-title']"));
        System.out.println(hosgeldiniz.getText());
    }

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
