package Day01_221214_SeleniumMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Set Path.
// Create chrome driver.
// Maximize the window.
// Open google home page https://www.google.com/
// Verify that you are Google in the title.
public class C01_WebDriverManagerTest {
    public static void main(String[] args) {

        //System.setProperty() methodu yerine asagidaki method kullanilacaktir.
        // Artik asagida yazildigi gibi kullanilacaktir.

// WebDriverManager classini kullanarak chromedriver binary'lerimizi indirdik.
        WebDriverManager.chromedriver().setup();
//Driver objemizi olusturduk.
        WebDriver driver = new ChromeDriver();
//Ekrani maximize ettik.
        driver.manage().window().maximize();
//google URK sayfasini ziyaret ettik.
        driver.get("https://www.google.com/");
        String title = driver.getTitle();

        System.out.println("Title testi yapiliyor...");
        if (title.equalsIgnoreCase("Google")){
            System.out.println("Title test PASSED");
        }else System.out.println("Title test FAILED");
//driver'i(Browser'i) kapattik
        driver.close();
    }
}