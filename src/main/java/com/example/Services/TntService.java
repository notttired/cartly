package com.example.Services;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Scrapers.Tnt.SearchedPage.ItemClasses.Item;

@Service
public class TntService {
    private final TntHomePageService tntHomePageService;

    @Autowired
    public TntService(TntHomePageService tntHomePageService) {
        this.tntHomePageService = tntHomePageService;
    }

    public ArrayList<Item> scrapeItems(String postalCode, String itemName) {
        return tntHomePageService.scrape(postalCode, itemName);
    }
}