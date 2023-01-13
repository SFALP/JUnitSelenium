package Day10_221226_ApachePOI;
/*
// Go to https://the-internet.herokuapp.com/download
//  Download sample.png file
//  Then verify if the file downloaded successfully
 */

import Utilities.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C99_DownloadFileTask extends BaseTest {
    @Override
    public void tearDown() {
//        super.tearDown();
    }

    @Test
    public void test01() throws InterruptedException {

// Go to https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");

//  Download sample.png file
        WebElement sample = driver.findElement(By.xpath("//a[@href='download/sample.png']"));
        sample.click();
        Thread.sleep(5000);

//  Then verify if the file downloaded successfully
        String downloadPath = "C:\\Users\\sevba\\Downloads";
        Assert.assertTrue(Files.exists(Paths.get(downloadPath)));
    }
}