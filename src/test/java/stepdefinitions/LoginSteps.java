package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import utils.DriverManager;

public class LoginSteps {

    private LoginPage loginPage;

    @Given("I am on the login page")
    public void IAmOnTheLoginPage () {
        //loginPage = new LoginPage(Hooks.driver);
        loginPage = new LoginPage(DriverManager.getDriver());
    }

    @When("I enter valid username {string} and password {string}")
    public void IEnterValidUsernameAndPassword (String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("I click on login button")
    public void IClickOnLoginButton() {
        loginPage.clickLogin();
    }

    @Then("I should be logged in successfully with {string}")
    public void IShouldBeLoggedInSuccessfully(String expectedMessage) {
        String actualMessage = loginPage.getFlashMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage), "Expected message was not displayed. Actual message" + actualMessage);

    }
}
