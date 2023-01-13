package Day09_221223_JSEScroll_Cookies_Files;

import Utilities.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

/*
Go to URL: http://facebook.com
getCookies,
addCookie,
deleteCookieNamed,
deleteAllCookies.
 */
public class C98_Cookies extends BaseTest {
    @Override
    public void tearDown() {
        super.tearDown();
    }

    @Test
    public void test01() {
//Go to URL: http://facebook.com
        driver.get("http://facebook.com");

//getCookies,
        Set<Cookie> cookies = driver.manage().getCookies();
        cookies.forEach(t -> System.out.println(t.getName().toString()));

//addCookie,
        Cookie cerez1 = new Cookie("Kalem", "FaberCastel Mavi0.7");
        driver.manage().addCookie(cerez1);
        Assert.assertEquals(cerez1.getValue(), driver.manage().getCookieNamed(cerez1.getName()).getValue());
        Set<Cookie> tumCerezler = driver.manage().getCookies();
        System.out.println("tumCerezler.size() = " + tumCerezler.size());//tumCerezler.size() = 1
        System.out.println("tumCerezler = " + tumCerezler);//tumCerezler = [Kalem=FaberCastel Mavi0.7; path=/; domain=www.facebook.com;secure;]

//deleteCookieNamed,
        driver.manage().deleteCookie(cerez1);
        Set<Cookie> kalanCerez = driver.manage().getCookies();
        System.out.println("kalanCerez.size() = " + kalanCerez.size());//kalanCerez.size() = 0

//deleteAllCookies.
        driver.manage().deleteAllCookies();
        tumCerezler = driver.manage().getCookies();
        System.out.println("tumCerezler.size() = " + tumCerezler.size());//tumCerezler.size() = 0
        Assert.assertFalse(driver.manage().getCookies().contains("Kalem"));
    }
}