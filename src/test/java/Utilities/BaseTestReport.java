package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseTestReport {

    protected WebDriver driver;

    protected ExtentReports extentReports;//raporlama islemini gerceklestirir.

    protected ExtentHtmlReporter extentHtmlReporter;//Raporu HTML olarak duzenler.

    protected ExtentTest extentTest;//testimizin pass veya fail verisini saklayan objemizdir.
    //Ekran goruntuleri icin de kullanilir.

    @Before

    public void setup() {
        //Driver objemizi olusturduk ve konfigure ettik.
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //Extent report objelerimizi de olusturuyoruz.
        extentReports = new ExtentReports();

        //Kaydedecegimiz dosya icin tarih String'i olusturuldu.
        String currentDate = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
        String filePath = System.getProperty("user.dir") + "/test-output/reports/testReports_" + currentDate + ".html";

        //HTML raporu olusturacak obje dosya yoluyla initialize edildi.
        extentHtmlReporter = new ExtentHtmlReporter(filePath);

        //Raporlama yapan extendReport objemize HTML reporter baglandi.
        extentReports.attachReporter(extentHtmlReporter);

        //Raporla alakali extra opsiyonel bilgiler verildi
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Browser", "Chrome");

        //HTML raporunda goruntulemek istenilen konfigurasyonlar yapildi
        extentHtmlReporter.config().setDocumentTitle("CWReport");
        extentHtmlReporter.config().setReportName("Test run report");
    }

    @After
    public void tearDown() {
        driver.quit();
        extentReports.flush();//flush=sifon anlamina gelir. Bu kodla extent edilen raporlar silinmis/kapatilmis olur.
    }
}