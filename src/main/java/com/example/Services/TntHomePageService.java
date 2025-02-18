package com.example.Services;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.Scrapers.Tnt.HomePage.Location;
import com.example.Scrapers.Tnt.HomePage.SearchBar;
import com.example.Scrapers.Tnt.SearchedPage.ItemClasses.Item;
import com.example.Scrapers.Tnt.SearchedPage.SearchContent;

@Service
public class TntHomePageService {
    private final Location location;
    private final SearchBar searchBar;
    private final SearchContent searchContent;
    private final WebDriver driver;
    
    @Autowired
    public TntHomePageService(Location location, SearchBar searchBar, SearchContent searchContent, WebDriver driver) {
        this.location = location;
        this.searchBar = searchBar;
        this.searchContent = searchContent;
        this.driver = driver;
        this.driver.get("https://www.tntsupermarket.com/");
    }

    public void inputLocation(String postalCode) {
        this.location.openLocation().setLocation(postalCode).confirmLocation();
    }

    public void search(String itemName) {
        this.searchBar.openSearchBar().search(itemName);
    }

    public ArrayList<Item> scrape() {
        return this.searchContent.captureItems();
    }

    public ArrayList<Item> scrape(String postalCode, String itemName) {
//        this.inputLocation(postalCode);
        this.search(itemName);
        return this.scrape();
    }
}