package org.nat.demowebshop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//test for check add product in cart
public class AddProductInCartTest extends TestBase1 {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnLogOutButton();
        }
        app.getUser().login();
    }

    @Test
    public void AddProductPositiveTest() {
        //захватили свой продукт и кликнули на него //a[text()='14.1-inch Laptop']
        app.getAddProductInCartHelper().click(By.xpath("//img[@alt='Picture of 14.1-inch Laptop' and @src='https://demowebshop.tricentis.com/content/images/thumbs/0000224_141-inch-laptop_125.png']"));
        //кликнули Add to cart
        app.getAddProductInCartHelper().click(By.cssSelector("#add-to-cart-button-31"));
        //кликаем корзину:
        app.getAddProductInCartHelper().click(By.xpath("//span[text()='Shopping cart']"));
        //"14.1-inch Laptop"
        Assert.assertTrue(app.getAddProductInCartHelper().isProductAdded("14.1-inch Laptop"));
    }
    @AfterMethod
    public void postCondition(){
        app.getAddProductInCartHelper().updateCart();
    }
}
