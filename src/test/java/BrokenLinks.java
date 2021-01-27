import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLinks {

    ChromeDriver driver ;

    @BeforeTest
    public void openURL() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver() ;
        driver.navigate().to("https://the-internet.herokuapp.com");

    }


    @Test
    public void testBrokenURL () {
        List<WebElement> urlLinks = driver.findElements(By.tagName("a")) ;
        for (int i = 0 ; i< urlLinks.size(); i++ ) {
            WebElement url = urlLinks.get(i);
            String urlLink = url.getAttribute("href") ;
            verifyURL(urlLink);
        }
    }

    public static void verifyURL (String urlLink) {

        try {
            URL url = new URL(urlLink) ;
            // build connection using url obj
            HttpURLConnection httpconn = (HttpURLConnection) url.openConnection();
            httpconn.setConnectTimeout(3000);
            httpconn.connect();
            // get the responces of the urls
            if (httpconn.getResponseCode() == 200)
                System.out.println(urlLink + " --" + httpconn.getResponseMessage());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }

    }




}
