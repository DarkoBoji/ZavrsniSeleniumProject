package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.NegativeLoginPage;
import utils.Utils;

public class NegativeLoginTest extends BaseTest {

    NegativeLoginPage negativeLoginPage;

    @BeforeMethod
    public void localSetup() {
        negativeLoginPage = new NegativeLoginPage(driver);
    }

    @DataProvider(name = "dpLoginTest")
    public static Object[][] dpLoginTest() {
        return new Object[][]{
                {"", ""},
                {"darko@emalil", ""},
                {"@email.com", ""},
                //ispravan email
                {"darko.proba@email.com", ""},
                {"", "123"},
                {"", "trend"},
                //ispravan password
                {"", "85SuperJakPassword!"},
                {"darko.proba@email.com", "123"},
                {"darko.proba@email.com", "trend"},
                {"darko@emalil", "85SuperJakPassword!"},
                {"@email.com", "85SuperJakPassword!"},
                {"darko@emalil", "123"},
                {"@email.com", "trend"},
        };
    }

    @Test(dataProvider = "dpLoginTest")
    public void loginUserWithDataTest(String username, String password) {
        negativeLoginPage.goToLoginForm();
        negativeLoginPage.loginUser(username, password);
        Assert.assertTrue(negativeLoginPage.presenceOfErrorMessages());

    }
}
