package Scrapers.Tnt.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Scrapers.Tnt.SearchedPage.SearchContent;

public class SearchBar {
    private final WebDriver driver;

    public SearchBar(WebDriver driver) {
        this.driver = driver;
        // may add check that we're on the right page
    }

    private final By searchBarUnclickedBy = By.className("searchBar-fakeInput-PVR");
    private final By searchBarText = By.className("searchBar-holderText-3yf");

    public SearchBar openSearchBar() {
        driver.findElement(searchBarUnclickedBy).click();
        return this;
    }

    public SearchContent setSearch(String search) {
        driver.findElement(searchBarText).sendKeys(search);
        driver.findElement(searchBarText).submit(); // ensure this is correct
        return new SearchContent(this.driver);
    }
}
