package nat.demowebshop.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddProductInCartHelper extends HelperBase{
    public AddProductInCartHelper(WebDriver driver) {
        super(driver);
    }

    public void updateCart() {
        click(By.xpath("//input[@name='removefromcart']"));
        click(By.xpath("//input[@name='updatecart']"));
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
