import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class DoubleClick {

    ChromeDriver driver ;

    @BeforeTest
    public void openURL() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver() ;
        driver.navigate().to("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");
    }

    @Test
    public void doubleClick() {

        WebElement message = driver.findElement(By.id("message")) ;
        // assert for the color to be as blue e.g.
        Assert.assertEquals("rgba(0, 0, 255, 1)", message.getCssValue("background-color"));
        Actions builder = new Actions(driver) ;
        builder.doubleClick(message).perform();
        // we can assert here to find that the color has been changed.
        Assert.assertEquals("rgba(255, 255, 0, 1)", message.getCssValue("background-color"));
    }

//    @AfterTest
//    public void closeDriver() {
//        driver.close();
//    }

}
