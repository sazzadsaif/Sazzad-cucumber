package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RealApr extends NavigationBar {
    private final By RateLink = By.linkText("Rates");
    private final By RealAprLink = By.linkText("Real APR");
    private final By CalculatorTab = By.xpath("//label[text()='Calculator']");
    private final By HomePriceInputField = By.name("HomeValue");
    private final By DownPaymentInDollar = By.id("DownPaymentSel0");
    private final By DownPaymentInputField = By.name("DownPayment");
    private final By InterestRateInputField = By.name("Interest");
    private final By YearDuration = By.name("Length");
    private final By CalculateRateButton = By.name("calculate");
    private final By ActualAprRate = By.xpath("//*[@id='analysisDiv']/table/tbody/tr/td/strong[text()='Actual APR:']/../../td[2]/strong");

    private static final Logger LOGGER = LogManager.getLogger(RealApr.class);


    public RealApr(WebDriver driver){
        super(driver);

    }
    public RealApr waitForPageToLoad(){
        LOGGER.debug("Wa for the page to load");
        ActOn.waitFor(driver,CalculatorTab).waitForElementToBeVisible();
        return this;
    }
    public RealApr typeHomePrice(String value){
        LOGGER.debug("Enter home price value: " + value);
        ActOn.elementActions(driver,HomePriceInputField).setValue(value);
        return this;
    }
    public RealApr clickDownPaymentInDollar(){
        LOGGER.debug("Click down payment button");
        ActOn.elementActions(driver,DownPaymentInDollar).click();
        return this;
    }
    public RealApr typeDownPayment(String value){
        LOGGER.debug(" Enter down payment: " + value);
        ActOn.elementActions(driver,DownPaymentInputField).setValue(value);
        return this;
    }
    public RealApr typeInterestRate(String value){
        LOGGER.debug("Enter Interest rate: " + value);
        ActOn.elementActions(driver,InterestRateInputField).setValue(value);
        return this;
    }
    public RealApr typeYearDuration(String value){
        LOGGER.debug("Enter year duration: " + value);
        ActOn.elementActions(driver,YearDuration).setValue(value);
        return this;
    }
    public RealApr clickOnCalculateButton(){
        LOGGER.debug("Clicking on the Calculate Button");
        ActOn.elementActions(driver,CalculateRateButton).click();
        return this;
    }
    public RealApr validatingRealAprRate(String expectedAprRate){
        LOGGER.debug("Validate the real apr rate is: " + expectedAprRate);
        String actualRealAprRate = ActOn.elementActions(driver,ActualAprRate).getTextValue();
        Assert.assertEquals(expectedAprRate,actualRealAprRate);
        return this;
    }



}
