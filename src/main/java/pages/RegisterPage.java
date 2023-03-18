package pages;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utils.Utils;

import java.util.Locale;

public class RegisterPage extends BasePage{

    private By signInLink = By.cssSelector("a[data-test='nav-sign-in']");
    private By goToRegisterFormLink = By.cssSelector("a[data-test='register-link']");
    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By dobField = By.cssSelector("input[id='dob']");
    private By addressField = By.id("address");
    private By postField = By.id("postcode");
    private By cityField = By.id("city");
    private By stateField = By.id("state");
    private By countryDropdown = By.id("country");
    private By phoneField = By.id("phone");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By registerButton = By.cssSelector(".form-group.mb-3+button");
    private By emailFieldLogin = By.cssSelector("input[data-test='email']");
    private By passwordFieldLogin = By.id("password");
    private By loginButton = By.cssSelector("input[data-test='login-submit']");
    private By homeButton = By.xpath("//a[@class='nav-link active']");

    private String username;
    private String password;

    private static final Logger log = LogManager.getLogger(RegisterPage.class.getName());

    Faker faker = new Faker(new Locale("en-US"));

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public  RegisterPage goToRegisterPage(){
        clickOnElement(signInLink);
        clickOnElement(goToRegisterFormLink);
        return this;
    }

    public RegisterPage registerUser(){

        username = faker.internet().emailAddress();
        password = faker.internet().password();
        log.info("EmailForLogin: " + username);
        log.info("Password: " + password);

        typeIn(firstNameField, faker.name().firstName());
        typeIn(lastNameField, faker.name().lastName());
        Actions actions = new Actions(driver);
        actions.sendKeys(getElement(dobField),"12121999").build().perform();
        typeIn(addressField, faker.address().fullAddress());
        typeIn(postField, faker.number().digits(6));
        typeIn(cityField, faker.address().city());
        typeIn(stateField, faker.address().state());
        selectCountry();
        typeIn(phoneField, faker.number().digits(10));
        typeIn(emailField, username);
        typeIn(passwordField, password);
        clickOnElement(registerButton);
        Utils.waitForSeconds(2);
        clickOnElement(homeButton);
        Utils.waitForSeconds(2);
        return this;
    }


    private void selectCountry(){
        Select select = new Select(getElement(countryDropdown));
        select.selectByValue("RS");
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public RegisterPage goToLoginForm(){
        clickOnElement(signInLink);
        return this;
    }

    public RegisterPage loginUser(String username, String password){
        typeIn(emailFieldLogin, username);
        typeIn(passwordFieldLogin, password);
        clickOnElement(loginButton);
        Utils.waitForSeconds(2);
        clickOnElement(homeButton);
        return this;
    }



}
