package org.neofactotesttask.smoke;

import org.neofactotesttask.pages.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.neofactotesttask.BaseTest;

import static org.neofactotesttask.constant.TestGroup.SMOKE;

public class TestLogin extends BaseTest {
    @Autowired
    private LoginPage loginPage;

    @Test(groups = SMOKE)
    public void loginWithCorrectCredentials() {
        loginPage.login("email", "password");

        Assert.assertEquals(loginPage.getMessage().getText(), "success", "Expected successful login message");
    }
}
