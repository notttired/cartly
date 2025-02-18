package Scrapers.Tnt.SearchedPage.ItemExtractors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Scrapers.Tnt.SearchedPage.ItemClasses.Item;

public abstract class AItemExtractor {
    public final By itemTitleBy = By.xpath("//*[starts-with(@class, 'item-name')]");

    public abstract boolean canExtract(WebElement element);
    public abstract Item extractItem(WebElement itemElement);
}