package steps;

import blocks.Item;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import pages.AppiumBasePage;
import pages.ProductPage;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static utils.StringFormat.TOTAL_PRICE_FORMAT;


/**
 * Created by zsmirnova on 8/2/17.
 */
public class ProductSteps extends BaseSteps {

    ProductPage productPage = new ProductPage(getDriver());

    @Step("Select category")
    public ProductSteps selectCategory(ProductPage.Categories categoryTitle) {
        productPage.selectorCategory().click();
        WebElement categoryItem = productPage.categories().stream().filter(category
                -> category.getText().equals(categoryTitle.title())).findFirst().get();
        categoryItem.click();
        return this;
    }

    @Step("item with title ")
    public Item getItemByTitle(String title) {
        return productPage.listItems().stream().filter(item
                -> item.getTitle().getText().equals(title)).findFirst().get();
    }

    @Step("Check that total price is correct")
    public ProductSteps checkTotalPrice(String totalPrice, AppiumBasePage.Currency currency) {
        assertEquals(productPage.totalPrice().getText(), String.format(TOTAL_PRICE_FORMAT, totalPrice, currency), "Total price is incorrect");
        return this;
    }

    @Step("Check display item}")
    public ProductSteps checkDisplayItem(String title) {
        assertEquals(getItemByTitle(title).getTitle().getText(), title, "Item is not display on page");
        return this;
    }

    @Step("Check displayed items ")
    public ProductSteps checkOrderItems(List<String> expectedItems) {
        List<String> actualItems = productPage.listItems().stream().map(item
                ->item.getTitle().getText()).collect(Collectors.toList());
        assertEquals(actualItems, expectedItems);
        return this;
    }

    @Step("Set price  to item")
    public ProductSteps setPrice(String price) {
        productPage.inputPrice().click();
        productPage.inputPrice().sendKeys(price);
        return this;
    }

    @Step("Set amount to item")
    public ProductSteps setAmount(String amount) {
        productPage.inputAmount().click();
        productPage.inputAmount().sendKeys(amount);
        return this;
    }

    @Step("Set comment to Item")
    public ProductSteps setComment(String comment) {
        productPage.inputComment().click();
        productPage.inputComment().sendKeys(comment);
        return this;
    }

    @Step("Select measures ")
    public ProductSteps selectMeasures(String measure) {
        productPage.selectorMeasure().click();
        WebElement measureItem = productPage.measures().stream().filter(category
                -> category.getText().equals(measure)).findFirst().get();
        measureItem.click();
        return this;
    }

    @Step("Set name to item")
    public ProductSteps setProductName(String name){
        productPage.inputProductName().click();
        productPage.inputProductName().sendKeys(name);
        return this;
    }

    @Step("Save new item")
    public ProductSteps saveProduct(){
        productPage.addButton().click();
        hideKeyBoardIfPossible();
        return this;
    }

    @Step("Back to My Lists Page")
    public MyListsSteps backToMyListsPage() {
        getDriver().navigate().back();
        return new MyListsSteps(getDriver());
    }

    @Step("Check correct amount of item")
    public ProductSteps checkAmount(String itemTitle, String expectedAmount) {
        String actualAmount = getItemByTitle(itemTitle).getAmount().getText();
        assertEquals(actualAmount, expectedAmount, "Amount is not correct");
        return this;
    }

    @Step("Check correct price of item ")
    public ProductSteps checkPrice(String itemTitle, String expectedPrice) {
        String actualPrice = getItemByTitle(itemTitle).getPrice().getText();
        assertEquals(actualPrice, expectedPrice, "Price is not correct");
        return this;
    }

    @Step("Check correct comment ")
    public ProductSteps checkComment(String itemTitle, String expectedComment) {
        String actualComment = getItemByTitle(itemTitle).getComment().getText();
        assertEquals(actualComment, expectedComment, "Comment is not correct");
        return this;
    }

    @Step("Check that comment not display of item ")
    public ProductSteps checkNotDisplayComment(String itemTitle) {
        assertFalse(isElementDisplayed(getItemByTitle(itemTitle).getComment()), "Comment is displayed");
        return this;
    }

    @Step("Check that price not display of item ")
    public ProductSteps checkNotDisplayPrice(String itemTitle) {
        assertFalse(isElementDisplayed(getItemByTitle(itemTitle).getPrice()),"Price is displayed");
        return this;
    }

    public ProductSteps(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
}
