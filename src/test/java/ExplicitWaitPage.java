import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExplicitWaitPage {

    ChromeDriver driver ;

    @BeforeTest
    public void openURL() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver() ;
        driver.navigate().to("http://www.google.com");
    }

    @Test
    public void ExplicitWaitFun() {

        WebElement queryTxt = driver.findElement(By.name("q")) ;
        queryTxt.sendKeys("selenium");
        queryTxt.submit();

        WebDriverWait wait = new WebDriverWait(driver, 20) ;
        wait.until(ExpectedConditions.titleContains("selenium"));
        Assert.assertTrue(driver.getTitle().startsWith("selenium"));
    }

//    @AfterTest
//    public void closeDriver() {
//        driver.quit();
//    }

}
