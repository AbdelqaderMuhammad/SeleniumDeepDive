import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContextMenu {

    ChromeDriver driver ;

    @BeforeTest
    public void openURL() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver() ;
        driver.navigate().to("https://swisnl.github.io/jQuery-contextMenu/demo.html");

    }

    @Test
    public void testContextMenu() {
        WebElement btnRClick = driver.findElementByCssSelector("span.context-menu-one.btn.btn-neutral") ;
        WebElement editClick = driver.findElementByCssSelector("li.context-menu-item.context-menu-icon.context-menu-icon-edit") ;

        Actions builder = new Actions (driver) ;
        builder.contextClick(btnRClick).moveToElement(editClick).click().perform();

        WebDriverWait Ewait = new WebDriverWait(driver, 30) ;

        Alert alert = Ewait.until(ExpectedConditions.alertIsPresent()) ;
        alert.dismiss();

    }


}
