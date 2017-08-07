package app;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Attachment;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BuyListApplication;
import properties.ApplicationConfig;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.String.format;
import static org.testng.FileAssert.fail;

/**
 * Created by zsmirnova on 7/28/17.
 */
public abstract class AppiumAppInstance {

    protected AppiumDriver driver;
    protected BuyListApplication app;

    public final static String HUB_URL = "http://0.0.0.0:4723/wd/hub";

    @BeforeMethod
    public void setUp() throws MalformedURLException {

        ApplicationConfig cfg = ConfigFactory.create(ApplicationConfig.class);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, cfg.deviceName());
        capabilities.setCapability(MobileCapabilityType.APP, cfg.app());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, cfg.platformVersion());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, cfg.platformName());
        driver = new AppiumDriver(new URL(HUB_URL), capabilities);

        app = new BuyListApplication(driver);
    }

    private byte[] getSampleFile(String fileName) throws IOException, URISyntaxException {
        URL resource = getClass().getClassLoader().getResource(fileName);
        if (resource == null) {
            fail(format("Couldn't find resource '%s'", fileName));
        }
        return Files.readAllBytes(Paths.get(resource.toURI()));
    }

    @Attachment(value = "Sample svg attachment", type = "image/svg+xml")
    public byte[] saveSvgAttachment() throws URISyntaxException, IOException {
        return getSampleFile("sample.svg");
    }

    @AfterMethod
    public void close() throws URISyntaxException, IOException{
        saveSvgAttachment();
        driver.closeApp();
    }

}


