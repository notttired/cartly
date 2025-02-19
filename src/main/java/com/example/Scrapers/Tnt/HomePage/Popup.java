package com.example.Scrapers.Tnt.HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

@Component
public class Popup {
    private final WebDriver driver;
    private final By closePopupBy = By.id("closeActivityPop");

    @Autowired
    public Popup(WebDriver driver) {
        this.driver = driver;
    }

    public void closePopup(String postalCode) {
        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(closePopupBy));
        } catch (Exception e) {
        }
        if (!driver.findElements(closePopupBy).isEmpty()) {
            driver.findElement(closePopupBy).click();
        }
    }
}
