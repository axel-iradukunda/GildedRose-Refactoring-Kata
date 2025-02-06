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
                return AgedBrieUpdater.getInstance(item);
            case "Backstage passes to a TAFKAL80ETC concert":
                return BackstagePassesUpdater.getInstance(item);
            case "Sulfuras, Hand of Ragnaros":
                return RegularItemUpdater.getInstance(item); // Sulfuras does not change
            default:
                if (item.name.startsWith("Conjured")) {
                    return ConjuredItemUpdater.getInstance(item);
                } else {
                    return RegularItemUpdater.getInstance(item);
                }
        }
    }
}
