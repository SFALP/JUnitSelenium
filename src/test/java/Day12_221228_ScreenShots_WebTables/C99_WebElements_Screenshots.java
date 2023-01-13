package Day12_221228_ScreenShots_WebTables;

import Utilities.BaseTest;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
Go to URL: https://opensource-demo.orangehrmlive.com/
Getting screenshot of  Orange HRM Page Section.
Save the screenshot with format 'screenshotname_yyyy_MM_dd_hh_mm_ss.png'
 */
public class C99_WebElements_Screenshots extends BaseTest {
    @Override
    public void tearDown() {
        super.tearDown();
    }

    @Test
    public void test01() throws IOException, InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(5000);

        WebElement logo=driver.findElement(By.xpath("//img[@alt='company-branding']"));

        File logoSc=logo.getScreenshotAs(OutputType.FILE);

        String date= new SimpleDateFormat("yyyy-MM-ddhh:mm:ss").format(new Date());

        String path = "test-outputs\\Screenshots_" + date + ".png";

        System.out.println("path = " + path);

// Dosyamizi kaydettik
        FileUtils.copyFile(logoSc,new File(path));
    }
}