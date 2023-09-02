package org.nat.demowebshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class AddProductInCartTest extends TestBase1 {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.xpath("//a[text()='Log in']"))) {
            driver.findElement(By.xpath("//a[text()='Log out']")).click();
        }
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
        driver.findElement(By.cssSelector("#Email")).click();
        driver.findElement(By.cssSelector("#Email")).clear();
        driver.findElement(By.cssSelector("#Email")).sendKeys("n010@gmail.com");

        //enter password -  [placeholder='Password']  -css
        driver.findElement(By.cssSelector("#Password")).click();
        driver.findElement(By.cssSelector("#Password")).clear();
        driver.findElement(By.cssSelector("#Password")).sendKeys("Pnata2023!");

        driver.findElement(By.cssSelector(".button-1.login-button")).click();

     /* Проверяем пустоту корзины. Сколько переменная card содержит элементов в корзине:
        String cart = driver.findElement(By.cssSelector(".cart-qty")).getText();
        System.out.println(cart);

      */
    }

    @Test
    public void AddProductPositiveTest() {

        //Создали переменную product, который добавляем в корзину
        String product = driver.findElement(By.xpath("//a[text()='14.1-inch Laptop']")).getText();

        //захватили свой продукт и кликнули на него
        driver.findElement(By.xpath("//a[text()='14.1-inch Laptop']")).click();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //кликнули Add to cart
        driver.findElement(By.cssSelector("#add-to-cart-button-31")).click();
        //кликаем корзину:
        driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();


         // driver.findElement(By.xpath("//td//a[text()='14.1-inch Laptop']"));
        //driver.findElement(By.xpath("//td//product"));
        Assert.assertTrue(isProductAdded("14.1-inch Laptop"));

        //кликнули Add to cart  тестируемый продукт:
        //driver.findElement(By.xpath("(//input[@type='button'])[5]")).click();

    }
    @AfterMethod

    public void postCondition(){
        driver.findElement(By.xpath("//input[@name='removefromcart']")).click();
        driver.findElement(By.xpath("//input[@name='updatecart']")).click();


    }

    public boolean isProductAdded(String text) {
        List<WebElement> products = driver.findElements(By.xpath("//tr[@class='cart-item-row']"));
        for (WebElement el : products) {
            if (el.getText().contains(text))
                return true;
        }
        return false;
    }
}
