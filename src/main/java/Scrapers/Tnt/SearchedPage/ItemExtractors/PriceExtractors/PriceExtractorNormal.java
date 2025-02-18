package Scrapers.Tnt.SearchedPage.ItemExtractors.PriceExtractors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PriceExtractorNormal extends APriceExtractor {

    private final By priceNormalContainerBy = By.xpath("//*[starts-with(@class, 'item-price')]");

    @Override
    public boolean canExtractPrice(WebElement itemElement) {
        return !itemElement.findElements(priceNormalContainerBy).isEmpty();
    }

    public float extractPrice(WebElement itemElement) {
        return extractPriceBase(itemElement, priceNormalContainerBy);
    }
}
