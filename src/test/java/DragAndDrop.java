import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDrop {

    ChromeDriver driver ;

    @BeforeTest
    public void openURL() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver() ;
        driver.navigate().to("http://cookbook.seleniumacademy.com/DragDropDemo.html");
    }

    @Test
    public void dragAndDropFunction() {

        WebElement source = driver.findElement(By.id("draggable")) ;
        WebElement target = driver.findElement(By.id("droppable")) ;

        Actions builder = new Actions(driver) ;

        builder.dragAndDrop(source, target).perform() ;
        // assert the text turns to dropped!
        Assert.assertEquals("Dropped!", target.getText());
    }

//    @AfterTest
//    public void closeDriver() {
//        driver.close();
//    }

}
