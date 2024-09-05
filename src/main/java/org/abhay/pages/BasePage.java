package org.abhay.pages;

import org.abhay.utils.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected  Properties properties;

    public BasePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofMinutes(30));
        this.properties = ConfigLoader.getInstance().getProperties();
    }

    void load(String endpoint){
        driver.get(properties.getProperty("base.url") + endpoint);
    }


}
