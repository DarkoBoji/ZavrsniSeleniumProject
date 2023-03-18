package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NegativeLoginPage extends BasePage{

    private By signInLink = By.cssSelector("a[data-test='nav-sign-in']");

    private By emailField = By.cssSelector("input[data-test='email']");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("input[data-test='login-submit']");

    private By errorEmailMessage1 = By.xpath("//div[text()=' E-mail is required. ']");
    private By errorEmailMessage2 = By.xpath("//div[text()=' E-mail format is invalid. ']");
    private By errorPasswordMessage1 = By.xpath("//div[text()=' Password is required. ']");
    private By errorPasswordMessage2 = By.xpath("//div[text()=' Password length is invalid ']");

    private By emailColor = By.xpath("//div[@data-test='email-error']");
    private By passwordColor = By.xpath("//div[@data-test='password-error']");


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


    public boolean presenceOfErrorMessages(){
        return matchesExpectedText(errorEmailMessage1, "E-mail is required.") ||
                matchesExpectedText(errorEmailMessage2, "E-mail format is invalid.") ||
                matchesExpectedText(errorPasswordMessage1,"Password is required.") ||
                matchesExpectedText(errorPasswordMessage2, "Password length is invalid");

    }


}
