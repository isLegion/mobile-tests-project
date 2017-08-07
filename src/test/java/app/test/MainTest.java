package app.test;

import app.AppiumAppInstance;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.AppiumBasePage;
import pages.ProductPage;
import steps.MyListsSteps;
import steps.ProductSteps;
import steps.SettingsSteps;
import utils.TestData;

import java.util.Arrays;

import static org.testng.Assert.assertTrue;

/**
 * Created by zsmirnova on 7/28/17.
 */
public class MainTest extends AppiumAppInstance {

    private static final String LIST_NAME = "A_" + TestData.getRandomWord();
    private static final String ITEM_NAME = "A_" + TestData.getRandomWord();
    private static final String PRICE = "2300 ";

    @Test
    @Description("Check deleting list")
    public void checkDeleteListTest() {

        app.myListSteps()
                .addNewList(LIST_NAME)
                .setProductName(ITEM_NAME)
                .selectCategory(ProductPage.Categories.ACCESSORIES)
                .saveProduct()
                .backToMyListsPage()
                .deleteListByTitle(LIST_NAME)
                .submitDialog();
        assertTrue(app.myListSteps().getListOfItems().isEmpty(), "Item hasn't deleted");
    }

    @Test
    @Description("Correct saving of all fields after adding a new one item")
    public void checkFullFieldsInItem() {

        String expectedMeasure = "3 box";
        String expectedComment = "my first comment";

        app.myListSteps()
                .addNewList(LIST_NAME)
                .setProductName(ITEM_NAME)
                .selectCategory(ProductPage.Categories.ACCESSORIES)
                .setAmount("3")
                .setPrice(PRICE)
                .selectMeasures("box")
                .setComment(expectedComment)
                .saveProduct()
                .checkAmount(ITEM_NAME, expectedMeasure)
                .checkPrice(ITEM_NAME, PRICE + AppiumBasePage.Currency.£)
                .checkComment(ITEM_NAME, expectedComment);
    }

    @Test
    @Description("Check summing prices of items in list")
    public void checkTotalPrice() {

        String SECOND_ITEM = TestData.getRandomWord();
        int firstPrice = 200;
        int secondPrice = 33;
        int firstAmount = 3;
        int secondAmount = 12;
        String expectedTotalPrice = Integer.toString(firstPrice * firstAmount + secondPrice * secondAmount);

        app.myListSteps()
                .addNewList(LIST_NAME)
                .setProductName(ITEM_NAME)
                .setAmount(Integer.toString(firstAmount))
                .setPrice(Integer.toString(firstPrice))
                .saveProduct()
                .setProductName(SECOND_ITEM)
                .setAmount(Integer.toString(secondAmount))
                .setPrice(Integer.toString(secondPrice))
                .saveProduct()
                .checkTotalPrice(expectedTotalPrice, AppiumBasePage.Currency.£);
    }

    @Test
    @Description("Checking editing name of list")
    public void checkEditList() {

        String NEW_LIST_NAME = TestData.getRandomWord();
        app.myListSteps()
                .addNewList(LIST_NAME)
                .setProductName(ITEM_NAME)
                .saveProduct()
                .backToMyListsPage()
                .editListName(LIST_NAME, NEW_LIST_NAME)
                .submitDialog()
                .checkTitleOfList(NEW_LIST_NAME, 0);
    }

    @Test
    @Description("Checking sorting lists")
    public void checkSortingList() {

        String LAST_LIST_NAME = "Z_" + TestData.getRandomWord();
        String MIDDLE_LIST_NAME = "D_" + TestData.getRandomWord();

        app.myListSteps()
                .addNewList(LIST_NAME)
                .setProductName(ITEM_NAME)
                .saveProduct()
                .backToMyListsPage()
                .addNewList(MIDDLE_LIST_NAME)
                .setProductName(ITEM_NAME)
                .saveProduct()
                .backToMyListsPage()
                .addNewList(LAST_LIST_NAME)
                .setProductName(ITEM_NAME)
                .saveProduct()
                .backToMyListsPage()
                .checkListsOrder(Arrays.asList(LIST_NAME, MIDDLE_LIST_NAME, LAST_LIST_NAME));
    }

    @Test
    @Description("Checking correct display new currency")
    public void checkChangeCurrency() {
         app.myListSteps();
         SettingsSteps settingsSteps = new SettingsSteps(driver);
         settingsSteps
                 .openSettings()
                 .selectCurrency(AppiumBasePage.Currency.$)
                 .navigateBack();
        MyListsSteps myListsSteps = new MyListsSteps(driver);
        myListsSteps.addNewList(LIST_NAME)
                .setProductName(ITEM_NAME)
                .setPrice(PRICE)
                .saveProduct()
                .checkPrice(ITEM_NAME, PRICE + AppiumBasePage.Currency.$);
    }

    @Test
    @Description("Check that price and comment don't display after sett off in settings (before creating new item)")
    public void checkNotDisplayedPriceAndCommentBeforeCreating() {
        String comment = TestData.getRandomWord();
        app.myListSteps();
        SettingsSteps settingsSteps = new SettingsSteps(driver);
        settingsSteps
                .openSettings()
                .checkedUncheckedDisplayComment()
                .checkedUncheckedDisplayPrice()
                .navigateBack();
        MyListsSteps myListsSteps = new MyListsSteps(driver);
        myListsSteps.addNewList(LIST_NAME)
                .setProductName(ITEM_NAME)
                .setPrice(PRICE)
                .setComment(comment)
                .saveProduct()
                .checkNotDisplayComment(ITEM_NAME)
                .checkNotDisplayPrice(ITEM_NAME);
    }

    @Test
    @Description("Check that price and comment don't display after sett off in settings (after creating new item)")
    public void checkNotDisplayedPriceAndCommentAfterCreating() {
        String comment = TestData.getRandomWord();
        app.myListSteps()
                .addNewList(LIST_NAME)
                .setProductName(ITEM_NAME)
                .setPrice(PRICE)
                .setComment(comment)
                .saveProduct()
                .checkPrice(ITEM_NAME, PRICE + AppiumBasePage.Currency.£)
                .checkComment(ITEM_NAME, comment);
        SettingsSteps settingsSteps = new SettingsSteps(driver);
        settingsSteps
                .openSettings()
                .checkedUncheckedDisplayComment()
                .checkedUncheckedDisplayPrice()
                .navigateBack();
        ProductSteps productSteps = new ProductSteps(driver);
        productSteps
                .checkNotDisplayComment(ITEM_NAME)
                .checkNotDisplayPrice(ITEM_NAME);
    }

    @Test
    @Description("Check that price and comment don't display after sett off in settings (after creating new item)")
    public void addNewItemsToList() {
        String secondListItem = TestData.getRandomWord();
        String item2 = TestData.getRandomWord();
        app.myListSteps()
                .addNewList(LIST_NAME)
                .setProductName(ITEM_NAME)
                .saveProduct()
                .backToMyListsPage()
                .addNewList(secondListItem)
                .setProductName(item2)
                .backToMyListsPage()
                .openList(LIST_NAME)
                .checkDisplayItem(ITEM_NAME)
                .backToMyListsPage()
                .checkListsOrder(Arrays.asList(LIST_NAME, secondListItem));
    }

    @Test
    @Description("Check alphabetic sorting items in list")
    public void checkAlphabeticSortingItems() {
        String item2 = "C_" + TestData.getRandomWord();
        String item3 = "G_" + TestData.getRandomWord();
        String item4 = "5_" + TestData.getRandomWord();
        String item5 = "z_" + TestData.getRandomWord();

        app.myListSteps()
                .addNewList(LIST_NAME)
                .setProductName(item2)
                .saveProduct()
                .setProductName(item5)
                .saveProduct()
                .setProductName(item3)
                .saveProduct()
                .setProductName(ITEM_NAME)
                .saveProduct()
                .setProductName(item4)
                .saveProduct()
                .checkOrderItems(Arrays.asList(item2, item5, item3, ITEM_NAME, item4));
        SettingsSteps settingsSteps = new SettingsSteps(driver);
        settingsSteps
                .openSettings()
                .selectOrder(AppiumBasePage.Sorting.BY_ALPHABET)
                .navigateBack();
        ProductSteps productSteps = new ProductSteps(driver);
        productSteps
                .checkOrderItems(Arrays.asList(item4, ITEM_NAME, item2, item3, item5));

    }

}
