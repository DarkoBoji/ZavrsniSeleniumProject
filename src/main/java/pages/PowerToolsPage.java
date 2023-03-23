package pages;

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

    private int toolsOnPageOne;
    private int toolsOnPageTwo;

    public PowerToolsPage(WebDriver driver) {
        super(driver);
    }

    public PowerToolsPage PowerTools() {

        clickOnElement(categoriesButton);
        wait.until(ExpectedConditions.elementToBeClickable(powerToolsButton));
        clickOnElement(powerToolsButton);
        listOfAllItems();
        clickOnElement(checkBoxDrill);
        Utils.waitForSeconds(1);
        listOfDrills();

        return this;
    }


    public int listOfAllItems() {
        List<WebElement> listOfElementsOne = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(fullList));
        int numberOfTools;
        numberOfTools = listOfElementsOne.size();
        listOfElementsOne.size();
        System.out.println(numberOfTools);
        return toolsOnPageOne = numberOfTools;
    }

    public int listOfDrills() {
        List<WebElement> listOfElementsTwo = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(drillList));
        int numberOfDrills;
        numberOfDrills = listOfElementsTwo.size();
        System.out.println(numberOfDrills);
        return toolsOnPageTwo = numberOfDrills;

    }


    public boolean listsVary() {
       if (toolsOnPageOne > toolsOnPageTwo){
           System.out.println("Lista dva je smanjena u čekiranju");
       }else System.out.println("Nije smanjen broj alata na listi");

        return true;

    }

}