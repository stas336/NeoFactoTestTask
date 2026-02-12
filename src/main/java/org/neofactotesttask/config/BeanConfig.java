package org.neofactotesttask.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.neofactotesttask.pages.LoginPage;
import org.neofactotesttask.pages.QuestionnariePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class BeanConfig {
    @Bean
    public WebDriver chromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @Bean
    public LoginPage loginPage() {
        return new LoginPage(Objects.requireNonNull(getClass().getClassLoader().getResource("pages/login.html")).toExternalForm());
    }

    @Bean
    public QuestionnariePage questionnariePage() {
        return new QuestionnariePage(Objects.requireNonNull(getClass().getClassLoader().getResource("pages/questionnarie.html")).toExternalForm());
    }
}
