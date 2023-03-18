package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegisterPage;
import pages.WishListPage;

public class WishListTest extends BaseTest{

    RegisterPage registerPage;
    WishListPage wishListPage;

    @BeforeMethod
    public void localSetup() {

        registerPage = new RegisterPage(driver);
        wishListPage = new WishListPage(driver);

    }

    @Test()
    public void checkWishList() {
        registerPage.goToRegisterPage()
                .registerUser()
                .goToLoginForm()
                .loginUser(registerPage.getUsername(), registerPage.getPassword());
        wishListPage.addToWishList();
        Assert.assertTrue(wishListPage.nameMach());
    }


}
