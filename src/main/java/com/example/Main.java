package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Services.MainService;


@RestController
@SpringBootApplication
public class Main {
    private final MainService mainService;

    @Autowired
    public Main(MainService mainService) {
        this.mainService = mainService;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }


    @GetMapping("/")
    public void scrapeLocationTest() {
        mainService.scrapeTnt("L5V", "meat");

    }

    // @PostMapping("/tnt/scrape")
    // public void scrapeLocation(@RequestBody String postalCode, String itemName) {
    //     mainService.scrapeTnt(postalCode, itemName);
    //     System.out.println("Scraping");
    // }
}