package Day06_221220_Dropdown_SeleniumWaits;

import com.github.javafaker.Faker;
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

/*
Go to URL: https://opensource-demo.orangehrmlive.com/
Login with Username: Admin
Login with Password: admin123
Click login button
Click on PIM
Click on Employee List
    Employee Name -> Use Faker Class
    ID -> Use Faker Class
    Employment Status -> select by index: 2
    Include -> selectByVisibleText: Current and Past Employees
    Supervisor Name -> Use Faker Class
    Job Title ->selectByValue: IT Manager
    Sub Unit ->selectByValue: 3
Click search button
Verify text visible : "No Records Found"
 */
public class C96_Hw4_DropDownFaker {
    WebDriver driver;
    Faker faker = new Faker();//Faker class olusturuldu.

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
    public void test01() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Admin");

        WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
        pass.sendKeys("admin123");
//Login sekmesine tiklandi.
        driver.findElement(By.xpath("//button[text()=' Login ']")).click();

        Thread.sleep(2000);//Tedbiren 2sn beklendi.

//PIM secenegi tiklandi
        driver.findElement(By.xpath("//li[@class='oxd-main-menu-item-wrapper'][2]")).click();

        Thread.sleep(2000);//Tedbiren 2sn beklendi.
// Employee Information menusu acildi.
//        driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill']")).click();

//Employee Name bolu bulundu ve Faker Class'dan atama yapildi.
        WebElement empName = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
        empName.sendKeys(faker.name().firstName() + " " + faker.name().lastName());

        driver.findElement(By.xpath("//button[@class='oxd-icon-button oxd-main-menu-button']")).click();
        Thread.sleep(1000);

// Employee ID verisi icin faker class'tan atama yapildi.
        WebElement empId = driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active']"));
        String fakeID=faker.number().digits(7).toString();
        empId.sendKeys(fakeID);

//EmploymentStatus secilmesi
        WebElement empStatus = driver.findElement(By.xpath("//div[@class='oxd-select-text-input'][1]"));
//        empStatus.click();
        Select select1 = new Select(empStatus);
        select1.selectByIndex(2);

//Include bolumunde yapilmak istenen secim:
        WebElement include = driver.findElement(By.xpath("//div[text()='Current Employees Only']"));
//        include.click();
        Select select2 = new Select(include);
        select2.selectByVisibleText("Current and Past Employees");

//Supervisor name bolumune Faker class'tan isim doldurulması islemi:
        WebElement supervisor = driver.findElement(By.xpath("//input[@placeholder='Type for hints...'][2]"));
        supervisor.sendKeys(faker.name().firstName() + " " + faker.name().lastName());

//Job Title ->selectByValue: IT Manager
        WebElement jobTitle = driver.findElement(By.xpath("//div[@class='oxd-select-text oxd-select-text--active'][3]"));
        jobTitle.click();
        Select select3 = new Select(jobTitle);
        select3.selectByValue("IT Manager");

//   Sub Unit ->selectByValue: 3 islemi
        WebElement subUnit= driver.findElement(By.xpath("//div[@class='oxd-select-text-input']"));
        subUnit.click();
        Select select4=new Select(subUnit);
        select4.selectByValue("3");

//Click search button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

//Verify text visible : "No Records Found"

    }
}
