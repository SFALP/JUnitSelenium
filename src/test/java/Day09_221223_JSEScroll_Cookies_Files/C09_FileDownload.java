package Day09_221223_JSEScroll_Cookies_Files;

import Utilities.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.file.Files;
import java.nio.file.Paths;

/*
Go to URL: https://opensource-demo.orangehrmlive.com/
Login page valid credentials.
Download sample CSV file.
Verify if the file downloaded successfully.
 */
public class C09_FileDownload extends BaseTest {
    @Override
    public void tearDown() {
//        super.tearDown();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/");
// Sisteme giris yapiyoruz
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Admin");

        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys("admin123");
//Login'e tiklandi:
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

// Indirilecek dosyaya gitmek icin gerekli adimlar
        WebElement pim = driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[2]"));
        pim.click();

        WebElement configuration = driver.findElement(By.xpath("//span[@class='oxd-topbar-body-nav-tab-item']"));
        configuration.click();

        WebElement dataImport = driver.findElement(By.xpath("(//a[@role='menuitem'])[3]"));
        dataImport.click();

        WebElement downloadLink=driver.findElement(By.xpath("//a[@class='download-link']"));
        downloadLink.click();

        Thread.sleep(5000);//Tedbiren 5sn bekletildi(Net/Pc hizina bagli olarak bu sure degisebilir)

//Indirilen dosya pc'de var mi yok mu kontrol edilir. Bu noktadan sonra
        String downloadPath="C:\\Users\\sevba\\OneDrive\\Desktop\\importData.csv";

        // Dosyanin indirildigini kontrol ediyoruz
        Assert.assertTrue(Files.exists(Paths.get(downloadPath)));


    }

}
