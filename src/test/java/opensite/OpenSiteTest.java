package opensite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenSiteTest {
    WebDriver driver; //объявили переменную driver

    //before - setUp
    @BeforeMethod
      public void setUp(){
        driver = new ChromeDriver();
        // driver.get("https://www.google.com/"); // без истории
        driver.navigate().to("https://www.google.com/"); //с историей
        driver.navigate().back(); //возвращает на шаг назад
        driver.navigate().forward(); //на шаг вперед, идем опять в гугл
        driver.navigate().refresh(); // обновляем
}

    //tests
    @Test
    public void openGoogleTest() {
        System.out.println("Site opened!");
    }

    //after - tearDown
    @AfterMethod
    public void tearDown() {
        // driver.quit(); //закрывает все вкладки, весь браузер
        driver.close(); //закрывает только одну вкладку
    }
}
