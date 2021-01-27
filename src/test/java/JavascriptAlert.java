import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavascriptAlert {

    ChromeDriver driver ;

    @BeforeTest
    public void openURL() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver() ;
        driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");
    }

    @Test(enabled = true)
    public void alertAccept() {

        WebElement btnShowAlert = driver.findElement(By.id("simple")) ;
        btnShowAlert.click();

        Alert alert = driver.switchTo().alert();
        // assert the text to be the text of the alert
        Assert.assertEquals("Hello! I am an alert box!",alert.getText());
        alert.accept();
    }



//    @AfterTest
//    public void closeDriver() {
//        driver.quit();
//    }

}
