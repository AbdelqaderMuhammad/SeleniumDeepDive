import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class FluentWaitPage {

    ChromeDriver driver ;

    @BeforeTest
    public void openURL() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver() ;
        driver.navigate().to("http://cookbook.seleniumacademy.com/AjaxDemo.html");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
    }

    @Test
    public void FluentWait() {
        driver.findElement(By.linkText("Page 4")).click();
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
                withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement message = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return d.findElement(By.id("page4"));
            }
        }) ;

        Assert.assertTrue(message.getText().contains("Nunc nibh tortor")) ;

    }

//    @AfterTest
//    public void closeDriver() {
//        driver.quit();
//    }

}
