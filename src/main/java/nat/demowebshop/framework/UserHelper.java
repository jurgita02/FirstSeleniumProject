package nat.demowebshop.framework;

import nat.demowebshop.models.NewUser;
import nat.demowebshop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegisterLink() {
        click(By.xpath("//a[text()='Register']"));
    }

    public void clickOnLogOutButton() {
        click(By.xpath("//a[text()='Log out']"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//a[text()='Log in']"));
    }

    public void clickOnRegistrationButton() {
        click(By.cssSelector("#register-button"));
    }

    public void fillLoginRegistrationForm(User user) {
        type(By.cssSelector("#Email"), user.getEmail());
        type(By.cssSelector("#Password"), user.getPassword());
    }

    public void fillNewUserForm(NewUser newUser) {
        type(By.cssSelector("#FirstName"), newUser.getName());
        type(By.cssSelector("#LastName"), newUser.getSurname());
        type(By.cssSelector("#Email"), newUser.getEmail());
        type(By.cssSelector("#Password"), newUser.getPassword());
        type(By.cssSelector("#ConfirmPassword"), newUser.getRepeat_password());
    }



    public boolean isLogOutButtonPresent() {
        return isElementPresent(By.cssSelector(".ico-logout"));
    }

    public void clickOnLoginButton() {
        click(By.xpath("//a[text()='Log in']"));
    }

    public void login() {
        clickOnLoginButton();
        fillLoginRegistrationForm(new User().setEmail("jurgita@gmail.com").setPassword("Qwerty123456$"));
        clickLoginButton2();
    }
    public void loginWithScreencast() {
        clickOnLoginButton();
        pause(500);
        fillLoginRegistrationForm(new User().setEmail("jurgita@gmail.com").setPassword("Qwerty123456$"));
        pause(1000);
        clickLoginButton2();
    }
    public void clickLoginButton2() {
        click(By.cssSelector(".button-1.login-button"));
    }


}
