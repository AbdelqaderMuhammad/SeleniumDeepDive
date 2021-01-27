import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NavigationCommands {

    ChromeDriver driver ;

    @BeforeTest
    public void openURL() {

        // set the property
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver() ;
        driver.navigate().to("https://the-internet.herokuapp.com/");
    }

    @Test
    public void testBrowserCommands() {
        driver.navigate().to("https://the-internet.herokuapp.com/login") ;
        driver.manage().window().maximize();
        driver.navigate().back();
    }

//    @AfterTest
//    public void closeDriver() {
//        driver.close();
//    }

}
