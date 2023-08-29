package org.nat.demowebshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase1 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public boolean isHomeComponentPresent() {
        return driver.findElements(By.cssSelector("#nivo-slider")).size()>0;
    }

    //универсальный метод поиска одного элемента из списка:
    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size()>0;
    }

    //универсальный метод поиска одного элемента:
    public boolean isElementPresent2(By locator) {
        try {
            driver.findElement(locator);
            return true;
        }catch (NoSuchElementException ex) {
            return false;
        }
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }
}
