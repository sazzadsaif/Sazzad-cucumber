package step_definition;

import command_providers.ActOn;
import command_providers.AssertThat;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReadConfigFiles;

import java.util.List;
import java.util.Map;

public class LoginSteps {
    private static final By FullName = By.id("name");
    private static final By Password = By.id("password");
    private static final By Login = By.id("login");
    private static final By Logout = By.id("logout");
    private static final By InvalidPassword = By.xpath("//div[text()='Password is invalid']");

    private static final Logger LOGGER = LogManager.getLogger(LoginSteps.class);
    WebDriver driver = Hooks.driver;


    @Given("^a user in on the login page$")
    public void navigateToLoginPage() {

        ActOn.browserActions(driver).openBrowser(ReadConfigFiles.getPropertyValues("TestAppURL"));


        LOGGER.info("user in on the login page");

    }

    @When("^user enters user name \"(.+?)\" and password \"(.+?)\"$")
    public void enterUserCredentials(String username,String password) {
        ActOn.elementActions(driver,FullName).setValue(username);
        ActOn.elementActions(driver,Password).setValue(password);
        LOGGER.info("user enters user name and password");
    }

    @And("^click on login button$")
    public void clickOnLoginButton() {
        ActOn.elementActions(driver,Login).click();
        LOGGER.info("User click on the login button");
    }

    @When("^user click on login button upon entering credentials$")
    public void userClickOnLoginUponEnteringCredentials(DataTable table){
        List<Map<String ,String>> data = table.asMaps(String.class,String.class);
        for(Map<String ,String > cells: data){
            ActOn.elementActions(driver,FullName).setValue(cells.get("username"));
            ActOn.elementActions(driver,Password).setValue(cells.get("password"));
            LOGGER.info("user has entered credentials");

            ActOn.elementActions(driver,Login).click();
            LOGGER.info("User click on the login button");
        }
    }

    @Then("^user is navigated to home page$")
    public void validateUserLoggedInSuccessful() {
        AssertThat.elementAssertions(driver,Logout).elementIsDisplayed();

        LOGGER.info("User is on the home page");

    }
    @Then("^user is failed to login$")
    public void validateUserIsFailedToLogin(){

        AssertThat.elementAssertions(driver,InvalidPassword).elementIsDisplayed();
        LOGGER.info("User is still on the login page");


    }

}
