package Scrapers.Tnt.SearchedPage;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Scrapers.Tnt.SearchedPage.ItemClasses.Item;
import Scrapers.Tnt.SearchedPage.ItemExtractors.AItemExtractor;
import Scrapers.Tnt.SearchedPage.ItemExtractors.ItemExtractorNormal;
import Scrapers.Tnt.SearchedPage.ItemExtractors.ItemExtractorSale;

public class SearchContent {

    private final WebDriver driver;
    private final By itemRoot = By.xpath("//*[starts-with(@class, 'item-root')]");
    private final ArrayList<AItemExtractor> extractors = new ArrayList<>();

    public SearchContent(WebDriver driver) {
        this.driver = driver;
        extractors.add(new ItemExtractorNormal());
        extractors.add(new ItemExtractorSale());
        // may add check that we're on the right page
    }

    public ArrayList<Item> captureItems() {
        ArrayList<Item> items = new ArrayList<>();
        for (WebElement item : driver.findElements(itemRoot)) {
            for (AItemExtractor extractor : extractors) {
                if (extractor.canExtract(item)) {
                    items.add(extractor.extractItem(item));
                    break;
                }
            }
        }
        return items;
    }
}