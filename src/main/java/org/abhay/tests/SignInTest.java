package org.abhay.tests;

import org.abhay.pages.SignInPage;
import org.abhay.pages.UserHomePage;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;

public class SignInTest extends BaseTest{

    @Test
    public void testSignIn() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        SignInPage signInPage = new SignInPage(driver);
        UserHomePage userHomePage = signInPage.load().enterCredentialsAndClickSubmit(properties.getProperty("username"), properties.getProperty("password"), UserHomePage.class);
        userHomePage.waitForPageToLoad();
    }
}
