package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.Widget;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by zsmirnova on 7/28/17.
 */
public class AppiumBasePage {

    protected final AppiumDriver<MobileElement> driver;

    public AppiumBasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public enum Categories{
        PET_PRODUCTS("Pet products"),
        CHILD_PRODIUCTS("Child products"),
        ACCESSORIES("Accessories"),
        FROZEN_FOOD("Frozen food"),
        GROCERY("Grocery"),
        DRINKS_JUICES("Drinks, juices");

        private String title;

        Categories(String title){
            this.title = title;
        }

        public String title(){ return title;}
    }

    public enum Currency{
        £,
        $,
        €,
        OTHER;

        private Currency(){ }
    }

    public enum Sorting{
        BY_CATEGORY("By category"),
        BY_ALPHABET("By alphabet"),
        IN_A_PRE_ORDER("In a pre-order"),
        IN_REVERSE_ORDER("In reverse order");

        private String title;

        private Sorting(String title){
            this.title = title;
        }

        @Override
        public String toString() { return  title;}
    }
}
