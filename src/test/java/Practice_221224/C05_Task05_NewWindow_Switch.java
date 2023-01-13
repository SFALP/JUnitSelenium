package Practice_221224;

import Utilities.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Set;

/*
    ● https://the-internet.herokuapp.com/windows adresine gidin.
    ● Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
    ● Sayfa başlığının (title) "The Internet" olduğunu doğrulayın.
    ● Click Here butonuna basın.
    ● Açılan yeni pencerenin sayfa başlığının (title) "New Window" olduğunu doğrulayın.
    ● Sayfadaki textin "New Window" olduğunu doğrulayın.
    ● Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu doğrulayın.
*/
public class C05_Task05_NewWindow_Switch extends BaseTest {
    @Override
    public void tearDown() {
//        super.tearDown();
    }

    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/windows");

//Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
        Assert.assertEquals(driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText(), "Opening a new window");

//Sayfa başlığının (title) "The Internet" olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

// Click Here butonuna basın.
        String firstPageHandle = driver.getWindowHandle();

        driver.findElement(By.linkText("Click Here")).click();

        Set<String> allWindowHandles = driver.getWindowHandles();

        String secondWindowHandle = "";

        for (String each : allWindowHandles) {
            if (!each.equals(firstPageHandle)) {
                secondWindowHandle = each;
            }

        }
        driver.switchTo().window(secondWindowHandle);

// Açılan yeni pencerenin sayfa başlığının (title) "New Window" olduğunu doğrulayın.
        Assert.assertEquals(driver.getTitle(), "New Window");

// Sayfadaki textin "New Window" olduğunu doğrulayın.
        Assert.assertEquals(driver.findElement(By.xpath("//h3[text()='New Window']")), "New Window");

// Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu doğrulayın.
        driver.switchTo().window(firstPageHandle);
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
    }
}