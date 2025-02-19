package com.example.Services;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Scrapers.Tnt.HomePage.Location;
import com.example.Scrapers.Tnt.HomePage.SearchBar;
import com.example.Scrapers.Tnt.SearchedPage.ItemClasses.Item;
import com.example.Scrapers.Tnt.SearchedPage.SearchContent;
import com.example.Scrapers.Tnt.HomePage.Popup;

@Service
public class TntHomePageService {
    private final Location location;
    private final SearchBar searchBar;
    private final SearchContent searchContent;
    private final Popup popup;
    
    @Autowired
    public TntHomePageService(Location location, SearchBar searchBar, SearchContent searchContent, Popup popup) {
        this.popup = popup;
        this.location = location;
        this.searchBar = searchBar;
        this.searchContent = searchContent;
    }

    public void inputLocation(String postalCode) {
        this.location.openLocation().setLocation(postalCode).confirmLocation();
    }

    public void closePopup(String postalCode) {
        this.popup.closePopup(postalCode);
    }

    public void search(String itemName) {
        this.searchBar.openSearchBar().search(itemName);
    }

    public ArrayList<Item> captureItems() {
        return this.searchContent.captureItems();
    }

    public ArrayList<Item> scrape(String postalCode, String itemName) {
        System.out.println("closing");
        this.closePopup(postalCode); // may not always be necessary
        System.out.println("inputting");
        this.inputLocation(postalCode);
        System.out.println("closing2");
        this.closePopup(postalCode);
        System.out.println("searching");
        this.search(itemName);
        return this.captureItems();
    }
}