package blocks;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.Widget;
import org.openqa.selenium.WebElement;

/**
 * Created by zsmirnova on 8/2/17.
 */
public class ContextDialog extends Widget {

    @AndroidFindBy(xpath = ".//android.widget.Button[@resource-id='android:id/button1']")
    private WebElement buttonOk;

    @AndroidFindBy(xpath = ".//android.widget.Button[@resource-id='android:id/button2']")
    private WebElement buttonNo;

    @AndroidFindBy(xpath = ".//android.widget.EditText")
    private WebElement editField;

    protected ContextDialog(WebElement element) {
        super(element);
    }

    public WebElement getButtonOk() {
        return buttonOk;
    }

    public WebElement getButtonNo() {
        return buttonNo;
    }

    public WebElement getEditField() {
        return editField;
    }
}
