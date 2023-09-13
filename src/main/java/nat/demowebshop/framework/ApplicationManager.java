package nat.demowebshop.framework;

import nat.demowebshop.framework.AddProductInCartHelper;
import nat.demowebshop.framework.HomepageHelper;
import nat.demowebshop.framework.UserHelper;
import nat.demowebshop.models.NewUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    String browser;
    WebDriver driver;

    UserHelper user;
    HomepageHelper homePage;
    AddProductInCartHelper addProductInCartHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        System.err.close(); //закрывает в консоли системную инф-цию

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("microsoftedge")) {
            driver = new EdgeDriver();
        }

        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        user = new UserHelper(driver);
        homePage = new HomepageHelper(driver);
        addProductInCartHelper = new AddProductInCartHelper(driver);
    }

    public UserHelper getUser() {
        return user;
    }

    public HomepageHelper getHomePage() {
        return homePage;
    }

    public AddProductInCartHelper getAddProductInCartHelper() {
        return addProductInCartHelper;
    }

    public void stop() {
        driver.quit();
    }

}