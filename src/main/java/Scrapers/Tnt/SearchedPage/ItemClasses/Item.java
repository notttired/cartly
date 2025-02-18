package Scrapers.Tnt.SearchedPage.ItemClasses;

public abstract class Item {
    private String itemName;
    private float itemPriceCurrent;

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getItemPrice() {
        return this.itemPriceCurrent;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPriceCurrent = itemPrice;
    }
}
