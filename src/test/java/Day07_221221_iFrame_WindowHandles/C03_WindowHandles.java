package Day07_221221_iFrame_WindowHandles;

import Utilities.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

//    Go to URL: https://www.toolsqa.com/selenium-webdriver/window-handle-in-selenium/
//    Print the existing windowHandles ids by clicking all the links on the page.
//    Click on the links that open a new page.
//    Close other pages other than the home page.
//    Set the driver back to the main page.
public class C03_WindowHandles extends BaseTest {

    @Override
    public void tearDown() {
//        super.tearDown();
    }

    @Test
    public void windowHandles() {
        driver.get("https://www.toolsqa.com/selenium-webdriver/window-handle-in-selenium/");

        //Daha sonra da kullanabilmek icin ana sayfa id'mizi sakliyoruz
        String homePageId = driver.getWindowHandle();//ilgili id'yi saklar
        //7 elemanli oldugu icin list acildi

//Yeni sekmeler olusturmak adina target=_blank olan linklerden 2 tanesine tikliyoruz.
        List<WebElement> links = driver.findElements(By.xpath("//a[@target='_blank']"));

        links.get(0).click();
        links.get(1).click();
// Iterate etmek icin (gezinmek icin) tum tab ve window id'lerini bir set icinde sakliyoruz.
        Set<String> windows = driver.getWindowHandles();

//Gezinme islemi icin iterate objesini olusturuyoruz.
        Iterator<String> iterator = windows.iterator();

//Gezinme islemi
        while (iterator.hasNext()) {

//Her bir gezinilen id kullanilarak o anki sekmeye switch ediyoruz.
            driver.switchTo().window(iterator.next());

//Switch ettigimiz sayfanin ana sayfa olup olmadigini kontrol ediyoruz. Ana sayfa ise sekmeyi kapatmiyoruz, degilse kapatiliyor.
            if (driver.getWindowHandle().equals(homePageId)) {
                continue;
            }

//Sekmeyi kapatiyoruz
            driver.close();
        }
    }
}
