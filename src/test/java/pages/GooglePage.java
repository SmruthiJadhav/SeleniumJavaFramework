package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class GooglePage {
    private WebDriver driver;
    private WaitUtils waitUtils;
    // Locators
    private By searchBox = By.name("q");
    private By searchBtn = By.name("btnK");

    //Constructor
    public GooglePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    //Actions
    public void search(String searchText) {
        waitUtils.waitForElementVisibility(searchBox);
        driver.findElement(searchBox).sendKeys(searchText);
    }

    public void clickSearch() {
        waitUtils.waitForElementClickable(searchBtn);
        driver.findElement(searchBtn).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
