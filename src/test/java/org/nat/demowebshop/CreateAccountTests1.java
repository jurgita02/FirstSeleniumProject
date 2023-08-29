package org.nat.demowebshop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

    //проверяем регистрацию на сайте
    public class CreateAccountTests1 extends TestBase1 {
        //предусловие на проверку не залогинен ли пользователь
        //precondition: user should be logged out
        @BeforeMethod
        public void ensurePrecondition() {
            //пишем всегда предусловие:
            //убеждаемся, что наш пользователь разлогинен:
            if (!isElementPresent(By.xpath("//a[text()='Log in']"))){
                driver.findElement(By.xpath("//a[text()='Log out']")).click();
            }

            //click on login link -   a:nth-child(4)  - css
            //если пользователь не залогинен, то логиним его, кликнув на кнопку LOGIN:
            driver.findElement(By.xpath("//a[text()='Register']")).click();
        }

        @Test
        public void newUserRegistrationPositiveTest () {
            //enter email  -  [placeholder='Email']  -css
            //алгоритм: кликаем поле, очищаем его, вводим

            driver.findElement(By.xpath("//label[text()='Female']")).click();
           // driver.findElement(By.xpath("//label[text()='Male']")).click();
            driver.findElement(By.cssSelector("#FirstName")).click();
            driver.findElement(By.cssSelector("#FirstName")).clear();
            driver.findElement(By.cssSelector("#FirstName")).sendKeys("Nat");

            driver.findElement(By.cssSelector("#LastName")).click();
            driver.findElement(By.cssSelector("#LastName")).clear();
            driver.findElement(By.cssSelector("#LastName")).sendKeys("Poh");

            driver.findElement(By.cssSelector("#Email")).click();
            driver.findElement(By.cssSelector("#Email")).clear();
            driver.findElement(By.cssSelector("#Email")).sendKeys("n010@gmail.com");

            //enter password -  [placeholder='Password']  -css
            driver.findElement(By.cssSelector("#Password")).click();
            driver.findElement(By.cssSelector("#Password")).clear();
            driver.findElement(By.cssSelector("#Password")).sendKeys("Pnata2023!");

            driver.findElement(By.cssSelector("#ConfirmPassword")).click();
            driver.findElement(By.cssSelector("#ConfirmPassword")).clear();
            driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("Pnata2023!");



            //click on Registration button -  //button[text()='Registration']  -xpath
            driver.findElement(By.cssSelector("#register-button")).click();

            //assert Sign out button present  -  //button[contains(.,'Sign Out')]  -xpath
           Assert.assertTrue(isElementPresent2(By.xpath("//a[text()='Log out']")));
        }
    }
