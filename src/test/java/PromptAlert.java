import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PromptAlert {

    ChromeDriver driver ;

    @BeforeTest
    public void openURL() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver() ;
        driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");
    }

    @Test
    public void alertTxt() {

        WebElement btnShowAlert = driver.findElement(By.id("prompt")) ;
        btnShowAlert.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Abdelqader");
        alert.accept();
        // assertion
        Assert.assertEquals("Hello Abdelqader! How are you today?",
                driver.findElement(By.id("prompt_demo")).getText());
    }


//    @AfterTest
//    public void closeDriver() {
//        driver.close();
//    }

}
