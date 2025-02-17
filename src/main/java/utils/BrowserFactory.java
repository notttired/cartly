package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
    
    public static WebDriver getDriver(String browser) {
        if (browser.equals("chrome")) {
            return new ChromeDriver();
        }
        // Add other browsers if needed
        return null;
    }
}
