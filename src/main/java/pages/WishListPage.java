package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utils;

public class WishListPage extends BasePage{

    private By thorHammer = By.xpath("//img[@src='assets/img/products/hammer04.jpeg']");
    private By addToFavorites = By.xpath("//button[@id='btn-add-to-favorites']");
    private By userMenuButton = By.cssSelector("a[id='user-menu']");
    private By myFavorites = By.cssSelector("a[data-test='nav-my-favorites']");
    private By itemName = By.xpath("//h5[@class]");

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    public WishListPage addToWishList(){
        clickOnElement(thorHammer);
        Utils.waitForSeconds(2);
        clickOnElement(addToFavorites);
        Utils.waitForSeconds(2);
        clickOnElement(userMenuButton);
        Utils.waitForSeconds(2);
        clickOnElement(myFavorites);

        return this;
    }

    public boolean nameMach() {
        return matchesExpectedText(itemName, "Thor Hammer");
    }


}
