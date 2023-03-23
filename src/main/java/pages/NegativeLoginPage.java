package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NegativeLoginPage extends BasePage{

    private By signInLink = By.cssSelector("a[data-test='nav-sign-in']");

    private By emailField = By.cssSelector("input[data-test='email']");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("input[data-test='login-submit']");


    public NegativeLoginPage(WebDriver driver) {
        super(driver);
    }

    public NegativeLoginPage goToLoginForm(){
        clickOnElement(signInLink);
        return this;
    }

    public NegativeLoginPage loginUser(String username, String password){
        typeIn(emailField, username);
        typeIn(passwordField, password);
        clickOnElement(loginButton);
        return this;
    }

}
