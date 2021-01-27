import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavascriptCodeHandling {

    ChromeDriver driver ;

    @BeforeTest
    public void openURL() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver() ;
        driver.navigate().to("http://www.google.com");
    }

    @Test
    public void testJSScript() {
        // assert the title using JS
        JavascriptExecutor js = (JavascriptExecutor) driver ;
        String  title = (String) js.executeScript("return document.title") ;
        System.out.println(title);
        Assert.assertEquals("Google", title);
        // assert the number of href
        long links = (long) js.executeScript("var links=document.getElementsByTagName('A'); return links.length ");
        System.out.println(links);

    }

}
