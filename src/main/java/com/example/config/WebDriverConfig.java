package com.example.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebDriverConfig {

    @Bean(name = "driver")
    public WebDriver driver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=9230");
        System.setProperty("webdriver.chrome.driver","/Users/max/Desktop/chromedriver/chromedriver");
        return new ChromeDriver(options);
    }
}