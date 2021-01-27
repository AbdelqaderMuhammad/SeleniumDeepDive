import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScrollDown {

    ChromeDriver driver ;
    @BeforeTest
    public void openURL() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver() ;
        driver.navigate().to("https://the-internet.herokuapp.com/");
    }

    @Test
    public void testScroll() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // to scroll down to the end of the page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        // scroll to find an element
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(
                By.linkText("Challenging DOM")));

    }




}
