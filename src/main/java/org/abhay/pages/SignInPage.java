package org.abhay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.lang.reflect.InvocationTargetException;

public class SignInPage extends BasePage{
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement btnSignIn;

    public  SignInPage load(){
        load("");
        waitForPageToLoad();
        return this;
    }

    public void waitForPageToLoad(){
        wait.until(ExpectedConditions.elementToBeClickable(btnSignIn));
    }

    public <T extends BasePage> T enterCredentialsAndClickSubmit(String username, String password, Class<T> className) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        txtEmail.sendKeys(username);
        txtPassword.sendKeys(password);
        btnSignIn.click();
        return className.getConstructor(WebDriver.class).newInstance(driver);
    }

}
