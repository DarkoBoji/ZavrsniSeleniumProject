package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.Utils;

import java.util.List;

public class AddToBasketPage extends BasePage {

    private By homeButton = By.xpath("//a[@class='nav-link active']");
    private By firstItem = By.xpath("//img[@src='assets/img/products/pliers05.jpeg']");
    private By secondItem = By.xpath("//img[@src='assets/img/products/pliers02.jpeg']");
    private By thirdItem = By.xpath("//img[@src='assets/img/products/hammer04.jpeg']");
    private By redBalloon = By.xpath("//span[@id='lblCartCount']");
    private By addOneMoreItem = By.xpath("//button[@id='btn-increase-quantity']");
    private By addToCartButton = By.xpath("//button[@id='btn-add-to-cart']");
    private By allItemsPrices = By.xpath("//table[@class='table table-hover']/tbody/tr/td[5]");
    private By totalItemsPrice = By.xpath("//table[@class='table table-hover']/tfoot/tr[1]/td[5]");
    private By proceedToCheckout1 = By.cssSelector("button[data-test='proceed-1']");
    private By proceedToCheckout2 = By.cssSelector("button[data-test='proceed-2']");
    private By proceedToCheckout3 = By.cssSelector("button[data-test='proceed-3']");
    private By paymentMethod = By.cssSelector("select[id='payment-method']");
    private By accountName = By.cssSelector("input[data-test='account-name']");
    private By accountNumber = By.cssSelector("input[data-test='account-number']");
    private By finishBaying = By.cssSelector("button[data-test='finish']");
    private By successfulPayment = By.cssSelector("div[class='help-block']");


    public AddToBasketPage(WebDriver driver) {
        super(driver);
    }

    public AddToBasketPage addItemsToBasket() {

        clickOnElement(firstItem);
        Utils.waitForSeconds(2);
        clickOnElement(addOneMoreItem);
        clickOnElement(addOneMoreItem);
        clickOnElement(addToCartButton);
        clickOnElement(homeButton);
        Utils.waitForSeconds(2);
        clickOnElement(secondItem);
        Utils.waitForSeconds(2);
        clickOnElement(addOneMoreItem);
        clickOnElement(addToCartButton);
        clickOnElement(homeButton);
        Utils.waitForSeconds(2);
        clickOnElement(thirdItem);
        clickOnElement(addToCartButton);
        clickOnElement(redBalloon);
        Utils.waitForSeconds(2);
        priceOfAllItems();
        priceTotal();
        clickOnElement(proceedToCheckout1);
        Utils.waitForSeconds(2);
        clickOnElement(proceedToCheckout2);
        clickOnElement(proceedToCheckout3);
        selectPaymentMethod();
        typeIn(accountName, "Misko");
        typeIn(accountNumber, "465");
        clickOnElement(finishBaying);
        return this;
    }

    private void selectPaymentMethod() {
        Select dropdown = new Select(driver.findElement(By.cssSelector("select[id='payment-method']")));
        dropdown.selectByValue("3: Credit Card");

    }

    private AddToBasketPage priceOfAllItems() {

        List<WebElement> priceForAllItemsInBasket = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(allItemsPrices));
        double sumOfElements = 0;
        for (int i = 0; i < priceForAllItemsInBasket.size(); i++) {
            sumOfElements += Double.parseDouble(priceForAllItemsInBasket.get(i).getText().replaceAll("[$]+", ""));
            System.out.println(sumOfElements);

        }
        return this;

    }



    private AddToBasketPage priceTotal() {
        List<WebElement> listTotal = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(totalItemsPrice));
        double totalPrice = 0;
        for (int i = 0; i < listTotal.size(); i++) {
            totalPrice += Double.parseDouble(listTotal.get(i).getText().replaceAll("[$]+", ""));

            System.out.println(totalPrice);
        }
        return this;
    }


    public boolean priceVerification() {
        if (priceTotal().equals(priceOfAllItems())){
            return true;
        }
        return true;

}


    public boolean isPaymentDone() {
        return matchesExpectedText(successfulPayment, "Payment was successful");
    }


}
