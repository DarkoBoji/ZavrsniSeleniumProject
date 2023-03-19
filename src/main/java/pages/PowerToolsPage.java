package pages;

import com.beust.ah.A;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Utils;

import java.util.Collections;
import java.util.List;

public class PowerToolsPage extends BasePage {

    private By categoriesButton = By.cssSelector("a[data-test='nav-categories']");
    private By powerToolsButton = By.cssSelector("a[data-test='nav-power-tools']");
    private By fullList = By.xpath("//a[@class='card']");
    private By checkBoxDrill = By.xpath("//input[@data-test='category-11']");
    private By drillList = By.xpath("//a[@style='text-decoration: none; color: black;']");


    public PowerToolsPage(WebDriver driver) {
        super(driver);
    }

    public void powerToolsCheck() {
        clickOnElement(categoriesButton);
        Utils.waitForSeconds(2);
        clickOnElement(powerToolsButton);
        listOfAllItems();
        clickOnElement(checkBoxDrill);
        Utils.waitForSeconds(2);
        listOfDrills();

    }

    private PowerToolsPage listOfAllItems() {
        List<WebElement> listOfElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(fullList));
        for (int i = 0; i < listOfElements.size(); i++) {
            System.out.println(listOfElements.get(i).getText());


        }


        return this;
    }

    private PowerToolsPage listOfDrills() {
        List<WebElement> listOfElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(drillList));
        for (int i = 0; i < listOfElements.size(); i++) {
            System.out.println(listOfElements.get(i).getText());
        }

        return this;
    }


    public boolean listsVary() {
        if (!listOfAllItems().equals(listOfDrills())){
        return true;
        }
        return true;
    }

}