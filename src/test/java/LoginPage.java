import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class LoginPage {

    ChromeDriver driver ;

    @BeforeTest
    public void openURL() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver() ;
        driver.navigate().to("https://the-internet.herokuapp.com/login");

    }

    @Test
    public void findElements() {
        WebElement userName = driver.findElementByXPath("//input[@id='username']");
        WebElement passWord = driver.findElementByXPath("//*[@id=\"password\"]");
        WebElement loginBtn = driver.findElementByXPath("//*[@id=\"login\"]/button");

        userName.sendKeys("tomsmith");
        passWord.sendKeys("SuperSecretPassword!");
        loginBtn.click();

        WebElement successBar = driver.findElement(By.id("flash"));
        Assert.assertTrue(successBar.getText().contains("You logged into a secure area!"));
    }


//    @AfterTest
//    public void closeDriver() {
//        driver.close();
//    }

}
