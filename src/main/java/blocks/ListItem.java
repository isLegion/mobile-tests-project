package blocks;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.Widget;

/**
 * Created by zsmirnova on 7/31/17.
 */
public class ListItem extends Widget {

    @AndroidFindBy(id = "title")
    private MobileElement itemTitle;

    @AndroidFindBy(id = "imageView1")
    private MobileElement buttonDelete;

    @AndroidFindBy(id = "imageView2")
    private MobileElement buttonEdit;

    protected ListItem(MobileElement element) {
        super(element);
    }

    public MobileElement getItemTitle() {return itemTitle;}

    public MobileElement getButtonDelete() {
        return buttonDelete;
    }

    public MobileElement getButtonEdit() {
        return buttonEdit;
    }
}
