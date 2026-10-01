package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.WaitUtils;


public class LoginPage {
    private WebDriver driver;
    private WaitUtils waitUtils;

    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.xpath("//button[@type='submit']");
    private By flashMsg = By.xpath("//div[@id='flash-messages']//div");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void enterUsername(String usernameText) {
        waitUtils.waitForElementVisibility(username);
        //Actions actions = new Actions(driver);
        //actions.moveToElement(driver.findElement(username)).sendKeys("Smruthi").perform();
        //actions.dragAndDrop(driver.findElement(username), driver.findElement(password)).perform();
        driver.findElement(username).sendKeys(usernameText);
    }

    public void enterPassword(String passwordText) {
        waitUtils.waitForElementVisibility(password);
        driver.findElement(password).sendKeys(passwordText);
    }

    public void clickLogin() {
        waitUtils.waitForElementClickable(loginBtn);
        driver.findElement(loginBtn).click();
    }

    public String getFlashMessage() {
        waitUtils.waitForElementVisibility(flashMsg);
        return driver.findElement(flashMsg).getText();
    }
}
