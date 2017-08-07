package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import pages.AppiumBasePage;

/**
 * Created by zsmirnova on 8/2/17.
 */
public class BaseSteps {

    private static final Logger logger = LogManager.getLogger(AppiumBasePage.class);

    private AppiumDriver<MobileElement> driver;

    protected AppiumDriver<MobileElement> getDriver() {
        return this.driver;
    }

    public BaseSteps(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }


    protected boolean isElementDisplayed(final WebElement element) {
        int minimumViablyDisplayed = 30;
        boolean isDisplayed = false;
        try {
            // calculate if an element is barely showing on the bottom of the page
            // we have problems clicking elements that are not showing enough near the bottom
            // have not seen this issue near the top of the page
            int screenHeight = getDriver().manage().window().getSize().getHeight();
            int elementY = element.getLocation().getY();
            int visibleHeight = screenHeight - elementY;
            if (element.isDisplayed() && visibleHeight > minimumViablyDisplayed) {
                isDisplayed = true;
            }
        } catch (NoSuchElementException e) {
            // This is expected exception since the element may not be displayed due to not being on screen
            logger.debug("The element was not found.");
        }
        return isDisplayed;
    }

    @Step("Hide keyboard")
    public void hideKeyBoardIfPossible() {
        try {
            getDriver().hideKeyboard();
        } catch (WebDriverException e) {
            e.getMessage();
        }
    }

    @Step("Back to previous page")
    public void navigateBack() {
        getDriver().navigate().back();
    }

}
