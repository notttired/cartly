package com.example.Scrapers.Tnt.SearchedPage.ItemExtractors;
import org.openqa.selenium.WebElement;

import com.example.Scrapers.Tnt.SearchedPage.ItemClasses.ItemNormal;
import com.example.Scrapers.Tnt.SearchedPage.ItemExtractors.PriceExtractors.PriceExtractorNormal;

public class ItemExtractorNormal extends AItemExtractor {

    @Override
    public boolean canExtract(WebElement element) {
        PriceExtractorNormal priceExtractor = new PriceExtractorNormal();
        return priceExtractor.canExtractPrice(element);
    }

    @Override
    public ItemNormal extractItem(WebElement itemElement) {
        // implement
        PriceExtractorNormal priceExtractor = new PriceExtractorNormal();
        
        String name = itemElement.findElement(this.itemTitleBy).getText();
        float itemPrice = priceExtractor.extractPrice(itemElement);

        ItemNormal item = new ItemNormal();
        item.setItemName(name);
        item.setItemPrice(itemPrice);
        return item;
    }
}