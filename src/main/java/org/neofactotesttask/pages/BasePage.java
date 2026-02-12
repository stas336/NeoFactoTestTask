package org.neofactotesttask.pages;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class BasePage {
    private final String url;

    @Autowired
    protected WebDriver driver;

    protected BasePage(String url) {
        this.url = url;
    }

    public void open() {
        if (!isPageOpened()) {
            driver.get(url);
        }
    }

    public abstract boolean isPageOpened();
}
