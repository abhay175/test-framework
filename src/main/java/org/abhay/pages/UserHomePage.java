package org.abhay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Properties;

public class UserHomePage extends BasePage{
    public UserHomePage(WebDriver driver) {
        super(driver);
        waitForPageToLoad();
    }

    @FindBy(xpath = "//*[@class='title' and text()='Products']")
    WebElement lbProducts;

    public void waitForPageToLoad(){
        wait.until(ExpectedConditions.visibilityOf(lbProducts));
    }



}
