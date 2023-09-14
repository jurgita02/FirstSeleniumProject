package org.nat.demowebshop;

import nat.demowebshop.models.NewUser;
import nat.demowebshop.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.DataProviders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTests1 extends TestBase1 {
         @BeforeMethod
        public void ensurePrecondition() {
            if (!app.getUser().isLoginLinkPresent()){
                app.getUser().clickOnLogOutButton();
            }
             app.getUser().clickOnRegisterLink();
         }
           @Test
        public void existedUserRegistrationNegativeTest () {
            app.getUser().click(By.xpath("//label[text()='Female']"));

            app.getUser().type(By.cssSelector("#FirstName"), "Nat");
            app.getUser().type(By.cssSelector("#LastName"), "Poh");
               app.getUser().fillLoginRegistrationForm(new User().setEmail("n010@gmail.com").setPassword("Pnata2023!"));
               app.getUser().type(By.cssSelector("#ConfirmPassword"), "Pnata2023!");
               app.getUser().clickOnRegistrationButton();
               Assert.assertTrue(app.getUser().isAlertPresent());
        }

    @Test(dataProvider="newUserRegistrationWithCSVFile", dataProviderClass= DataProviders.class)
    public void addNewUserPositiveTestFromDataProviderWithCSV(NewUser newUser){
       app.getUser().click(By.xpath("//label[text()='Female']"));

        app.getUser().fillNewUserForm(newUser);
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isLogOutButtonPresent());
    }
    }



