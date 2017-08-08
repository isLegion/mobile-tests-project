package pages;

import blocks.Item;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by zsmirnova on 7/31/17.
 */
public class ProductPage extends TopMenuPage {

    @AndroidFindBy(id = "editText1")
    private WebElement inputProductName;

    @AndroidFindBy(id = "button2")
    private WebElement addButton;

    @AndroidFindBy(id = "editText2")
    private WebElement inputPrice;

    @AndroidFindBy(id = "editText3")
    private WebElement inputAmount;

    @AndroidFindBy(id = "editText4")
    private WebElement inputComment;

    @AndroidFindBy(id = "spinner1")
    private WebElement selectorMeasure;

    @AndroidFindBy(id = "select_dialog_listview")
    private WebElement categoryContainer;

    @AndroidFindBy(id = "spinner2")
    private WebElement selectorCategory;

    @AndroidFindBy(id = "spinner2")
    private WebElement titleCategory;

    @AndroidFindBy(id = "text1")
    private List<WebElement> categories;

    @AndroidFindBy(id = "text1")
    private List<WebElement> measures;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.slava.buylist:id/item']")
    private List<Item> listItems;

    @AndroidFindBy(id = "textView2")
    private WebElement totalPrice;

    public ProductPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement inputProductName() {
        return inputProductName;
    }

    public WebElement addButton() {
        return addButton;
    }

    public WebElement inputPrice() {
        return inputPrice;
    }

    public WebElement inputAmount() {
        return inputAmount;
    }

    public WebElement inputComment() {
        return inputComment;
    }

    public WebElement selectorMeasure(){
        return selectorMeasure;
    }

    public WebElement selectorCategory(){
        return selectorCategory;
    }

    public WebElement titleCategory() {
        return titleCategory;
    }

    public List<WebElement> categories(){
        return categories;
    }

    public List<WebElement> measures() {
        return measures;
    }

    public List<Item> listItems() {
        return listItems;
    }

    public WebElement categoryContainer() {
        return categoryContainer;
    }

    public WebElement totalPrice() {
        return totalPrice;
    }

}
