package com.example.Scrapers.Tnt.HomePage;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DirectSearch {
    private final WebDriver driver;

    @Autowired
    public DirectSearch(WebDriver driver) {
        this.driver = driver;
    }

    public void search(String itemName) {
        driver.get("https://www.tntsupermarket.com/eng/search.html?query=" + itemName);
    }
}
