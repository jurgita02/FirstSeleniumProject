package org.ait.webshop.qa25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class FindElementsHomework {
      WebDriver driver;

        @BeforeMethod
        public void setUp() {
            driver = new ChromeDriver();
            driver.get("https://demowebshop.tricentis.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        @Test
        public void findElementByCssTest() {
           driver.findElement(By.cssSelector("#dialog-notifications-error"));
           driver.findElement(By.cssSelector(".master-wrapper-page"));
           driver.findElement(By.cssSelector(".ico-register"));
           driver.findElement(By.cssSelector(".close"));
           driver.findElement(By.cssSelector(".search-box-text.ui-autocomplete-input"));
           driver.findElement(By.cssSelector("[class*='flyout']"));
           driver.findElement(By.cssSelector("[class^='mini']"));
           driver.findElement(By.cssSelector("[class^='bar']"));
           driver.findElement(By.cssSelector("[class$='accessible']"));
           driver.findElement(By.cssSelector("[name='q']"));
        }

        @Test
        public void findElementXpathTest() {
            driver.findElement(By.xpath("//div[@id='dialog-notifications-error']"));
            driver.findElement(By.xpath("//div[@class='master-wrapper-page']"));
            driver.findElement(By.xpath("//a[@class='ico-register']"));
            driver.findElement(By.xpath("//span[@class='close']"));

            //без чата GPT я бы не написала стр.47-53
            driver.findElement(By.xpath("//input[contains(@class, 'search-box-text') and contains(@class, 'ui-autocomplete-input')]"));
            driver.findElement(By.xpath("//div[contains(@class, 'flyout')]"));
            driver.findElement(By.xpath("//div[starts-with(@class, 'mini')]"));
            driver.findElement(By.xpath("//div[starts-with(@class, 'bar')]"));
            driver.findElement(By.xpath("//span[substring(@class, string-length(@class) - string-length('accessible') + 1) = 'accessible']"));
            driver.findElement(By.xpath("//input[@name='q']"));
        }

        //after - tearDown
        @AfterMethod
        public void tearDown() {
            driver.quit();
        }
    }

