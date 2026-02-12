package org.neofactotesttask.regression;

import org.neofactotesttask.pages.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.neofactotesttask.BaseTest;

import static org.neofactotesttask.constant.TestGroup.REGRESSION;

public class TestLogin extends BaseTest {
    @Autowired
    private LoginPage loginPage;

    @Test(groups = REGRESSION)
    public void loginWithInvalidEmail() {
        loginPage.login("invalidEmail", "password");

        Assert.assertEquals(loginPage.getMessage().getText(), "invalid email", "Expected invalid email message");
    }

    @Test(groups = REGRESSION)
    public void loginWithIncorrectEmail() {
        loginPage.login("incorrectEmail", "password");

        Assert.assertEquals(loginPage.getMessage().getText(), "enter correct email", "Expected correct email prompt");
    }

    @Test(groups = REGRESSION)
    public void loginWithEmptyCredentials() {
        loginPage.login("", "");

        Assert.assertTrue(loginPage.getMessage().getText().isEmpty());
    }

    @Test(groups = REGRESSION)
    public void loginWithEmptyPassword() {
        loginPage.login("email", "");

        Assert.assertTrue(loginPage.getMessage().getText().isEmpty());
    }

    @Test(groups = REGRESSION)
    public void loginWithEmptyEmail() {
        loginPage.login("", "password");

        Assert.assertTrue(loginPage.getMessage().getText().isEmpty());
    }

    @Test(groups = REGRESSION)
    public void verifyUserIsOnLoginPage() {
        String title = "Log in to VMD-SERAPIS-01";

        loginPage.open();

        Assert.assertEquals(driver.getTitle(), title, String.format("Expected title '%s'", title));
        Assert.assertTrue(loginPage.getEmail().isDisplayed());
        Assert.assertTrue(loginPage.getPassword().isDisplayed());
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
    }
}
