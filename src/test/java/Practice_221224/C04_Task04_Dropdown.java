package Practice_221224;

import Utilities.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
/*

    ● https://the-internet.herokuapp.com/dropdown adresine gidin.
    1. Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın.
    2. Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın.
    3. Visible Text (Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın.
    4. Tüm dropdown değerleri(value) yazdırın.
    5. Dropdown'un boyutunu bulun, Dropdown'da 4 öğe varsa konsolda True, değilse False yazdırın.
*/

public class C04_Task04_Dropdown extends BaseTest {
    @Override
    public void tearDown() {
//        super.tearDown();
    }

    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropDown = driver.findElement(By.id("dropdown"));

//Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın.
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());
        //select.getFirstSelectedOption().getText() = Option 1

//Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın.
        select.selectByValue("2");
        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());
        //select.getFirstSelectedOption().getText() = Option 2

//Visible Text (Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın.
        select.selectByVisibleText("Option 1");
        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());
    //select.getFirstSelectedOption().getText() = Option 1

//Tüm dropdown değerleri(value) yazdırın.
        List<WebElement> allOptions = select.getOptions();
        allOptions.forEach(t -> System.out.println(t.getText()));
    //Please select an option
    //Option 1
    //Option 2

//Dropdown'un boyutunu bulun, Dropdown'da 4 öğe varsa konsolda True, değilse False yazdırın.
        if (allOptions.size() == 4) {
            System.out.println("True");
        } else System.out.println("False");
    //False
    }
}