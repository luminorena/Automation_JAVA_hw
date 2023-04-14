package OtherTests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.codeborne.selenide.Selenide.open;


public class FacebookTest {
    @Test
    void facebook() throws IOException, InterruptedException {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\olech\\Documents\\geckodriver.exe");
        String torBinaryPath = "C:\\Users\\olech\\Documents\\Tor Browser\\Browser\\firefox.exe";


        Runtime runTime = Runtime.getRuntime();
        Process torProcess = runTime.exec(torBinaryPath + " -n");
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("network.proxy.type", 1);
        profile.setPreference("network.proxy.socks", "127.0.0.1");
        profile.setPreference("network.proxy.socks_port", 9150);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setProfile(profile);
        WebDriver driver = new FirefoxDriver(firefoxOptions);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(100);
        //driver.navigate().to("https://www.facebook.com/");


        Configuration.browser = "firefox";
        Configuration.browserBinary = torBinaryPath;



        open("https://www.facebook.com/");





    }
}
