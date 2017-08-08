package steps;

import pages.TopMenuPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import pages.AppiumBasePage;
import pages.SettingsPage;

/**
 * Created by zsmirnova on 8/3/17.
 */
public class SettingsSteps extends BaseSteps {

    SettingsPage settingsPage = new SettingsPage(getDriver());
    TopMenuPage topMenu = new TopMenuPage(getDriver());

    @Step("Open setting in top navigation menu")
    public SettingsSteps openSettings() {
        topMenu.getTopMenu().click();
        topMenu.getSetings().click();
        return new SettingsSteps(getDriver());
    }

    public WebElement getSettingItemInList(String settingName){
        return settingsPage.getSettingMenuList().stream().filter(cur
                ->cur.getText().contains(settingName)).findFirst().get();
    }
    @Step("Select currency {0} in settings")
    public SettingsSteps selectCurrency(AppiumBasePage.Currency currency){
        settingsPage.getButtonCurrency().click();
        getSettingItemInList(currency.name()).click();
        return this;
    }

    @Step("Select sorting in settings")
    public SettingsSteps selectOrder(AppiumBasePage.Sorting sorting){
        settingsPage.getButtonSortList().click();
        getSettingItemInList(sorting.toString()).click();
        return this;
    }

    @Step("Check/ unchecked Comment in display block")
    public SettingsSteps checkedUncheckedDisplayComment(){
        settingsPage.getCheckboxComment().click();
        return this;
    }

    @Step("Check/ unchecked Price in display block")
    public SettingsSteps checkedUncheckedDisplayPrice(){
        settingsPage.getCheckboxPrice().click();
        return this;
    }

    public SettingsSteps(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
}
