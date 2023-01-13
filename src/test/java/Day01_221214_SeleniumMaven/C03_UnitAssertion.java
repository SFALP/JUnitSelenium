package Day01_221214_SeleniumMaven;
//ASSERTION, onceden IF ile yapilan kontrol yapilari Assertion classindaki iceriklerle yapilmasidir.

//    Go to Amazon homepage.
//    Do the following tasks by creating 3 different test methods.
//    1- Test if the URL contains Amazon.
//    2- Test if the title does not contain Facebook.
//    3- Test that the Amazon logo appears in the upper left corner.

/* Assertion cesitleri:
1-    assertEquals: Deger esitligine bakilir.
2-    assertTrue: Icerisindeki sartin dogrulugunu kontrol eder.
3-    assertFalse: Icerisindeki sartin dogrulugun yanlisligini kontrol eder.
4-    assertNull: Icerisindeki ifadenin bos oldugunu kontrol edilir.
5-    assertNotNull: Icerisindeki ifadenin bos olmadigi kontrolu yapilir.
6-    assertSame: Adres karsilastirmasi yapilir ve benzerlikler kontrol edilir.
7-    assertNotSame: Adres karsilastirmasi yapilir ve benzerlik olmayanlar kontrol edilir.
8-    assertArrayEquals: Arraylaerin esit uzunlukta olup olmadigi kontrol edilir.
*/
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_UnitAssertion {
    WebDriver driver;

    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void assertionTest() {
        driver.get("https://www.amazon.com");
        String currentURL = driver.getCurrentUrl();

//URL, amazon kelimesini icerip icermedigine dair kontrol saglaniyor
        Assert.assertTrue("URL 'amazon' icermiyor", currentURL.contains("amazon"));

    }

    @Test
    public void urlTest() {
        driver.get("https://www.amazon.com");
        String currentURL = driver.getCurrentUrl();

//URL, amazon kelimesini icerip icermedigine dair kontrol saglaniyor
        Assert.assertTrue("URL 'amazon' icermiyor", currentURL.contains("amazon"));

    }

    @Test
    public void titleTest() {
        driver.get("https://www.amazon.com");
        String driverTitle = driver.getTitle();
        Assert.assertFalse(driverTitle.contains("Facebook"));
    }

    //TO BE CONTINUED


}
