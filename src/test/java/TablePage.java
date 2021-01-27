import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TablePage {

    ChromeDriver driver ;

    @BeforeTest
    public void openURL() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver() ;
        driver.navigate().to("https://the-internet.herokuapp.com/tables");

    }

    @Test
    public void webTable() {

        WebElement table = driver.findElement(By.id("table1")) ;
        // get all the rows
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (WebElement row: rows ) {
            List<WebElement> cols = row.findElements(By.tagName("td")) ;
            for (WebElement col : cols) {
                System.out.println(col.getText());
            }
        }
    }


//    @AfterTest
//    public void closeDriver() {
//        driver.close();
//    }

}
