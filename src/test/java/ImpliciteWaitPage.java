import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImpliciteWaitPage {

    ChromeDriver driver ;

    @BeforeTest
    public void openURL() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver() ;
        driver.navigate().to("http://cookbook.seleniumacademy.com/AjaxDemo.html");
    }

    @Test
    public void implicitWaitOnFindingElements() {

        driver.findElement(By.linkText("Page 4")).click() ;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
        Assert.assertTrue(driver.findElement(By.id("page4"))
                .getText().contains("Nunc nibh tortor") ) ;
        System.out.println(driver.findElement(By.id("page4"))
                .getText());
    }


}
