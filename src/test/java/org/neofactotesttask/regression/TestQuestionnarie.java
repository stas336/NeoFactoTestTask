package org.neofactotesttask.regression;

import org.neofactotesttask.pages.QuestionnariePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import org.neofactotesttask.BaseTest;

import static org.neofactotesttask.constant.TestGroup.REGRESSION;

public class TestQuestionnarie extends BaseTest {
    @Autowired
    private QuestionnariePage questionnariePage;

    @Test(groups = REGRESSION)
    public void selectNotSelectedResponses() {
        questionnariePage.open();
        clickUncheckedInputs();
    }

    private void clickUncheckedInputs() {
        questionnariePage.getTableRows()
                .forEach(row -> row.findElements(By.cssSelector("input"))
                .stream()
                .filter(input -> !input.isSelected())
                .findFirst()
                .ifPresent(WebElement::click));
    }
}
