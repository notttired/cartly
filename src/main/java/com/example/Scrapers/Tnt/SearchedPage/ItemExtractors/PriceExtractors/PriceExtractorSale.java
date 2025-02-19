package com.example.Scrapers.Tnt.SearchedPage.ItemExtractors.PriceExtractors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PriceExtractorSale extends APriceExtractor {

    private final By priceCurrentContainerBy = By.xpath("//div[starts-with(@class, 'item-hasPrice')]");
    private final By priceWasContainerBy = By.xpath("//div[starts-with(@class, 'item-wasPrice')]");
    
    @Override
    public boolean canExtractPrice(WebElement itemElement) {
        return !itemElement.findElements(priceCurrentContainerBy).isEmpty();
    }

    public float[] extractPrice(WebElement itemElement) {
        float[] out = {extractPriceBase(itemElement, priceCurrentContainerBy), extractPriceBase(itemElement, priceWasContainerBy)};
        return out;
        // return two types, not one
    }
}