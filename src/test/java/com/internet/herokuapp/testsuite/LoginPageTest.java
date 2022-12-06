package com.internet.herokuapp.testsuite;


import com.internet.herokuapp.pages.LoginPage;
import com.internet.herokuapp.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    LoginPage loginPage = new LoginPage();

    @Test
    public void UserShouldLoginSuccessfullyWithValidCredentials() {
        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getLoginTextMessage(), "Secure Area", "Text message not fount");
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        loginPage.enterUserName("tomsmith1");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getUserNameErrorMessage(), "Your username is invalid!\n×", "Error message not fount");
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), "Your password is invalid!\n×", "Error message not fount");
    }
}
