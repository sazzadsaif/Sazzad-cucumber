package command_providers;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ElementAssertions {
    WebDriver driver;
    By locator;

    public ElementAssertions(WebDriver driver,By locator){
        this.driver = driver;
        this.locator = locator;
    }
    public ElementAssertions elementIsDisplayed(){
        boolean displayed =driver.findElement(locator).isDisplayed();
        Assert.assertEquals("The expected element does not exists", true, displayed);
        return this;
    }

}
