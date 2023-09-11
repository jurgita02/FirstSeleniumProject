package nat.demowebshop.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomepageHelper extends HelperBase{
    public HomepageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeComponentPresent() {
        return driver.findElements(By.cssSelector("#nivo-slider")).size()>0;
    }

    public void clickOnHomeLink() {
        click(By.cssSelector(".header-logo"));
    }
}
