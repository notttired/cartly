package com.example.Scrapers.Tnt.HomePage;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Location {
    private final WebDriver driver;
    private WebDriverWait wait;

    @Autowired
    public Location(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // may add check that we're on the right page
    }

    private final By inputDialogBy = By.id("deliverTo");
    private final By inputBarBy = By.name("postcode");
    private final By inputBarConfirmBy = By.id(".deliverCss-bottomButton-eoK");

    public Location openLocation() {
        System.out.println("Waiting");
        wait.until(ExpectedConditions.elementToBeClickable(inputDialogBy));
        System.out.println("finished");
        driver.findElement(inputDialogBy).click();
        return this;
    }

    public Location setLocation(String address) {
        wait.until(ExpectedConditions.elementToBeClickable(inputBarBy));
        System.out.println("Setting location to: " + address);
        driver.findElement(inputBarBy).sendKeys(address);
        return this;
    }

    public void confirmLocation() {
        wait.until(ExpectedConditions.elementToBeClickable(inputBarConfirmBy));
        driver.findElement(inputBarConfirmBy).click();
    }
}