package com.example.Services;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Scrapers.Tnt.SearchedPage.ItemClasses.Item;

@Service
public class MainService {
    private final TntService tntService;

    @Autowired
    public MainService(TntService tntService) {
        this.tntService = tntService;
    }

    public ArrayList<Item> scrapeTnt(String postalCode, String itemName) {
        return tntService.scrapeItems(postalCode, itemName);
    }
}