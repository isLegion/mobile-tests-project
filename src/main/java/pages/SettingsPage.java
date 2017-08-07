package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by zsmirnova on 7/28/17.
 */
public class SettingsPage extends AppiumBasePage {

    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout)[1]")
    private WebElement buttonSortList;

    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout)[2]")
    private WebElement buttonCurrency;

    @AndroidFindBy(id = "text1")
    private List<WebElement> settingMenuList;

    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout)[7]")
    private WebElement checkboxComment;

    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout)[8]")
    private WebElement checkboxPrice;

    public SettingsPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public WebElement getButtonSortList() {
        return buttonSortList;
    }

    public WebElement getButtonCurrency() {
        return buttonCurrency;
    }

    public List<WebElement> getSettingMenuList() {
        return settingMenuList;
    }

    public WebElement getCheckboxPrice() {
        return checkboxPrice;
    }

    public WebElement getCheckboxComment() {
        return checkboxComment;
    }
}
