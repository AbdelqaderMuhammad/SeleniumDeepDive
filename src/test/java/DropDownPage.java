import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;


public class DropDownPage {

    ChromeDriver driver ;

    @BeforeTest
    public void openURL() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver() ;
        driver.navigate().to("http://the-internet.herokuapp.com/dropdown");

    }

    @Test
    public void selectDropDown() {
        // find the web element for the drop down.
        WebElement optionList = driver.findElement(By.id("dropdown")) ;

        Select selectOptions = new Select(optionList) ;
        // verify the selection options.
        Assert.assertFalse(selectOptions.isMultiple());
        Assert.assertEquals( 3, selectOptions.getOptions().size() );
        // selecting the option
//        selectOptions.selectByVisibleText("Option 1");
//        selectOptions.selectByIndex(2);
          selectOptions.selectByValue("1");

        Assert.assertEquals("Option 1", selectOptions.getFirstSelectedOption().getText());

    }


//    @AfterTest
//    public void closeDriver() {
//        driver.close();
//    }

}
