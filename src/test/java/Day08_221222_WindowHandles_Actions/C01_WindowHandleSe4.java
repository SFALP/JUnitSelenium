package Day08_221222_WindowHandles_Actions;

import Utilities.BaseTest;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import java.util.Iterator;
import java.util.Set;

/*
Go to URL: https://testproject.io/
Selenium’s 4 newWindow() method to open a new Window for TestProject’s Blog page.
https://blog.testproject.io/
 */
public class C01_WindowHandleSe4 extends BaseTest {
    @Override
    public void tearDown() {
//        super.tearDown();
    }

    @Test
    public void newWindow() {
        driver.get("https://testproject.io/");
        //1. Varyasyon:
//        WebDriver newWindow=driver.switchTo().newWindow(WindowType.WINDOW);
        //2. Varyasyon:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://blog.testproject.io/");
        //3.Varyasyon:
        // driver.switchTo().newWindow(WindowType.WINDOW).get("https://blog.testproject.io/");
    }

    @Test
    public void newTab() {
//        https://www.amazon.com/
        driver.get("https://testproject.io/");
//Yeni bir sekme olusturuldu
        WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
//yeni sekmede amazon acildi
        newTab.get("https://www.amazon.com/");
//Guncel olan tab'in title'i alinir.
        System.out.println("driver.getTitle() = " + driver.getTitle());//driver.getTitle() = Amazon.com. Spend less. Smile more.

    }

    @Test
    public void handleWindows() {
        //Ana sekmemizde amazon'u actik.
        driver.get("https://www.amazon.com/");

//getWindowHandle()=collection String tipinde id dondurur ---
//getWindowHandles()=coklu collection String tipinde id dondurur.

        String homePageHandle = driver.getWindowHandle();//ilk gidilen sayfa bir yere homePageHandle ismiyle String cinsiyle kaydedildi
        driver.switchTo().newWindow(WindowType.TAB);//Yeni sekme olusturuldu
        driver.get("https://www.amazon.com.tr/");//Yeni sekmede amazon TR ziyaret edildi

//Yeni pencere olusturuldu.
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.google.com.tr/");//Yeni pencerede google TR acildi

//Driver'la gezilen tum sitelerden(sayfa/sekme) bir set olusturulup handles isminde Set elde edildi.
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> i = handles.iterator();

//Yukaridaki satirlarla gezilen tum sitelerin id'lerinin oldugu Collector var.
//Bu iterator kullanilarak sitelerin id'leri arasinda tek tek gezilmesi icin kullnailmaktadir.
//Bu gezinti yapilabilmesi icin iterator yapisi kullanilmak zorundadir.

        while (i.hasNext()) {//bir sonraki iterator (yani bu ornekteki karsiligi site id'si) varsa bu donguye devam eder.

//TASLAK/Ornek icin yazildi= driver.switchTo().window(id);
            String currentTab = i.next();// Herhangi bir anda ziyaret edilen site currentTab'a atanmis olur
            driver.switchTo().window(currentTab);

            System.out.println(driver.getTitle());
/*
OUTPUT=
Amazon.com. Spend less. Smile more.
Amazon.com.tr: Elektronik, bilgisayar, akıllı telefon, kitap, oyuncak, yapı market, ev, mutfak, oyun konsolları ürünleri ve daha fazlası için internet alışveriş sitesi
Google
 */
//1.Yol:
            /*
           if (!driver.getWindowHandle().equals(homePageHandle)){
               driver.close();
           }
           */

//2.Yol
            if (!driver.getTitle().contains("Spend")){
                driver.close();
            }
        }
    }
}