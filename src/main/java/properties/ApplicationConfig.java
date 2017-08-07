package properties;

import org.aeonbits.owner.Config;

/**
 * Created by zsmirnova on 8/1/17.
 */
@Config.Sources({ "file:src/main/java/properties/ApplicationConfig.properties" })
public interface ApplicationConfig extends Config {

    @Key("deviceName")
    String deviceName();

    @Key("platformVersion")
    String platformVersion();

    @Key("app")
    String app();

    @Key("platformName")
    String platformName();
}
