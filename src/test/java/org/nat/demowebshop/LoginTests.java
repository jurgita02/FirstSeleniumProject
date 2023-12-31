package org.nat.demowebshop;

import nat.demowebshop.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

//test for check login
public class LoginTests extends TestBase1 {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnLogOutButton();
        }
    }

    @Test
    public void UserLoginPositiveTest() {
        app.getUser().login();
        Assert.assertTrue(app.getUser().isLogOutButtonPresent());
    }

    @Test
    public void UserLoginNegativeWithoutEmailTest() {
        app.getUser().clickOnLoginButton();
        app.getUser().fillLoginRegistrationForm(new User().setPassword("Qwerty123456$"));
        app.getUser().clickLoginButton2();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//li[text()='No customer account found']")));
    }

    @Test
    public void UserLoginPositiveTestWithScreencast() throws IOException, AWTException {
        app.getUser().deleteScreencast();
        app.getUser().startRecording();
        app.getUser().loginWithScreencast();
        Assert.assertTrue(app.getUser().isLogOutButtonPresent());

        app.getUser().pause(2000);

        app.getUser().stopRecording();


    }
}