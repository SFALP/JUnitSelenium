package Day04_221217_LocatorPractice;
/*
XPATH VE CSSSELECTOR ARASINDAKİ FARKLAR NELERDİR?
By.cssSelector(tagname[attribute name='value'])
By.Xpath(//tagname[@attribute name='value'])
xpath iki cesit :
1)Absolute Xpath
2)Relative Xpath
css biraz daha hizli ve guvenilir
Xpath DOM da gezinir,css navigasyon olmadan hedefi bulur
 */
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
import java.util.List;

//http://the-internet.herokuapp.com/add_remove_elements/
// Click on the "Add Element" button 100 times.
// Write a function that takes a number, and clicks the "Delete" button.
// Given number of times, and then validates that given number of buttons was deleted.
// 1. Method: createButtons(100)
// 2. Method: DeleteButtonsAndValidate()
public class C02_CssPractice02 {
    static WebDriver driver;

    @Before
    public void setup() {
        //Driver'la ilgili her turlu initial(baslangic/atama) islemi burada yapilir
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        //Test sonrasinda driver'i kapatma islemi yapilir
//        driver.close();
    }

    @Test
    public void cssSelectorTest() {
//siteye gidiyoruz.
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        //createButtons metoduyla 100 defa create elements'e tikliyoruz.
        createElements(100);

        //deleteButtonsAndValidate methodu ile 40 buton silinir ve kontrol edilir.
        deleteButtonsAndValidate(40);
    }


    public void createElements(int amountCreate) {
        WebElement addElementButton = driver.findElement(By.cssSelector("button[onclick=\"addElement()\"]"));

        for (int i = 0; i < amountCreate; i++) {
            addElementButton.click();
        }
    }

    public void deleteButtonsAndValidate(int amountDelete) {
        //Sayfadaki delete buton sayisini buldurur ve saklariz.
        List<WebElement> deleteButtonsList = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        int silinmedenOncekiButtonSayisi = deleteButtonsList.size();//100

        //Bizden istenen buton sayisi kadar buton sileriz.
        for (int i = 0; i < amountDelete; i++) {
            deleteButtonsList.get(i).click();
        }

        //Silindikten sonraki buton sayisini buluruz.
        List<WebElement> deleteButtonsListAfter = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        int silindiktenSonrakiButtonSayisi = deleteButtonsListAfter.size();//60

        //Ilk ve Son buton sayisi arasindaki farki dogrulariz.
        Assert.assertEquals(silinmedenOncekiButtonSayisi-amountDelete,silindiktenSonrakiButtonSayisi);

    }
}
