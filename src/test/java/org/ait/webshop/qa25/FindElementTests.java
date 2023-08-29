package org.ait.webshop.qa25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElementTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");
        //! разворачиваем окно браузера:
        driver.manage().window().maximize();
        //! неявное ожидание: время подтягивания всех картинок на сайте
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //tests
    @Test
    public void findElementTest() {
        //находим элемент по тэгу:
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());
        //находим лист элементов
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());
        //поиск элементов по id:
        driver.findElement((By.id("city")));
       driver.findElement(By.className("input-label"));
       driver.findElement((By.name("viewport")));
//поиск по linkTest:
       driver.findElement(By.linkText("Let the car work"));
       //поиск по частичному совпадению - partialLinkText:
       driver.findElement(By.partialLinkText("work"));
    }

    @Test
    public void findElementByCssTest() {
        //преобразуем css  в тэг: css=tag
        // driver.findElement(By.tagName("h1"));
        driver.findElement((By.cssSelector("h1")));
        //driver.findElement((By.id("city")));
        driver.findElement(By.cssSelector("#city"));

        //driver.findElement(By.className("input-label"));
        driver.findElement(By.cssSelector(".input-label"));

        //driver.findElement((By.name("viewport")));
        driver.findElement(By.cssSelector("[name='viewport']"));
        //css - contains (*)
        driver.findElement(By.cssSelector("[class*='pristine']"));
        driver.findElement(By.cssSelector("[class^='ng']"));
        driver.findElement(By.cssSelector("[class$='input']"));
    }
    @Test
    public void findElementXpathTest() {
        // //*[@attr='par']
        //tag -> xpath // т.е. поиск элемента через путь
        // driver.findElement(By.tagName("h1"));
         driver.findElement(By.xpath("//h1"));

         //driver.findElement((By.id("city")));
        //id->xpath
        //driver.findElement((By.id("city")));
        driver.findElement(By.xpath("//input[@id='city']"));

        //classname ->xpath
        //driver.findElement(By.className("input-label"));
        driver.findElement(By.xpath("//label[@class='input-label']"));

        //text -> xpath //*{contains(.,'text')]
        driver.findElement(By.xpath("//h2[contains(.,'Type your data and hit Yalla!')]"));

        //start -> //*[starts-with(@attr,'text')]



    }

    //after - tearDown
    @AfterMethod
    public void tearDown() {
driver.quit();
    }
}
