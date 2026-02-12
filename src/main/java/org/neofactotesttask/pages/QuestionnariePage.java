package org.neofactotesttask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class QuestionnariePage extends BasePage {
    private final By table;
    private final By rows;

    public QuestionnariePage(String url) {
        super(url);
        this.table = By.cssSelector("table");
        this.rows = By.cssSelector("tbody tr");
    }

    public WebElement getTable() {
        return driver.findElement(table);
    }

    public List<WebElement> getTableRows() {
        return getTable().findElements(rows);
    }

    public boolean isPageOpened() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOf(getTable()));
            return true;
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }
}
