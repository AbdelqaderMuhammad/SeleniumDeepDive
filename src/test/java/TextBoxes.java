import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextBoxes {
    ChromeDriver driver ;

    @BeforeTest
    public void openURL() {

        // set the property
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver() ;
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void testBrowserCommands() {
        WebElement txtUserName = driver.findElementByCssSelector("input[id='username']") ;
        WebElement txtPassword = driver.findElementByCssSelector("input[id='password']") ;
        WebElement btnlogin = driver.findElement(By.cssSelector("button[type='submit']"));

        txtUserName.sendKeys("tomsmith");
        txtPassword.sendKeys("SuperSecretPassword!");
        btnlogin.click();

        // assertion
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");

    }

//    @AfterTest
//    public void closeDriver() {
//        driver.close();
//    }
}
