package org.nat.demowebshop;
        import org.openqa.selenium.By;
        import org.testng.Assert;
        import org.testng.annotations.Test;

//проверяем открывается ли сайт путем поиска на странице элемента
public class HomepageTests1 extends TestBase1 {

    @Test
    public void isHomeComponentPresentTest() {
        //driver.findElement(By.xpath("//h1[text()='Home Component']"));
        //или так //div[2]/div/div
        //System.out.println("Home component is " + isHomeComponentPresent());
        System.out.println("Home component is " + isElementPresent(By.cssSelector("#nivo-slider")));

        //метод сравнения реального и ожидаемого результата: !!!это уже тест!!!
        Assert.assertTrue(isHomeComponentPresent());

    }

}
