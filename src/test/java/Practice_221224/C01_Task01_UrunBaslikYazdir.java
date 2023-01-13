package Practice_221224;

import Utilities.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

/*
   1- https://www.amazon.com/ sayfasına gidelim.
   2- Arama kutusunu locate edelim.
   3- "Samsung headphones" ile arama yapalım.
   4- Bulunan sonuç sayısını yazdıralım.
   5- İlk ürünü tıklayalım.
   6- Sayfadaki tüm ürün başlıklarını yazdıralım.
*/
public class C01_Task01_UrunBaslikYazdir extends BaseTest {
    @Test
    public void test01() {
        driver.get("https://www.amazon.com/");

//Arama kutusunu locate edelim.
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

//"Samsung headphones" ile arama yapalım.
        searchBox.sendKeys("Samsung headphones" + Keys.ENTER);

//Bulunan sonuç sayısını yazdıralım.
        WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("result.getText() = " + result.getText());//result.getText() = 1-16 of 236 results for "Samsung headphones"

//İlk ürünü tıklayalım.
        WebElement firstElement = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        firstElement.click();

//Sayfadaki tüm ürün başlıklarını yazdıralım
        driver.navigate().back();

        List<WebElement> allProducts = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

        for (WebElement each : allProducts) {
            System.out.println("each.getText() = " + each.getText());
        }
/*
each.getText() = SAMSUNG Galaxy Buds Pro True Wireless Bluetooth Earbuds w/ Noise Cancelling, Charging Case, Quality Sound, Water Resistant, Long Battery Life, Touch Control, US Version, White
each.getText() = SAMSUNG Galaxy Buds 2 True Wireless Earbuds Noise Cancelling Ambient Sound Bluetooth Lightweight Comfort Fit Touch Control US Version, Olive Green
each.getText() = SAMSUNG Galaxy Buds Live True Wireless Earbuds US Version Active Noise Cancelling Wireless Charging Case Included, Mystic Bronze
each.getText() = Samsung Galaxy Buds Live, Wireless Earbuds w/Active Noise Cancelling, Mystic Black, International Version
each.getText() = SAMSUNG Galaxy Buds 2 Pro True Wireless Bluetooth Earbuds w/ Noise Cancelling, Hi-Fi Sound, 360 Audio, Comfort Ear Fit, HD Voice, Conversation Mode, IPX7 Water Resistant, US Version, Graphite
each.getText() = SAMSUNG Galaxy Buds 2 True Wireless Earbuds Noise Cancelling Ambient Sound Bluetooth Lightweight Comfort Fit Touch Control US Version, Graphite
each.getText() = OEM ElloGear Earbuds Stereo Headphones for Samsung Galaxy S10 S10e Plus A31 A71 Cable - Designed by AKG - with Microphone and Volume Buttons (Black)
each.getText() = Samsung EHS64AVFWE 3.5mm EHS64 Stereo Headset with Remote and Mic - Original OEM - Non-Retail Packaging - White
each.getText() = UrbanX 2021 Stereo Headphones for Samsung Galaxy S22 S21 Ultra 5G, Galaxy S20 FE, Galaxy A33 5G, A53 5G, M52, M53, A73 5G, Note 10, Note 10+ with Microphone and Volume Remote Type-C Connector
each.getText() = SAMSUNG Galaxy Buds Live, True Wireless Earbuds with Active Noise Cancelling, Microphone, Charging Case for Ear Buds, US Version, Onyx Black
each.getText() = SAMSUNG Galaxy Buds Pro True Wireless Bluetooth Earbuds w/ Noise Cancelling, Charging Case, IPX7 Water Resistant, Long Battery Life, Touch Control, US Version, Phantom Violet
each.getText() = SAMSUNG Galaxy Buds Live True Wireless Earbuds US Version Active Noise Cancelling Wireless Charging Case Included, Mystic Bronze
each.getText() = SAMSUNG Galaxy Buds2 True Wireless Earbuds Noise Cancelling Ambient Sound Bluetooth Lightweight Comfort Fit Touch Control, International Version (Graphite)
each.getText() = Samsung Stereo Headphones with Microphone for Galaxy S8, S9, S8 Plus, S9 Plus, Note 8 and Note 9 - Bulk Packaging - Titanium Grey
each.getText() = SAMSUNG Galaxy Buds Pro R190 Bluetooth Earbuds True Wireless, Noise Cancelling (Renewed)
each.getText() = Samsung Eo-Eg920Bw White Headset/Handsfree/Headphone/Earphone with Volume Control for Galaxy Phones (Non Retail Packaging - Bulk Packaging)
each.getText() = SAMSUNG Galaxy Buds 2 Pro True Wireless Bluetooth Earbuds w/ Noise Cancelling, Hi-Fi Sound, 360 Audio, Comfort Ear Fit, HD Voice, Conversation Mode, IPX7 Water Resistant, US Version, Graphite
each.getText() = Samsung AKG Earbuds Original 3.5mm in-Ear Earbud Headphones with Remote & Mic for Galaxy A71, A31, Galaxy S10, S10e, Note 10, Note 10+, S10 Plus, S9 - Includes Includes 3.5mm to Type-C Adapter - Black
each.getText() = OEM UrbanX 2021 Stereo Headphones for Samsung Galaxy S20 Ultra 5G Braided Cable with Microphone (Black) USB-C Connector (US Version with Warranty)
each.getText() = SAMSUNG Corded Type-C Earphones, White (EO-IC100BWEGUS)
each.getText() = USB C Headphones,USB Type C Earphones Wired Earbuds Magnetic Noise Canceling in-Ear Headset with Microphone for iPad Pro Samsung Galaxy S22 S21 Ultra S20 FE Note 10 20 Pixel 5 4a 3a XL Oneplus 9 8 8T
each.getText() = iLuv TB100 Wireless Earbuds, Bluetooth 5.3, Built-in Microphone, 20 Hour Playtime, IPX6 Waterproof Protection, Compatible with Apple & Android, Includes Charging Case & 4 Ear Tips, Rose Gold

 */
    }
}
