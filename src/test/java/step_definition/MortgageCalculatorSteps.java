package step_definition;

import command_providers.ActOn;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.Home;
import page_objects.RealApr;
import utilities.ReadConfigFiles;

import java.util.List;
import java.util.Map;

public class MortgageCalculatorSteps {

    private static final Logger LOGGER = LogManager.getLogger(MortgageCalculatorSteps.class);
    WebDriver driver = Hooks.driver;

    @Given("^user is in mortgage calculator home page$")
    public void navigateToMortgageCalculatorHomePage() {
        ActOn.browserActions(driver).openBrowser(ReadConfigFiles.getPropertyValues("MortgageUrl"));

    }

    @And("^user navigate to Real APR page$")
    public void navigateToRealAprPage() {
        new Home(driver)
                .mouseHoverToRates()
                .navigatesToRealApr();
        LOGGER.info("Navigate to Real APR page");
    }

    @When("^user click on calculate button upon entering data$")
    public void clickOnCalculateButtonUponEnteringTheData(DataTable table) {
        List<Map<String,String >> data = table.asMaps(String.class,String.class);
        for(Map<String,String> cells:data){
            new RealApr(driver)
                    .typeHomePrice(cells.get("HomePrice"))
                    .clickDownPaymentInDollar()
                    .typeDownPayment(cells.get("DownPayment"))
                    .typeInterestRate(cells.get("InterestRate"))
                    .typeYearDuration(cells.get("Year"))
                    .clickOnCalculateButton();
        }
        LOGGER.info("Real APR is Calculated upon entering the data");

    }

    @Then("^the Real APR rate is \"(.+?)\"$")
    public void validateRealAprRate(String realApr) {
        new RealApr(driver)
                .validatingRealAprRate(realApr);

    LOGGER.info("Real APR is Validated");

    }


}
