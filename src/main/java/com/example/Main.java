package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import com.example.Scrapers.Tnt.SearchedPage.ItemClasses.Item;
import com.example.Services.MainService;


@RestController
@SpringBootApplication
public class Main {
    private final MainService mainService;

    @Autowired
    public Main(MainService mainService) {
        this.mainService = mainService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    @GetMapping("/tnt/scrape")
    public ArrayList<Item> scrapeLocationTest() {
        ArrayList<Item> items = mainService.scrapeTnt("L6V", "chicken");
        System.out.println("Items captured: " + items.size());
        return items;
    }
}