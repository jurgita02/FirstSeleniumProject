package org.nat.demowebshop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase1 {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.xpath("//a[text()='Log in']"))) {
            driver.findElement(By.xpath("//a[text()='Log out']")).click();
        }
    }
        @Test
        public void UserLoginPositiveTest() {
            driver.findElement(By.xpath("//a[text()='Log in']")).click();
            driver.findElement(By.cssSelector("#Email")).click();
            driver.findElement(By.cssSelector("#Email")).clear();
            driver.findElement(By.cssSelector("#Email")).sendKeys("n010@gmail.com");

            //enter password -  [placeholder='Password']  -css
            driver.findElement(By.cssSelector("#Password")).click();
            driver.findElement(By.cssSelector("#Password")).clear();
            driver.findElement(By.cssSelector("#Password")).sendKeys("Pnata2023!");

            driver.findElement(By.cssSelector(".button-1.login-button")).click();
            Assert.assertTrue(isElementPresent(By.cssSelector(".ico-logout")));
        }
        @AfterMethod
                public void LogOutAfterTest(){
                driver.findElement(By.xpath("//a[text()='Log out']")).click();
        }
    }

