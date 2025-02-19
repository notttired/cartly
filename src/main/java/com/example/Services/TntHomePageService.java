package com.example.Services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Scrapers.Tnt.HomePage.Location;
import com.example.Scrapers.Tnt.SearchedPage.ItemClasses.Item;
import com.example.Scrapers.Tnt.SearchedPage.SearchContent;
import com.example.Scrapers.Tnt.HomePage.Popup;
import com.example.Scrapers.Tnt.HomePage.DirectSearch;

@Service
public class TntHomePageService {
    private final Location location;
    private final DirectSearch directSearch;
    private final SearchContent searchContent;
    private final Popup popup;
    
    @Autowired
    public TntHomePageService(Location location, DirectSearch directSearch, SearchContent searchContent, Popup popup) {
        this.popup = popup;
        this.location = location;
        this.directSearch = directSearch;
        this.searchContent = searchContent;
    }

    public void inputLocation(String postalCode) {
        this.location.openLocation().setLocation(postalCode).confirmLocation();
    }

    public void closePopup(String postalCode) {
        this.popup.closePopup(postalCode);
    }

    public void search(String itemName) {
        this.directSearch.search(itemName);
    }

    public ArrayList<Item> captureItems() {
        return this.searchContent.captureItems();
    }

    public ArrayList<Item> scrape(String postalCode, String itemName) {
        System.out.println("Closing popup");
        this.closePopup(postalCode); // may not always be necessary
        System.out.println("Inputting Location");
        this.inputLocation(postalCode);
        System.out.println("Searching for items");
        this.search(itemName);
        System.out.println("Closing popup");
        this.closePopup(postalCode);
        System.out.println("Capturing items");
        return this.captureItems();
    }
}