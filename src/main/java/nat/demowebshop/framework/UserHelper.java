package nat.demowebshop.framework;

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

    public boolean isLogOutButtonPresent() {
        return isElementPresent(By.cssSelector(".ico-logout"));
    }

    public void clickOnLoginButton() {
        click(By.xpath("//a[text()='Log in']"));
    }

    public void login() {
        clickOnLoginButton();
        fillLoginRegistrationForm(new User().setEmail("n010@gmail.com").setPassword("Pnata2023!"));
        clickLoginButton2();
    }
    public void clickLoginButton2() {
        click(By.cssSelector(".button-1.login-button"));
    }
}
