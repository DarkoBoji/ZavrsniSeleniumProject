package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PowerToolsPage;
import pages.RegisterPage;


public class PowerToolsTest extends BaseTest{


    RegisterPage registerPage;
    PowerToolsPage powerToolsPage;

    @BeforeMethod
    public void localSetup() {

        registerPage = new RegisterPage(driver);
        powerToolsPage = new PowerToolsPage(driver);

    }

    @Test()
    public void checkBox() {
        registerPage.goToRegisterPage()
                .registerUser()
                .goToLoginForm()
                .loginUser(registerPage.getUsername(), registerPage.getPassword());
        powerToolsPage.PowerTools();
        Assert.assertTrue(powerToolsPage.listsVary());




    }

}
