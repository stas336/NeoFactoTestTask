# NeoFactoTestTask

Usage (build project and run all tests):
```
mvn clean install
```

Question 1:
See [TestLogin](/src/test/java/org/neofactotesttask/smoke/TestLogin.java) in smoke and [TestLogin](/src/test/java/org/neofactotesttask/regression/TestLogin.java) in regression packages

Question 2:
See [TestQuestionnarie](/src/test/java/org/neofactotesttask/regression/TestQuestionnarie.java) in regression package

Question 3:
```
driver.findElements(By.cssSelector(“ul.ui-autocomplete-list li”)).get(4).click();
```