package Practice_221224;

import Utilities.BaseTest;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/*
    1. "https://facebook.com" adresine gidin.
    2. "Create New Account" butonuna basın.
    3. "firstName" giriş kutusuna bir isim yazın.
    4. "surname" giriş kutusuna bir soyisim yazın.
    5. "email" giriş kutusuna bir email yazın.
    6. "email" onay kutusuna emaili tekrar yazın.
    7. Bir şifre girin.
    8. Tarih için gün seçin.
    9. Tarih için ay seçin.
    10. Tarih için yıl seçin.
    11. Cinsiyeti seçin.
    12. İşaretlediğiniz cinsiyetin seçili, diğer cinsiyet kutularının seçili olmadığını doğrulayın.
    13. Sayfayı kapatın.
*/
public class C02_Task02_FacebookUyelik extends BaseTest {
    @Override
    public void tearDown() {
//        super.tearDown();
    }

    @Test
    public void test01() {
        driver.get("https://facebook.com");
        WebElement cookies = driver.findElement(By.xpath("//*[.='Temel ve isteğe bağlı çerezlere izin ver']"));
        cookies.click();
//"Create New Account" butonuna basın.
        WebElement newAccount = driver.findElement(By.linkText("Yeni Hesap Oluştur"));
        newAccount.click();

//"firstName" giriş kutusuna bir isim yazın.
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        Faker faker = new Faker();
        String eMail = faker.internet().emailAddress();
        Actions actions = new Actions(driver);

        actions.click(firstName)//first name bolumune tiklandi
                .sendKeys(faker.name().firstName())//first name bolumune Faker class'indan bir isim turetilerek girildi.

//"surname" giriş kutusuna bir soyisim yazın.
                .sendKeys(Keys.TAB)//Tab tusuna basilarak soyad bolumune gecildi. Boylelikle surekli WebElement uretilmemis oldu
                .sendKeys(faker.name().lastName())//soyad bolumune faker class'indan bir soyad turetilerek girildi

//"email" giriş kutusuna bir email yazın.
                .sendKeys(Keys.TAB)//Bu komutla soyad'dan--> mail bolumune gecis yapildi.
                .sendKeys(eMail)//Faker class'indan e mail adres olusturularak yazildi.

//"email" onay kutusuna emaili tekrar yazın.
                .sendKeys(Keys.TAB)
                .sendKeys(eMail)//Faker class'indan e mail adres olusturularak yazildi.

//Bir şifre girin.
                .sendKeys(Keys.TAB)//Sifre bolumune gecildi.
                .sendKeys(faker.internet().password())

//Tarih için gün seçin.(2 defa TAB'a basilince bu bolume geciyor)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1,30)))//1-30 arasinda sayi tanimlandi.

//Tarih için ay seçin.
                .sendKeys(Keys.TAB)//Ay bolumune gecildi
                .sendKeys("September")//Bir ay atandi

//Tarih için yıl seçin.
                .sendKeys(Keys.TAB)//Yil bolumune gidildi
                .sendKeys(String.valueOf(faker.number().numberBetween(1912,2022)))
//Cinsiyeti seçin.(2 defa TAB'a basilmalidir.)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
    // Bu bolumde cinsiyeti sadece ok tuslarina basilarak da secilebilmektedir "Erkek" icin bir kere sag tur,
    //"Kadin" icin bir kere sol tusa basilmasi yeterlidir.
                .sendKeys(Keys.ARROW_RIGHT)
//Kaydol bolumune gelebilmek icin 5 defa TAB'a basilmalidir.
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();//Kaydol'a tiklandi.

//İşaretlediğiniz cinsiyetin seçili, diğer cinsiyet kutularının seçili olmadığını doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value='2']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='1']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='-1']")).isSelected());

//Sayfayı kapatın.

    }
}
