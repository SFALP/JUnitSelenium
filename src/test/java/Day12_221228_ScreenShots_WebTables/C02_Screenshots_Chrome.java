package Day12_221228_ScreenShots_WebTables;

import Utilities.BaseTest;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_Screenshots_Chrome extends BaseTest {
    @Override
    public void tearDown() {
//        super.tearDown();
    }

    @Test
    public void getPageScreenshot() throws IOException {
        driver.get("https://www.n11.com/");

//Screenshot'umuzu File class indan bir objeye aliyoruz
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

// Aldigimiz screenshot istedigimiz path e kaydediyoruz
        FileHandler.copy(source, new File("test-outputs/Screenshots/n11PageScreenshot.png"));

    }

    @Test
    /*TASK
    Go to URL: https://opensource-demo.orangehrmlive.com/
Saving the image to  the path.
Getting screenshot of Orange HRM Logo.
Getting screenshot of  Orange HRM Page Section.

     */
    public void getElementScreenshot() throws IOException {
        driver.get("https://opensource-demo.orangehrmlive.com/");

//Screenshot u alinacak elementimizi locate ettik
        WebElement logo = driver.findElement(By.className("orangehrm-login-branding"));

// Element uzerinden screenshot umuzu aldik
        File logoScreenshot = logo.getScreenshotAs(OutputType.FILE);

// Ozel isimler olabilmesi adina date imizi dosya isimlerimizin yanina ekledik
        String date = new SimpleDateFormat("yyyy-MM-dd_hh:mm:ss").format(new Date());

        String path = "test-outputs\\Screenshots\\logoScreenshot_" + date + ".png";

        System.out.println(path);

// Dosyamizi kaydettik
        FileUtils.copyFile(logoScreenshot, new File(path));
    }
}