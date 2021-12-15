package page_objects;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends NavigationBar {
    private final By HomeValueInputField = By.id("homeval");
    private final By DownPaymentInputField = By.id("downpayment");
    private final By SelectDownPaymentInDollar = By.name("param[downpayment_type]");
    private final By LoanAmountInputField = By.id("loanamt");
    private final By InterestRateInputField = By.id("intrstsrate");
    private final By LoanTermInputField = By.id("loanterm");
    private final By StartMonthDropDown = By.name("param[start_month]");
    private final By StartYearInputField = By.id("start_year");
    private final By PropertyTaxInputField = By.id("pptytax");
    private final By PMIInputField = By.id("pmi");
    private final By HomeInsInputField = By.id("hoi");
    private final By HoaInputField = By.id("hoa");
    private final By LoanTypeDropDown = By.name("param[milserve]");
    private final By RefiOrBuyDropDown = By.name("param[refiorbuy]");
    private final By CalculateButton = By.name("cal");

    private static final Logger LOGGER = LogManager.getLogger(Home.class);



    public Home(WebDriver driver){
        super(driver);


    }
    public Home typeHomePrice(String value){
        LOGGER.debug("Typing the home price: " + value);
        ActOn.elementActions(driver,HomeValueInputField).setValue(value);
        return this;
    }
    public Home typeDownPayment(String value){
        LOGGER.debug("Typing the down payment: " + value);
        ActOn.elementActions(driver,DownPaymentInputField).setValue(value);
        return this;

    }
    public Home clickDownPaymentInDollar(){
        LOGGER.debug("Click the dollar button");
        ActOn.elementActions(driver,SelectDownPaymentInDollar).click();
        return this;

    }
    public Home typeTheLoanAmount(String value){
        LOGGER.debug("Enter Loan amount " + value);
        ActOn.elementActions(driver,LoanAmountInputField).setValue(value);
        return this;
    }
    public Home typeInterestRate(String value){
        LOGGER.debug("Enter interest rate: " + value);
        ActOn.elementActions(driver,InterestRateInputField).setValue(value);
        return this;
    }
    public Home typeLoanTermYears(String value){
        LOGGER.debug("Enter loan term in years :" + value);
        ActOn.elementActions(driver,LoanTermInputField).setValue(value);
        return this;
    }
    public Home selectMonth(String month){
        LOGGER.debug("Selecting the start month :" + month);
        ActOn.elementActions(driver,StartMonthDropDown).selectValue(month);
        return this;
    }
    public Home selectYear(String year){
        LOGGER.debug("Selecting the start year :" + year);
        ActOn.elementActions(driver,StartYearInputField).setValue(year);
        return this;
    }
    public Home typePropertyTax(String value){
        LOGGER.debug("Enter property tax :" + value);
        ActOn.elementActions(driver,PropertyTaxInputField).setValue(value);
        return this;

    }
    public Home typePMI(String value){
        LOGGER.debug("Enter PMI :" + value);
        ActOn.elementActions(driver,PMIInputField).setValue(value);
        return this;

    }
    public Home typeHomeIns(String value){
        LOGGER.debug("Enter PMI :" + value);
        ActOn.elementActions(driver,HomeInsInputField).setValue(value);
        return this;

    }
    public Home typeHOA(String value){
        LOGGER.debug("Enter HOA :" + value);
        ActOn.elementActions(driver,HoaInputField).setValue(value);
        return this;

    }
    public Home selectLoanType(String value){
        LOGGER.debug("Select loan type :" + value);
        ActOn.elementActions(driver,LoanTypeDropDown).selectValue(value);
        return this;
    }
    public Home selectBuyOrRefiOption(String value){
        LOGGER.debug("Select buy or refi  :" + value);
        ActOn.elementActions(driver,RefiOrBuyDropDown).selectValue(value);
        return this;
    }
    public Home clickOnTheCalculateButton(){
        LOGGER.debug("Click on the calculate button");
        ActOn.elementActions(driver,CalculateButton).click();
        return this;
    }
    public Home validateTotalMonthlyPayment(String expectedTotalMonthlyPayment){

        String formattedXpath = String.format("//h3[text()='%s']",expectedTotalMonthlyPayment);
        By monthlyPayment = By.xpath(formattedXpath);

        LOGGER.debug("Validating that the total monthly payment is: " + expectedTotalMonthlyPayment);

        AssertThat.elementAssertions(driver,monthlyPayment).elementIsDisplayed();
        return this;

    }




}
