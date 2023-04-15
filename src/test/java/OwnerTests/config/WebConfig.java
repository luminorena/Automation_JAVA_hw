package OwnerTests.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${env}.properties"
})
public interface WebConfig extends Config {
    @Key("browser")
    String browser();

    @Key("browserVersion")
    String browserVersion();

    @Key("remoteWebDriverUrl")
    @DefaultValue("")
    String remoteWebDriverUrl();

    @Key("baseUrl")
    @DefaultValue("https://wildberries.ru")
    String baseUrl();
}
