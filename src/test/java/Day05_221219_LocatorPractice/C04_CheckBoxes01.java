package Day05_221219_LocatorPractice;

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

//    Go to https://the-internet.herokuapp.com/checkboxes
//    Locate the elements of checkboxes.
//    Then click on checkbox 1 if box is not selected.
//    Then click on checkbox 2 if box is not selected.
//    Then verify that checkbox 1 is checked.
public class C04_CheckBoxes01 {

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
//        driver.quit();
    }

    @Test
    public void checkBoxes() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //checkbox'lar locate edildi.
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        WebElement checkBox1 = checkboxes.get(0);//ilk siradaki elemani getirir.
        WebElement checkBox2 = checkboxes.get(1);//ikinci siradaki elemani getirir.

        // Checkbox'larin isaretli(secili) olup olmadiginin kontrolu yapilir.
        // Cunku test metninde bu bolumler isaretli degilse isaretlenmesi bizden istenmis.
        // Bu nedenle once kontrol yapisi kurmaliyiz

        //checkbox1 secili degilse tikliyoruz.
        if (!checkBox1.isSelected()) {
            checkBox1.click();
        }

        //checkbox2 secili degilse tikliyoruz.
        if (!checkBox2.isSelected()) {
            checkBox2.click();
        }

        Assert.assertTrue(checkBox1.isSelected());//Checkbox1'in isaretli olup olmadigi kontrol edildi.
        Assert.assertTrue(checkBox2.isSelected());//Checkbox2'in isaretli olup olmadigi kontrol edildi.




    }

}
