package blocks;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.Widget;
import org.openqa.selenium.WebElement;

/**
 * Created by zsmirnova on 8/2/17.
 */
public class Item extends Widget{

    @AndroidFindBy(id = "title")
    private WebElement title;

    @AndroidFindBy(id = "str1")
    private WebElement comment;

    @AndroidFindBy(id = "TextView01")
    private WebElement amount;

    @AndroidFindBy(id = "textView1")
    private WebElement price;

    protected Item(WebElement element) {
        super(element);
    }

    public WebElement getPrice() {
        return price;
    }

    public WebElement getAmount() {
        return amount;
    }

    public WebElement getComment() {
        return comment;
    }

    public WebElement getTitle() {
        return title;
    }
}
