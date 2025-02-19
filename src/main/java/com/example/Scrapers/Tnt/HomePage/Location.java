package com.example.Scrapers.Tnt.HomePage;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.openqa.selenium.WebElement;

@Component
public class Location {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @Autowired
    public Location(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // may add check that we're on the right page
    }

    private final By inputDialogBy = By.id("deliverTo");
    private final By inputBarBy = By.name("postcode");
    private final By inputBarConfirmBy = By.xpath("//*[starts-with(@class, 'deliverCss-bottomButton')]");

    public Location openLocation() {
        System.out.println("1");
        wait.until(ExpectedConditions.elementToBeClickable(inputDialogBy));
        try {
            driver.findElement(inputDialogBy).click();
        } catch (Exception e) {}
        return this;
    }

    public Location setLocation(String address) {
        System.out.println("2");
        WebElement inputBar = wait.until(ExpectedConditions.presenceOfElementLocated(inputBarBy));
        inputBar.sendKeys(address);
        return this;
    }

    public void confirmLocation() {
        System.out.println("3");
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(inputBarConfirmBy));
        confirmButton.click();
    }
}