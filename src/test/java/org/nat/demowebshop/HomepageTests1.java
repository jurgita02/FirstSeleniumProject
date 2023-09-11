package org.nat.demowebshop;
        import org.testng.Assert;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;

//проверяем открывается ли сайт путем поиска на странице элемента
public class HomepageTests1 extends TestBase1 {
@BeforeMethod
public void ensurePrecondition(){
    if(!app.getHomePage().isHomeComponentPresent()){
        app.getHomePage().clickOnHomeLink();
    }
}
@Test
    public void isHomeComponentPresentTest() {

        Assert.assertTrue(app.getHomePage().isHomeComponentPresent());

    }

}
