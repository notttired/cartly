package com.example.Scrapers.Tnt.SearchedPage.ItemExtractors.PriceExtractors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class APriceExtractor {
    private final By wholePriceBy = By.xpath("./span[2]"); // may have issues
    private final By decimalPriceBy = By.xpath("./span[4]");

    protected abstract boolean canExtractPrice(WebElement itemElement);

    public float extractPriceBase(WebElement itemElement, By priceContainerBy) {
        WebElement priceContainer = itemElement.findElement(priceContainerBy);
        String wholePrice = priceContainer.findElement(wholePriceBy).getText();
        String decimalPrice = priceContainer.findElement(decimalPriceBy).getText();
        String priceText = wholePrice + "." + decimalPrice;
        return Float.parseFloat(priceText);
    }
}