package tests;

import listeners.TestListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.RegisterPage;
@Listeners(TestListener.class)
public class RegisterTest extends BaseTest {

    RegisterPage registerPage;

    @BeforeMethod
    public void localSetup() {
        registerPage = new RegisterPage(driver);
    }

    @Test
    public void registerUserTest() {
            registerPage.goToRegisterPage()
                    .registerUser()
                    .goToLoginForm()
                    .loginUser(registerPage.getUsername(), registerPage.getPassword());
        }
}
