import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FramesPage {

    ChromeDriver driver ;

    @BeforeTest
    public void openURL() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver() ;
        driver.navigate().to("http://cookbook.seleniumacademy.com/Frames.html");
    }

    @Test(enabled = false)
    public void rightFrame() {
        driver.switchTo().frame("right") ;
        WebElement rMsg = driver.findElement(By.tagName("p"));
        System.out.println(rMsg.getText());
        driver.switchTo().defaultContent();
    }

    @Test
    public void middleFrame() {
        driver.switchTo().frame(1) ;
        WebElement Msg = driver.findElement(By.tagName("p"));
        System.out.println(Msg.getText());
        driver.switchTo().defaultContent();
    }

//    @AfterTest
//    public void closeDriver() {
//        driver.quit();
//    }

}
