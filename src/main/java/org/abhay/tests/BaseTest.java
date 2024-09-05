package org.abhay.tests;

import org.abhay.driver.DriverFactory;
import org.abhay.enums.Browser;
import org.abhay.utils.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    static WebDriver driver;
    static Properties properties;
    private String browser;
    @BeforeClass
    void setUp(){
        properties = ConfigLoader.getInstance().getProperties();
    }

    @BeforeMethod
    synchronized  void startDriver(){
        driver = DriverFactory.createInstance(Browser.valueOf(properties.getProperty("browser")));
    }

    @AfterMethod
    synchronized void quitDriver(){
        driver.quit();
        DriverFactory.unload();
    }

}
