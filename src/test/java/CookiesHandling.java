import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class CookiesHandling {

    ChromeDriver driver ;

    @BeforeTest
    public void openURL() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver() ;
        driver.navigate().to("http://magento-demo.lexiconn.com/");
    }

    @Test(priority = 2 )
    public void getAllCookie () {
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Number of cookies is " + cookies.size());
        Iterator<Cookie> i = cookies.iterator();
        while (i.hasNext()) {
            Cookie cookie = i.next();
            // get the domains for example
            System.out.println(cookie.getDomain());
        }
    }


    @Test (priority = 1)
    public void testCookies() {
        WebElement langSelect = driver.findElement(By.id("select-language") );
        Select selectList = new Select (langSelect) ;
        Cookie storeCookie = driver.manage().getCookieNamed("store");
        // assert that there is no cookies at the beginnings.
        Assert.assertEquals(null, storeCookie);
        // select a certain lang
        selectList.selectByVisibleText("German");
        storeCookie = driver.manage().getCookieNamed("store");
        System.out.println(storeCookie.getValue());
        // assert that the cookie for store has been saved.
        Assert.assertEquals("german", storeCookie.getValue());

    }








}
