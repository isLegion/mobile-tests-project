package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pages.AppiumBasePage;

/**
 * Created by zsmirnova on 8/4/17.
 */
public class TopMenuPage extends AppiumBasePage {

    @AndroidFindBy(id = "button1")
    private WebElement topMenu;

    @AndroidFindBy(xpath = "//android.widget.TextView[1]")
    private WebElement setings;

    public WebElement getTopMenu() {
        return topMenu;
    }

    public WebElement getSetings() {
        return setings;
    }

    public TopMenuPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
}
