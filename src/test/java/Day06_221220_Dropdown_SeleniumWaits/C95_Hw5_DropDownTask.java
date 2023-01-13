package Day06_221220_Dropdown_SeleniumWaits;

import Utilities.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/*
Go to URL: https://the-internet.herokuapp.com/dropdown
Create method selectByIndexTest and Select Option 1 using index .
Create method selectByValueTest Select Option 2 by value.
Create method selectByVisibleTextTest Select Option 1 value by visible text.
Create method printAllTest Print all dropdown value.
Verify the dropdown has Option 2 text.
Create method printFirstSelectedOptionTest Print first selected option.
Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
 */
public class C95_Hw5_DropDownTask extends BaseTest {
    @Override
    public void tearDown() {
        //    super.tearDown();
    }

    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement slct1 = driver.findElement(By.id("dropdown"));
//Create method selectByIndexTest and Select Option 1 using index .
        Select select1 = new Select(slct1);
        select1.selectByIndex(1);
    }

    @Test
    public void test02() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement slct2 = driver.findElement(By.id("dropdown"));
//Create method selectByValueTest Select Option 2 by value.
        Select select2 = new Select(slct2);
        select2.selectByValue("2");
    }

    @Test
    public void test03() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement slct3 = driver.findElement(By.id("dropdown"));
//Create method selectByVisibleTextTest Select Option 1 value by visible text.
        Select select3 = new Select(slct3);
        select3.selectByVisibleText("Option 1");
    }

    @Test
    public void test04() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement slct4 = driver.findElement(By.id("dropdown"));
//    Create method printAllTest Print all dropdown value.
        Select select4 = new Select(slct4);
        select4.getOptions().stream().forEach(t -> System.out.println(t.getText()));
    }

    @Test
    public void test05() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement slct5 = driver.findElement(By.id("dropdown"));
//Verify the dropdown has Option 2 text.
        Select select5 = new Select(slct5);
        List<WebElement> list5 = select5.getOptions();
        Assert.assertTrue(list5.stream().anyMatch(t -> t.getText().contains("Option 2")));
    }

    @Test
    public void test06() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement slct6 = driver.findElement(By.id("dropdown"));
//    Create method printFirstSelectedOptionTest Print first selected option.
        Select select6 = new Select(slct6);
        select6.selectByIndex(2);
        select6.selectByIndex(1);

        WebElement selectedOption6 = select6.getFirstSelectedOption();
        System.out.println("selectedOption6.getText() = " + selectedOption6.getText());
    }

    @Test
    public void test07() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement slct7 = driver.findElement(By.id("dropdown"));
//    Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
        Select select7 = new Select(slct7);
        List<WebElement> listElement7 = select7.getOptions();
        int size = listElement7.size();
        System.out.println("size = " + size);//size = 3
        if (size != 3) {
            System.out.println("Expected Is Not Equal Actual");
        }else System.out.println("Expected Is Equal Actual");
//Expected Is Equal Actual
    }
}