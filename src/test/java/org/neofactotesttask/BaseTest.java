package org.neofactotesttask;

import org.neofactotesttask.config.BeanConfig;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(
        classes = BeanConfig.class
)
public class BaseTest extends AbstractTestNGSpringContextTests {
    @Autowired
    protected WebDriver driver;
}
