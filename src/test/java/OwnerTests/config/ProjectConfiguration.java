package OwnerTests.config;

import com.codeborne.selenide.Configuration;
import com.google.common.base.Strings;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ProjectConfiguration {
    static WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

    public static void configure() {

        Configuration.baseUrl = config.baseUrl();
        Configuration.browser = config.browser();
        Configuration.browserVersion = config.browserVersion();


        String remoteUrl = config.remoteWebDriverUrl();
        if (!Strings.isNullOrEmpty(remoteUrl)) {
            Configuration.remote = remoteUrl;
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }

    }

