package Day08_221222_WindowHandles_Actions;

import Utilities.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C02_Actions extends BaseTest {

    @Test
    public void doubleClick() {
        driver.get("https://demoqa.com/buttons");
        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));

        Actions actions = new Actions(driver);

        actions.doubleClick(doubleClickBtn).perform();

        Assert.assertTrue(driver.findElement(By.id("doubleClickMessage")).isDisplayed());
    }

    @Test
    public void rightClick() {
        driver.get("https://demoqa.com/buttons");
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));

        Actions actions = new Actions(driver);

        actions.contextClick(rightClickBtn).build().perform();

        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));
        Assert.assertTrue(rightClickMessage.isDisplayed());

    }

    @Test
    public void click() {
        driver.get("https://demoqa.com/buttons");
        WebElement clickBtn = driver.findElement(By.xpath("//button[text()='Click Me']"));
        Actions actions = new Actions(driver);
        actions.click(clickBtn).perform();

        WebElement dynamicClickMessage = driver.findElement(By.id("dynamicClickMessage"));
        Assert.assertTrue(dynamicClickMessage.isDisplayed());
    }
}