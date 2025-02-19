package com.example.Scrapers.Tnt.SearchedPage;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Scrapers.Tnt.SearchedPage.ItemClasses.Item;
import com.example.Scrapers.Tnt.SearchedPage.ItemExtractors.AItemExtractor;
import com.example.Scrapers.Tnt.SearchedPage.ItemExtractors.ItemExtractorNormal;
import com.example.Scrapers.Tnt.SearchedPage.ItemExtractors.ItemExtractorSale;

@Component
public class SearchContent {

    private final WebDriver driver;
    private final By itemRoot = By.xpath("//*[starts-with(@class, 'item-root')]");
    private final ArrayList<AItemExtractor> extractors = new ArrayList<>();

    @Autowired
    public SearchContent(WebDriver driver) {
        this.driver = driver;
        extractors.add(new ItemExtractorNormal());
        extractors.add(new ItemExtractorSale());
        // may add check that we're on the right page
    }

    public ArrayList<Item> captureItems() {
        ArrayList<Item> items = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemRoot));
        for (WebElement item : driver.findElements(itemRoot)) {
            for (AItemExtractor extractor : extractors) {
                if (extractor.canExtract(item)) {
                    items.add(extractor.extractItem(item));
                    break;
                }
            }
        }
        System.out.println("Items captured: " + items.size());
        return items;
    }
}