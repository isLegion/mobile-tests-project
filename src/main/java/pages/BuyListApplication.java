package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import steps.MyListsSteps;
import steps.ProductSteps;

/**
 * Created by zsmirnova on 8/1/17.
 */
public class BuyListApplication {

    private final AppiumDriver<MobileElement> driver;

    public BuyListApplication(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public MyListsSteps myListSteps() { return new MyListsSteps(driver);}

    public ProductSteps projectSteps() { return new ProductSteps(driver);}

}
