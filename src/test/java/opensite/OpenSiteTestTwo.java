package opensite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenSiteTestTwo {
    WebDriver driver;

     @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();

        driver.navigate().to("https://demowebshop.tricentis.com/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }

    @Test
    public void openGoogleTest() {
        System.out.println("Site opened!");
    }


    @AfterMethod
    public void tearDown() {

         driver.close();
    }
}
