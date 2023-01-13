package Day12_221228_ScreenShots_WebTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class C01_ScreenshotsFull_Firefox {
    @Test
    public void fullPageScreetShots() throws IOException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.amazon.com");

        File source = ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);

//test--> outputs --> Screenshots--> screenshots.png
        FileUtils.copyFile(source, new File("test-outputs\\Screenshots\\amazonFullScreenshots.png"));

        driver.close();
    }
}