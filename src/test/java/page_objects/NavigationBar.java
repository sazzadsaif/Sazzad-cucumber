package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar {
    private final By RateLink = By.linkText("Rates");
    private final By RealAprLink = By.linkText("Real APR");
    private final By MortgageCalculatorLogo = By.xpath("//a/img[@alt='Logo']");

    private static final Logger LOGGER = LogManager.getLogger(NavigationBar.class);

    public WebDriver driver;

    public NavigationBar(WebDriver driver){
        this.driver = driver;
    }

    public NavigationBar mouseHoverToRates(){
        //Mouse Hover to Rates link
        LOGGER.debug("Mouse Hover To Rates Link");
        ActOn.elementActions(driver,RateLink).mouseHover();
        return this;
    }

    public RealApr navigatesToRealApr(){
        LOGGER.debug("Navigating to real Apr Page");
        ActOn.elementActions(driver,RealAprLink).click();
        return new RealApr(driver);
    }

    public Home navigateToHome(){
        LOGGER.debug("Navigating to Mortgage Calculator Home Page");
        ActOn.elementActions(driver,MortgageCalculatorLogo).click();
        return new Home(driver);
    }

}
