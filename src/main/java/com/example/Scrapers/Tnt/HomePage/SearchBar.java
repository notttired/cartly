package com.example.Scrapers.Tnt.HomePage;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Scrapers.Tnt.SearchedPage.SearchContent;

@Component
public class SearchBar {
    private final WebDriver driver;
    private final By searchBarUnclickedBy = By.xpath("//*[contains(@class, 'swiper-slide')]/div[1]");
    // use contains over starts with
    private final By searchBarText = By.xpath("//*[starts-with(@class, 'textInput-input')]");

    @Autowired
    public SearchBar(WebDriver driver) {
        this.driver = driver;
        // Optional: Validate you're on the correct page
    }

    public SearchBar openSearchBar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("opening Searchbar");
        wait.until(ExpectedConditions.presenceOfElementLocated(searchBarUnclickedBy));
        try {
            driver.findElement(searchBarUnclickedBy).click();
        } catch (Exception err) {

        }
        return this;
    }

    public SearchContent search(String search) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("Inputting search");
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBarText));
        driver.findElement(searchBarText).sendKeys(search);
        driver.findElement(searchBarText).submit();
        // Optionally, add a wait for the search results to load here
        return new SearchContent(this.driver);
    }
}