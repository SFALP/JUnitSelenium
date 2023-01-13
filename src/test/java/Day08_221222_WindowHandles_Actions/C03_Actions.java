package Day08_221222_WindowHandles_Actions;

import Utilities.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_Actions extends BaseTest {

    @Test
    public void dragAndDrop() {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        WebElement washington = driver.findElement(By.id("box3"));
        WebElement cophenhagen = driver.findElement(By.id("box4"));
        WebElement seul = driver.findElement(By.id("box5"));
        WebElement rome = driver.findElement(By.id("box6"));
        WebElement madrid = driver.findElement(By.id("box7"));
        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement stockholm = driver.findElement(By.id("box2"));

//drag elements
        WebElement italy = driver.findElement(By.id("box106"));
        WebElement spain = driver.findElement(By.id("box107"));
        WebElement norway = driver.findElement(By.id("box101"));
        WebElement denmark = driver.findElement(By.id("box104"));
        WebElement southKorea = driver.findElement(By.id("box105"));
        WebElement sweden = driver.findElement(By.id("box102"));
        WebElement us = driver.findElement(By.id("box103"));

//drop elements
        Actions actions = new Actions(driver);//tek yazilmis hali

//zincirli yazilmis hali==>
        actions.dragAndDrop(madrid, spain).perform();
        actions.dragAndDrop(washington, us)
                .dragAndDrop(rome, italy)
                .dragAndDrop(seul, southKorea)
                .dragAndDrop(oslo, norway)
                .dragAndDrop(cophenhagen, denmark)
                .dragAndDrop(stockholm, sweden).perform();

// eger zincirli yazim calismazsa perform()'dan once .build() yazilarak sorun cozulebilir.
    }
}