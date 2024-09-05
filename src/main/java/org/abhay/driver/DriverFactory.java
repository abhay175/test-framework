package org.abhay.driver;

import org.abhay.enums.Browser;
import org.abhay.enums.Target;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URI;

public class DriverFactory {

    private DriverFactory(){};

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    public static WebDriver createInstance(Browser browser){
        switch (browser){
            case CHROME:
                setDriver(new ChromeDriverManager().createDriver());
                return getDriver();
            case FIREFOX:
                setDriver(new FirefoxDriverManager().createDriver());
                return getDriver();
            default:
                throw new IllegalStateException("Unexpected value: " + browser);
        }
    }

    public static WebDriver createInstance(Target target, Browser browser, String hubUrl) throws MalformedURLException {
        switch (target){
            case LOCAL:return createInstance(browser);
            case REMOTE:
                return createRemoteDriver(hubUrl, new MutableCapabilities());
            default:
                throw new IllegalStateException("Unexpected value: " + target);
        }
    }

    public static RemoteWebDriver createRemoteDriver(String hubUrl, MutableCapabilities capability) throws MalformedURLException {
        return new RemoteWebDriver(URI.create(hubUrl).toURL(), capability);
    }

    public static void setDriver(WebDriver driver){
        webDriverThreadLocal.set(driver);
    };

    public static WebDriver getDriver(){
        return webDriverThreadLocal.get();
    };

    public static void unload() {
        webDriverThreadLocal.remove();
    }
}
