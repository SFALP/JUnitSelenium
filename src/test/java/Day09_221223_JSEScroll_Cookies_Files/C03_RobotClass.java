package Day09_221223_JSEScroll_Cookies_Files;

import Utilities.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;
/*
Robot Sınıfı: Selenium komut dosyalarında, tarayıcı ve masaüstü açılır pencerelerini
otomatikleştirmek için Robot classını kullanırız .
Genellikle tarayıcılara/tarayıcılardan dosya yükleme/indirme işlemlerinde kullanılır. Fare ve klavye işlemlerini
gerçekleştirmek için Robot classını kullanıyoruz. Robot class otomasyon süreci ile kullanımı çok kolaydır. Java
otomasyon frameworkleri ile kolayca entegre edilebilir.
 */
public class C03_RobotClass extends BaseTest {
    @Override
    public void tearDown() {
//        super.tearDown();
    }

    @Test
    public void test01() throws AWTException, InterruptedException {
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement input = driver.findElement(By.id("uploadfile_0"));
        input.sendKeys("C:\\Users\\sevba\\IdeaProjects\\CWJunitSelenium\\src\\test\\java\\Resources\\robot.txt");

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);//keyPress tusa basili tutar, ctrl'ye basar.
        robot.keyPress(KeyEvent.VK_S);//s tusuna basilir.

        Thread.sleep(2000);//Ekranda gorulmesi icin 2'sn beklendi

        robot.keyRelease(KeyEvent.VK_S);//keyRelease, basilan tusu serbest birakir. S tusundan parmagi kaldirdik.
        robot.keyRelease(KeyEvent.VK_CONTROL);//keyRelease, basilan tusu serbest birakir.

        Thread.sleep(2000);//Ekranda gorulmesi icin 2sn beklendi

        robot.keyPress(KeyEvent.VK_ENTER);//enter tusuna bastik
        robot.keyRelease(KeyEvent.VK_ENTER);//enter tusunu biraktik

        Thread.sleep(2000);//Ekranda gorulmesi icin 2sn beklendi

//Eger kaydetme islemi dis kaynakli sebeplerden(net,pc vs) dolayi yapilamazsa agidaki koddan destek alinarak cozulebilir.

        robot.keyPress(KeyEvent.VK_LEFT);//sol oka basildi.
        robot.keyPress(KeyEvent.VK_ENTER);//enter'a basildi
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_LEFT);

        Thread.sleep(2000);
    }
}