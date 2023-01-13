package Day07_221221_iFrame_WindowHandles;

import Utilities.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Iterator;
import java.util.Set;

/*
Go to URL: https://demoqa.com/browser-windows
Click on the windows - "WindowButton"
Click on all the child windows.
Print the text present on all the child windows in the console.
Print the heading of the parent window in the console.
 */
public class C97_Hw3_WindowHandleTask02 extends BaseTest {
    @Test
    public void test01() {
        driver.get("https://demoqa.com/browser-windows");

//Click on the windows - "WindowButton"
        String firstWindows = driver.getWindowHandle();
        driver.findElement(By.id("tabButton")).click();
        driver.findElement(By.id("windowButton")).click();

//Click on all the child windows.
        Set<String> allWindow = driver.getWindowHandles();
        Iterator<String> iterWindow = allWindow.iterator();

//Print the text present on all the child windows in the console.
        while (iterWindow.hasNext()) {
            driver.switchTo().window(iterWindow.next());
            if (driver.getWindowHandle().equals(firstWindows)) continue;
        }

//Print the heading of the parent window in the console.
        System.out.println("Text on the child window: " + driver.findElement(By.tagName("body")).getText());
        driver.switchTo().window(firstWindows);
        System.out.println("Heading of the parent window: " + driver.getTitle());
    }
}