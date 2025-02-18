package Scrapers.Tnt.SearchedPage.ItemExtractors;
import org.openqa.selenium.WebElement;

import Scrapers.Tnt.SearchedPage.ItemClasses.Item;
import Scrapers.Tnt.SearchedPage.ItemClasses.ItemSale;
import Scrapers.Tnt.SearchedPage.ItemExtractors.PriceExtractors.PriceExtractorNormal;
import Scrapers.Tnt.SearchedPage.ItemExtractors.PriceExtractors.PriceExtractorSale;

public class ItemExtractorSale extends AItemExtractor {

    @Override
    public boolean canExtract(WebElement element) {
        PriceExtractorNormal priceExtractor = new PriceExtractorNormal();
        return priceExtractor.canExtractPrice(element);
    }

    @Override
    public Item extractItem(WebElement itemElement) {
        // implement
        PriceExtractorSale priceExtractor = new PriceExtractorSale();
        
        String name = itemElement.findElement(this.itemTitleBy).getText();
        float[] itemPrices = priceExtractor.extractPrice(itemElement);
        float itemPrice = itemPrices[0];
        float itemPricePrev = itemPrices[1];

        ItemSale item = new ItemSale();
        item.setItemName(name);
        item.setItemPrice(itemPrice);
        item.setItemPricePrev(itemPricePrev);
        return item;
    }
}