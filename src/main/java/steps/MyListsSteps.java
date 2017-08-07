package steps;

import blocks.ListItem;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import pages.MyListsPage;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

/**
 * Created by zsmirnova on 8/2/17.
 */
public class MyListsSteps extends BaseSteps{

    MyListsPage myListsPage = new MyListsPage(getDriver());

    public MyListsSteps(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Add new list ")
    public ProductSteps addNewList(String title){
        myListsPage.inputName().click();
        myListsPage.inputName().sendKeys(title);
        myListsPage.buttonAdd().click();
        return new ProductSteps(getDriver());
    }

    private ListItem getListByTitle(String title){
        return myListsPage.lists().stream().filter(buyItem
                -> buyItem.getItemTitle().getText().equals(title)).findFirst().get();
    }

    public List<ListItem> getListOfItems() {
        return myListsPage.getItemLists();
    }

    public ProductSteps openList(String title) {
        getListByTitle(title).getItemTitle().click();
        return new ProductSteps(getDriver());
    }

    @Step("Delete list with title ")
    public MyListsSteps deleteListByTitle(String title) {
        getListByTitle(title).getButtonDelete().click();
        return this;
    }

    @Step("Edit list with title ")
    public MyListsSteps editListName(String listTitle, String newListTitle) {
        getListByTitle(listTitle).getButtonEdit().click();
        myListsPage.contextDialog().getEditField().clear();
        myListsPage.contextDialog().getEditField().sendKeys(newListTitle);
        return this;
    }

    @Step("Press OK button in  context dialog")
    public MyListsSteps submitDialog() {
        myListsPage.contextDialog().getButtonOk().click();
        return this;
    }

    @Step("Check that title of list is with index")
    public void checkTitleOfList(String expectedTitle, int index) {
        assertEquals(getListOfItems().get(index).getItemTitle().getText(), expectedTitle, "Title is not correct");
    }

    @Step("Check order of lists")
    public void checkListsOrder(List<String> expectedTitles) {
        List<String> actualLists = myListsPage.lists().stream().map(item->item.getItemTitle().getText()).collect(Collectors.toList());
        assertEquals(actualLists, expectedTitles, "Order of lists is not correct");
    }
}
