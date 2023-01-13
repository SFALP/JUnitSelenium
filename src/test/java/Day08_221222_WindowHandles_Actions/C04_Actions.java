package Day08_221222_WindowHandles_Actions;

import Utilities.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C04_Actions extends BaseTest {

    @Test
    public void drogAndDropOffset() {
        //offset, horizontal duzlemde hareketin yapilacagi duzlemi belirtir. X ve Y olarak int deger alir.

        driver.get("https://rangeslider.js.org/");
        WebElement slider = driver.findElement(By.xpath("(//div[@class='rangeslider__handle'])[1]"));

//Bu slider sadece X eksenin hareket ettigi icin Y Offset degerine yazilan deger onemsizdir.
        Actions actions = new Actions(driver);

//Saga tasima islemlerinde X Offset + degerde, sola kaydirma islemlerinde de X Offset eksi (-) degerde olmalidir.
//Ayni zamanda dikey eksende hareket olmasini engellemek adina Y Offset degeri sifir(0) olarak belirlenmelidir.

        actions.dragAndDropBy(slider, -10, 30).perform();

    }

    @Test
    public void dragAndDropOffsetVertical() {

    }

}