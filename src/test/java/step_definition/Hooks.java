package step_definition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.DriverFactory;

public class Hooks {
    private static final Logger LOGGER = LogManager.getLogger(Hooks.class);
    public static WebDriver driver;
    @Before
    public void browserInitialization(){

        driver = DriverFactory.getInstance().getDriver();
        LOGGER.info("Launch Browser");
    }
    @After
    public void closeBrowser(){
        DriverFactory.getInstance().removeDriver();
        LOGGER.info("Closed the browser");
    }
}
