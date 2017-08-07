package blocks;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

/**
 * Created by zsmirnova on 8/4/17.
 */
public abstract class ElementBase {

    private static final int DEFAULT_TIMEOUT = 60;
    private final WebElement element;
    private final WebDriver driver;

    ElementBase(WebDriver driver, WebElement element) {
        this.element = element;
        this.driver = driver;
    }

    WebElement getElement() {
        return element;
    }

    public boolean isDisplayed() {
        boolean isDisplayed;
        try {
            isDisplayed = element.isDisplayed();
        } catch (NoSuchElementException e) {
            // element does not exist, no need to do anything here.
            isDisplayed = false;
        }
        return isDisplayed;
    }

    public boolean isEnabled() {
        return element.isEnabled();
    }

    @Deprecated
    public boolean exists() {
        return isDisplayed();
    }

    public boolean isAppeared(int timeout) {
        boolean isDisplayed;
        if (driver != null) {
            Wait wait = new FluentWait(driver)
                    .withTimeout(timeout, TimeUnit.SECONDS)
                    .pollingEvery(1, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class);
            try {
                wait.until(ExpectedConditions.visibilityOf(getElement()));
                isDisplayed = true;
            } catch (TimeoutException e) {
                isDisplayed = false;
            }
        } else {
            isDisplayed = isDisplayed();
        }
        return isDisplayed;
    }

    public String getText() {
        return element.getText();
    }

    public String getAttribute(String attribute) {
        return element.getAttribute(attribute);
    }
}
