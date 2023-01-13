package Day06_221220_Dropdown_SeleniumWaits;

import Utilities.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/*
Launch the browser.
Open "https://demoqa.com/select-menu".
Select the Standard Multi-Select using the element id.
Verifying that the element is multi-select.
Select 'Opel' using the index and deselect the same using index.
Select 'Saab' using value and deselect the same using value.
Deselect all the options.
Close the browser.
 */
public class C94_Hw6_Task extends BaseTest {
    @Override
    public void tearDown() {
        super.tearDown();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");

//Select the Standard Multi-Select using the element id.
        WebElement selectMulti = driver.findElement(By.id("cars"));
        Select select = new Select(selectMulti);

//Verifying that the element is multi-select.
        Assert.assertTrue(select.isMultiple());

//Select 'Opel' using the index and deselect the same using index.
        select.selectByIndex(2);
        Thread.sleep(1500);
        select.deselectByIndex(2);

//Select 'Saab' using value and deselect the same using value.
        select.selectByValue("saab");
        Thread.sleep(2000);
        select.deselectByValue("saab");

//Deselect all the options.
        select.deselectAll();

//Close the browser.
    }
}