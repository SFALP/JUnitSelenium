package Day09_221223_JSEScroll_Cookies_Files;

// Selenium ile cookies kontrolunu driver.manage.cookies ile cookies yonetimi yapilabilir.

import Utilities.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;
/* TASK
Go to URL: https://kitchen.applitools.com/ingredients/cookie
Get Cookie.
Find the total number of cookies.
Print all the cookies.
Add Cookie.
Edit Cookie.
Delete Cookie.
Delete All Cookies.
 */

public class C04_Cookies extends BaseTest {
    @Test
    public void cookies() {
        driver.get("https://kitchen.applitools.com/ingredients/cookie");
        System.out.println("***   Test get cookie   ***");
//Get Cookie.
        Cookie cookie = driver.manage().getCookieNamed("protein");//cookie isimle cagirildi.
        Assert.assertEquals("chicken", cookie.getValue());//true

//Find the total number of cookies.
        Set<Cookie> allCookies = driver.manage().getCookies();
        int numOfCookies = allCookies.size();
        System.out.println("numOfCookies = " + numOfCookies);//numOfCookies = 2

//Print all the cookies.
        for (Cookie each : allCookies) {
            System.out.println("Each Cookies: " + each);
            //(1)--> Each Cookies: protein=chicken; path=/; domain=kitchen.applitools.com

            System.out.println("Each Cookies Name: " + each.getName());
            //(2)--> Each Cookies: vegetable=broccoli; path=/; domain=kitchen.applitools.com

            System.out.println("Each Cookies Value: " + each.getValue());
            //(1)--> Each Cookies Name: protein
            //(1)--> Each Cookies Value: chicken
            //(2)--> Each Cookies Name: vegetable
            //(2)--> Each Cookies Value: broccoli
        }
//ADD COOKIES (Kendimiz cookie eklemek istersek
        System.out.println(" ***    Add Cookie  *** ");
        Cookie cookie1 = new Cookie("Fruit", "die Feige");//Ismi Fruit, degeri die Feige olan bir cookie tanimlandi.
        driver.manage().addCookie(cookie1);//Tanimlanan cookie driver'a eklendi.
        Assert.assertEquals("it does not match", cookie1.getValue(), driver.manage().getCookieNamed(cookie1.getName()).getValue());

        allCookies = driver.manage().getCookies();//sayfada yer alan cookies'leri gosterir.
        System.out.println("allCookies = " + allCookies.size());//allCookies = 3

//Edit Cookie.
        System.out.println(" *** Edit Cookies *** ");
        Cookie editCookie = new Cookie(cookie1.getName(), "Mango");//cookie1 ismiyle eklenen cookie'nin degeri dir Feige yerine Mango olarak guncellenmis olacak
        driver.manage().addCookie(editCookie);//editlenmis olan yani duzenlenmis olan cookie eklendi.

        Assert.assertEquals(editCookie.getValue(), driver.manage().getCookieNamed(cookie1.getName()).getValue());//true
        //Yukaridaki kodda guncellenen cookie'nin dereiyle eklenen cookie'nin detaylari karsilastirilarak dogrulandi.
        //Yani degerinin guncelleneip guncellenmedigi kontrol edilmis oldu.
        System.out.println(driver.manage().getCookieNamed(cookie1.getName()).getValue());//Mango
    }

    //Delete Cookie.
    @Test
    public void deleteCookies() {
        driver.get("https://kitchen.applitools.com/ingredients/cookie");
        System.out.println(" *** Delete Cookies *** ");
        Set<Cookie> allCookies = driver.manage().getCookies();
        int numOfCookies = allCookies.size();
        System.out.println("numOfCookies = " + numOfCookies); //numOfCookies = 2

        Cookie addedCookie = new Cookie("Drinks", "Ayran");
        //ismi Drinks, degeri ise Ayran olan bir cookie eklendi. Eklenen Cookie'nin ismi ise addedCookie olarak belirlendi.        driver.manage().addCookie(addedCookie);
        driver.manage().addCookie(addedCookie);// Olusturulan cookie bu kod'la siteye eklendi.
        allCookies = driver.manage().getCookies(); // sayfada var olan cookieleri dondurur
        System.out.println("allCookies = " + allCookies.size()); //allCookies = 3
        driver.manage().deleteCookie(addedCookie);//Ust satirlarda eklenen cookie, bu kodla silindi.

        Assert.assertNull("Cookie hala var", driver.manage().getCookieNamed(addedCookie.getName()));
        //eklenmis ancak sonradan silinmis olan Cookie'nin sitede olup olmadiginin kontrolu yapildi.
        //Eger Cookie silinmemisse (yani hala varsa) "Cookie hala var" mesajinin bize donmesini istedik.

        allCookies = driver.manage().getCookies(); // sayfada var olan cookieleri dondurur
        System.out.println("allCookies = " + allCookies.size()); //allCookies = 2

//Delete All Cookies.
        driver.manage().deleteAllCookies();//browser'da olan tum cookie'ler silinir.
        allCookies = driver.manage().getCookies(); // sayfada var olan cookieleri dondurur
        System.out.println("allCookies = " + allCookies.size()); // allCookies = 0
    }
}