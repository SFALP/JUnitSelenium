package Day07_221221_iFrame_WindowHandles;

import Utilities.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

// https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidiniz.
// Web sitesini maximize yapınız.
// İkinci emojiye tıklayınız.
// Tüm ikinci emoji öğelerine tıklayınız.
// Parent iframe geri dönünüz.
// Formu doldurun (Formu istediğiniz metinlerle doldurun) apply button'a basınız.
public class C02_iFrameEx02 extends BaseTest {
    @Override
    public void tearDown() {
//        super.tearDown();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        Thread.sleep(2000);
        driver.switchTo().frame("emoojis");
// İkinci emojiye tıklayınız.
        WebElement secondemojiTab = driver.findElement(By.xpath("//a[@class='mdl-tabs__tab']"));
        secondemojiTab.click();

// Tüm ikinci emoji öğelerine tıklayınız.
        List<WebElement> listEmoji = driver.findElements(By.xpath("//div[@id='nature']//img"));
        listEmoji.forEach(WebElement::click);

// Parent iframe geri dönünüz.
        driver.switchTo().defaultContent();

// Formu doldurun (Formu istediğiniz metinlerle doldurun) apply button'a basınız.
        WebElement text = driver.findElement(By.id("text"));
        text.sendKeys("Text");

        WebElement smiles = driver.findElement(By.id("smiles"));
        smiles.sendKeys("Smiles");

        WebElement nature = driver.findElement(By.id("nature"));
        nature.sendKeys("Nature");

        WebElement food = driver.findElement(By.id("food"));
        food.sendKeys("Food");

        WebElement activities = driver.findElement(By.id("activities"));
        activities.sendKeys("Activities");

        WebElement places = driver.findElement(By.id("places"));
        places.sendKeys("places");

        WebElement objects = driver.findElement(By.id("objects"));
        objects.sendKeys("Objects");

        WebElement applyButton = driver.findElement(By.id("send"));
        applyButton.click();
    }
}