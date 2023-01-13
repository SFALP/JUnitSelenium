package Day13_221228_Log4j_SeleniumExceptions_ExtentReport;

import Utilities.BaseTestReport;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C03_ExtentReport extends BaseTestReport {

    @Test
    public void test01() throws InterruptedException {

        //Testi yapacak olan her turlu mesaji, gecip kaldigini belirtecek extentTest objemizi olusturuyoruz.

        extentTest = extentReports.createTest("My Test", "Bu bir aciklamadir");

        extentTest.info("Amazona gidiliyor...");
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        extentTest.info("Arama kismina log4j yazdiriliyor");
        searchBox.sendKeys("Log4j");//arama bolumune log4j ifadesi yazdirildi

//Pass mesaji
        extentTest.pass("Testimiz gecerli");

//Info mesaji
        extentTest.fail("Testimiz gecersiz");

//Skip mesaji
        extentTest.skip("Testimiz skip edildi");
    }
}