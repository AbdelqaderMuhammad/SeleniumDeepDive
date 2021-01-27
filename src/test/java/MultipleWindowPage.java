import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class MultipleWindowPage {

    ChromeDriver driver ;

    @BeforeTest
    public void openURL() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver() ;
        driver.navigate().to("http://cookbook.seleniumacademy.com/Config.html");
    }

    @Test(enabled = false)
    public void testWindowUsingTitle() {

        String currentWindowID = driver.getWindowHandle();
        System.out.println(driver.getTitle());
        driver.findElement(By.id("visitbutton")).click() ;

        for (String windowID : driver.getWindowHandles() ) {
            String title = driver.switchTo().window(windowID).getTitle();
            if (title.equals("Visit Us")) {
                Assert.assertEquals("Visit Us", driver.getTitle());
                break;
            }
        }
    }

    @Test
    public void testWindowByName() {

        driver.findElement(By.id("helpbutton")).click();
        driver.switchTo().window("HelpWindow") ;
        Assert.assertEquals("Help", driver.getTitle());
    }

//    @AfterTest
//    public void closeDriver() {
//        driver.quit();
//    }

}
