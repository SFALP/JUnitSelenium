package Day09_221223_JSEScroll_Cookies_Files;

import Utilities.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C11_AssertElementTrick extends BaseTest {
    @Override
    public void tearDown() {
//        super.tearDown();
    }

    @Test
    public void fileUpload() {
        driver.get("https://the-internet.herokuapp.com/upload");

        //Upload edilecek dosyamizi seciyoruz
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));
        dosyaSec.sendKeys("C:\\Users\\sevba\\OneDrive\\Desktop\\fileExist.png");

        // Upload butonuna basiyoruz
        WebElement uploadFile = driver.findElement(By.id("file-submit"));
        uploadFile.click();

//Yeniden implement edecegiz.

// Elementin locator unu ozellikle yanlis yazip durumu nasil handle ettigimizi kontrol ediyoruz

        List<WebElement> uploadedMessageList = driver.findElements(By.tagName("h3"));
        Assert.assertEquals("Upload mesaji goruntulenemedi", 1, uploadedMessageList.size());

        WebElement uploadMessage = uploadedMessageList.get(0);
        Assert.assertTrue(uploadMessage.isDisplayed());
        Assert.assertEquals("Mesajin texti istenildigi gibi degil", "File Uploaded!", uploadMessage.getText());
    }
}