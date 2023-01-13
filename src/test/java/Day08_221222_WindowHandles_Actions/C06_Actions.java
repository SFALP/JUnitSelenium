package Day08_221222_WindowHandles_Actions;

import Utilities.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C06_Actions extends BaseTest {
    @Override
    public void tearDown() {
//        super.tearDown();
    }

    @Test
    public void keyboardActions(){
        driver.get("https://demoqa.com/auto-complete");

        WebElement input= driver.findElement(By.xpath("//div[@id='autoCompleteSingleContainer']"));

        //You are Exceptional

        Actions actions=new Actions(driver);

        actions
                .click(input)
                .keyDown(Keys.SHIFT)
                .sendKeys("y")
                .keyUp(Keys.SHIFT)
                .sendKeys("ou are ")
                .keyDown(Keys.SHIFT)
                .sendKeys("e")
                .keyUp(Keys.SHIFT)
                .sendKeys("xceptional")
                .perform();
    }
}