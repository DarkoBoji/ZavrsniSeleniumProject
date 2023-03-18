package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddToBasketPage;
import pages.RegisterPage;

public class AddToBasketTest extends BaseTest {

    RegisterPage registerPage;
    AddToBasketPage addToBasketPage;


    @BeforeMethod
    public void localSetup() {

        registerPage = new RegisterPage(driver);
        addToBasketPage = new AddToBasketPage(driver);

    }


    @Test()
    public void loginUserTest02() {
        registerPage.goToRegisterPage()
                .registerUser()
                .goToLoginForm()
                .loginUser(registerPage.getUsername(), registerPage.getPassword());
        addToBasketPage.addItemsToBasket();
        Assert.assertTrue(addToBasketPage.priceVerification());
        Assert.assertTrue(addToBasketPage.isPaymentDone());


    }


}
