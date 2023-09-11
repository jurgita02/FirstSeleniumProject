package nat.demowebshop.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class HelperBase {
    WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver=driver;
    }

    //универсальный метод поиска одного элемента из списка:
    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size()>0;
    }

    //универсальный метод поиска одного элемента:
    public boolean isElementPresent2(By locator) {
        try {
            driver.findElement(locator);
            return true;
        }catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public boolean isAlertPresent(){
        String x = String.valueOf(driver.findElement(By.xpath("//li[text()='The specified email already exists']")));
         if (x == null){
            return false;
        }else {
            return true;
        }
    }
}
