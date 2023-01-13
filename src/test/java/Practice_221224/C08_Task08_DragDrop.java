package Practice_221224;

import Utilities.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/*
    1- https://demoqa.com/droppable adresine gidelim.
    2- "Drag me" butonunu tutup "Drop here" kutusunun üstüne bırakalım.
    3- "Drop here" yazısı yerine "Dropped!" olduğunu test edin.
*/
public class C08_Task08_DragDrop extends BaseTest {
    @Override
    public void tearDown() {
//        super.tearDown();
    }

    @Test
    public void test01() {
        driver.get("https://demoqa.com/droppable");
        Actions actions = new Actions(driver);

        WebElement dragBox = driver.findElement(By.id("draggable"));
        WebElement dropBox = driver.findElement(By.xpath("//div[@id='droppable']"));
        actions.dragAndDrop(dragBox, dropBox).perform();

        Assert.assertEquals(driver.findElement(By.xpath("//*[text()='Dropped!']")).getText(), "Dropped!");

    }
}