package Day06_221220_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDown {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        //       driver.close();
    }

    @Test
    public void selectedByIndex() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        //dropdown locate edildi.
        WebElement dropDown = driver.findElement(By.name("country"));
//Locate edilen dropdown objesine donusturuldu.
        Select select = new Select(dropDown);
        select.selectByIndex(1);//ALGERIA otomatik olarak secilecektir

        //selectByIndex methodu, 0 ile baslar.


    }

    @Test
    public void selectedByValue() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        //dropdown locate edildi.
        WebElement dropDown = driver.findElement(By.name("country"));
//Locate edilen dropdown objesine donusturuldu.
        Select select = new Select(dropDown);
        select.selectByValue("TURKEY");//TURKEY otomatik olarak secilecektir

//selectByValue methodu, option elementlerinin value attribute urun degerine gore secim yapar
    }

    @Test
    public void selectedByVisibleText() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        //dropdown locate edildi.
        WebElement dropDown = driver.findElement(By.name("country"));
//Locate edilen dropdown objesine donusturuldu.
        Select select = new Select(dropDown);
        select.selectByVisibleText("GERMANY");//GERMANY otomatik olarak secilecektir

        System.out.println("select.isMultiple() = " + select.isMultiple());
    }

    @Test//BIRDEN FAZLA SECENEK SECTIRILME ISLEMI
    public void multipleSelect() {
        driver.get("https://output.jsbin.com/osebed/2");
        //Dropdown locate ediliyor.
        Select select = new Select(driver.findElement(By.id("fruits")));

        System.out.println(select.isMultiple());
        select.selectByValue("banana");
        select.selectByIndex(3);//Grape

    }

    @Test
    public void getOptions() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        Select select = new Select(driver.findElement(By.name("country")));

        //getOptions() methodu select elementinin tum seceneklerini (optionlarini) bir liste icinde bize verir.
        List<WebElement> options = select.getOptions();
        for (WebElement opt : options) {
            System.out.println("opt.getText() = " + opt.getText());
        }
    }

    @Test
    public void getFirstSelectedOption() {
        driver.get("https://output.jsbin.com/osebed/2");
        Select select = new Select(driver.findElement(By.id("fruits")));
        select.selectByIndex(3);//Grape-_> 4.element
        select.selectByIndex(2);//Orange

        WebElement selectedOption = select.getFirstSelectedOption();
        System.out.println("selectedOption.getText() = " + selectedOption.getText());
        //OUTPUT= Orange. Cunku secili olan elementlerde ilk sirada olani secerek ekranda yazdirdi

// getFirstSelectedOption(); methodu, secili olan ilk option elementini bize verir.

    }

    @Test
    public void getAllSelectedOptions() {
        driver.get("https://output.jsbin.com/osebed/2");

        Select select = new Select(driver.findElement(By.id("fruits")));
        select.selectByValue("banana");
        select.selectByValue("apple");

        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        selectedOptions.forEach(t -> System.out.println(t.getText()));
    }


}