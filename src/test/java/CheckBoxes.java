import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBoxes {

    ChromeDriver driver ;

    @BeforeTest
    public void openURL() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver() ;
        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");

    }

    @Test (enabled = false)
    public void findElements() {

        WebElement checkBox1 = driver.findElement(By.xpath("//input[1]")) ;
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]")) ;

        checkBox1.click();

        if (checkBox2.isSelected()) {
            checkBox2.click();
        }

    }

    @Test
    public void testIsElementPresent () {
        if (isElementPresent(By.xpath("//input[1]"))) {
            WebElement checkBox1 = driver.findElement(By.xpath("//input[1]")) ;
            if (checkBox1.isSelected()) {
                checkBox1.click();
            } else {
                checkBox1.click();
            }
        } else {
            Assert.fail("Check box 1 does not exist !");
        }
    }

    private boolean isElementPresent (By by) {
        try {
            driver.findElement(by) ;
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


//    @AfterTest
//    public void closeDriver() {
//        driver.close();
//    }

}
