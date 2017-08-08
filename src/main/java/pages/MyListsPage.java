package pages;

import blocks.ListItem;
import blocks.ContextDialog;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;


/**
 * Created by zsmirnova on 7/28/17.
 */
public class MyListsPage extends TopMenuPage {

    @AndroidFindBy(id = "editText1")
    private WebElement inputName;

    @AndroidFindBy(id = "button2")
    private WebElement buttonAdd;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.slava.buylist:id/mbg']")
    private List<ListItem> lists;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']")
    private ContextDialog contextDialog;

    public List<ListItem> getItemLists() { return lists;}

    public WebElement inputName() { return inputName; }

    public WebElement buttonAdd() { return buttonAdd; }

    public ContextDialog contextDialog() { return contextDialog; }

    public List<ListItem> lists() {
        return lists;
    }

    public MyListsPage(AppiumDriver driver) {
        super(driver);
    }

}
