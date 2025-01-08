package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdater updater = createUpdater(item);
            updater.updateQuality();
            updater.updateSellIn();
            updater.handleExpired();
        }
    }

    private ItemUpdater createUpdater(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrieUpdater(item);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassesUpdater(item);
            case "Sulfuras, Hand of Ragnaros":
                return new RegularItemUpdater(item); // Sulfuras does not change
            default:
                if (item.name.startsWith("Conjured")) {
                    return new ConjuredItemUpdater(item);
                } else {
                    return new RegularItemUpdater(item);
                }
        }
    }
}
