package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by zsmirnova on 8/1/17.
 */
public abstract class BasePage {

    private WebDriver driver;
    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver getDriver() {
        return driver;
    }

}

