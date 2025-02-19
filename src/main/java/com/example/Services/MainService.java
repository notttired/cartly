package com.example.Services;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.openqa.selenium.WebDriver;

import com.example.Scrapers.Tnt.SearchedPage.ItemClasses.Item;

@Service
public class MainService {
    private final TntService tntService;
    private final WebDriver driver;

    @Autowired
    public MainService(TntService tntService, WebDriver driver) {
        this.tntService = tntService;
        this.driver = driver;
    }

    public ArrayList<Item> scrapeTnt(String postalCode, String itemName) {
        driver.get("https://www.tntsupermarket.com/");
        return tntService.scrapeItems(postalCode, itemName);
    }
}