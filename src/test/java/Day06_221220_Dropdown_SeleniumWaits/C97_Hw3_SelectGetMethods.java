package Day06_221220_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
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
- multiple <select> elementini locate edin
- getOptions(), getFirstSelectedOption(), getAllSelected() methodlarini kullanmak adina:
    * Farkli secimler yaparak methodlarinizi kullanin ve Assertion yapmayi unutmayin
 */
public class C97_Hw3_SelectGetMethods {
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
    public void getOptions() {
        driver.get("https://demoqa.com/select-menu");//siteye erisim saglandi
        WebElement dropDown = driver.findElement(By.id("cars"));//ID=cars olan secim menusune gidildi.
        Select select = new Select(dropDown);//ID=cars olan elemanlarin tumu Select Class'ina atidi.
        System.out.println("    *** GetOptions ***     ");
        List<WebElement> listGetOptions = select.getOptions();//Elemanlarin hepsinden bir liste olusturuldu ve elemanlar listeye atildi
        for (WebElement liste : listGetOptions) {//Listeye atilan elemanlar forEach dongusuyle yazdirildi.
            System.out.println("liste.getText() = " + liste.getText());
        }
    }
    @Test
    public void getFirstSelectedOptions() {
        driver.get("https://demoqa.com/select-menu");//siteye gidildi
        WebElement dropDown = driver.findElement(By.id("cars"));//ID=cars olan secim menusune gidildi
        Select select = new Select(dropDown);//Secim menusunden otonom secim yapilabilecek select Class'i aktif edildi.

        select.selectByIndex(2);//Bu elemanlar arasindan index'i 2 olan eleman secildi
        select.selectByIndex(3);//Bu elemanlar arasindan index'i 3 olan eleman secildi
        System.out.println("    *** GetFirstSelectedOptions ***     ");
        WebElement getFirstSelectedOptions=select.getFirstSelectedOption();//Secim yapilanlar arasindan ilk eleman alindi.
        System.out.println("Secilmis elemanlardan ilk siradaki = " + getFirstSelectedOptions.getText());
    }
    @Test
    public void getAllSelectedOptions() {
        driver.get("https://demoqa.com/select-menu");//siteye gidildi
        WebElement dropDown = driver.findElement(By.id("cars"));//ID=cars olan secim menusune gidildi
        Select select = new Select(dropDown);//Secim menusunden otonom secim yapilabilecek select Class'i aktif edildi.
        System.out.println("    *** GetAllSelectedOptions ***     ");
        select.selectByValue("volvo");//Bu elemanlar arasindan value degeri volvo olan eleman secildi
        select.selectByVisibleText("Saab");//Bu elemanlar arasindan gorunen degeri "Saab" olan eleman secildi

        List<WebElement> getAllSelectedOptions=select.getAllSelectedOptions();//Secim yapilan tum elemanlar bir list'e atildi.
        getAllSelectedOptions.forEach(t-> System.out.println(t.getText()));//Lambda kullanilarak secilen tum elemanlar yazdirildi
    }
}