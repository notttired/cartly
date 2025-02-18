package Scrapers.Tnt.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Location {
    private final WebDriver driver;

    public Location(WebDriver driver, String address) {
        this.driver = driver;
        // may add check that we're on the right page
    }

    private final By InputDialogBy = By.id("deliverTo");
    private final By InputBarBy = By.id("38f8b001-3ebc-45b5-a6ad-3952c13ce112");
    private final By InputBarConfirmBy = By.id(".deliverCss-bottomButton-eoK");

    public Location openLocation() {
        driver.findElement(InputDialogBy).click();
        return this;
    }

    public Location setLocation(String location) {
        driver.findElement(InputBarBy).sendKeys(location);
        return this;
    }

    public void confirmLocation() {
        driver.findElement(InputBarConfirmBy).click();
    }
}