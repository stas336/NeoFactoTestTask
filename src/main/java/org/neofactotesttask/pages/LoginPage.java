package org.neofactotesttask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    private final By emailInput;
    private final By passwordInput;
    private final By loginButton;
    private final By messageText;

    public LoginPage(String url) {
        super(url);
        this.emailInput = By.id("email");
        this.passwordInput = By.id("password");
        this.loginButton = By.id("login");
        this.messageText = By.id("message");
    }

    public void login(String email, String password) {
        open();

        getEmail().clear();
        getPassword().clear();

        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        getLoginButton().click();
    }

    public WebElement getEmail() {
        return driver.findElement(emailInput);
    }

    public WebElement getPassword() {
        return driver.findElement(passwordInput);
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }

    public WebElement getMessage() {
        return driver.findElement(messageText);
    }

    public boolean isPageOpened() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOfAllElements(getEmail(), getPassword(), getLoginButton()));
            return true;
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }
}
